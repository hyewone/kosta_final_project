package com.care4u.caregiver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.care4u.caregiver.dao.CaregiverDaoInter;
import com.care4u.caregiver.vo.CareerVO;
import com.care4u.caregiver.vo.ContractVO;

@Controller
public class CareerController {

	@Autowired
	CaregiverDaoInter dao;

	@RequestMapping("/")
	public String main() {
		return "index";
	}

	@RequestMapping("/caregiverMyCareerList")
	public String careerList(Model m) {
		// session���� ���� cno��
		int cno = 2;
		ContractVO conlist = dao.selectCareerList(cno);
		//castate�� ���� ��°��� �ٸ��� ����
		for (CareerVO e : conlist.getCalist()) {
			if (e.getCastate().equals("N")) {
				e.setCastate("�ٹ���");
			} else if (e.getCastate().equals("Y")) {
				e.setCastate("�ٹ�����");
			}
		}
		m.addAttribute("conlist", conlist);
		return "caregiverMyCareerList";
	}
	
	@RequestMapping("/downloadExcel")
	public ModelAndView downloadExcel(@RequestParam("cno") int cno) {
		//List<ShowVO> listShow = dao.listTboard();
		//�����ٿ� ��ư Ŭ���� cno�� jsp���� �Բ� �����־� �Ķ���ͷ� �޴´�.
		ContractVO conlist = dao.selectCareerList(cno);
		//���̸�, ���̸�, �𵨰��ּ�
		return new ModelAndView("excelView", "conlist" , conlist);
	}
}
