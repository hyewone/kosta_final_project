package com.care4u.caregiver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.care4u.caregiver.dao.CaregiverDaoInter;
import com.care4u.caregiver.vo.MonthlyVO;

@Controller
public class MonthlyController {

	@Autowired
	CaregiverDaoInter dao;

	// ���� ��û��
	@RequestMapping("/monthlyForm")
	public String insertMonthlyForm() {
		return "monthlyForm";
	}

	// ���� ��û
	@RequestMapping("/requestMonthly")
	public ModelAndView insertMonthly(@ModelAttribute("monvo") MonthlyVO monvo) {
		// cno�� ���ǿ� ����ְ�
		int cno = 3;
		monvo.setCno(cno);
		// monstate �⺻��
		String monstate = "N";
		monvo.setMonstate(monstate);
		int conno = dao.getConno(cno);
		monvo.setConno(conno);
		ModelAndView mav = new ModelAndView();
		dao.insertCaregiverMontly(monvo);
		mav.setViewName("monthlyComplete");
		return mav;
	}

	// ���� ������
	@RequestMapping("/monthlyUpdateForm")
	public String updateMonthlyForm(@RequestParam("monno")int monno, Model m) {
		//dao�κ��� list or dto�� ������
		MonthlyVO monvo = dao.updateCaregiverMontly(monno);
		//view�� �����ϱ� ���� model ��ü�� key,value������ ����
		m.addAttribute("monvo", monvo);
		return "monthlyUpdateForm";
	}
	
	// ���� ����
	@RequestMapping("/requestUpdateMonthly")
	public ModelAndView updateMonthlyForm(@ModelAttribute("monvo") MonthlyVO monvo) {
		//���������� �Ѿ���� �����͸� Ŀ�ǵ尴ü�� �޾� ó��
		// cno�� ���ǿ� ����ְ�
		int cno = 3;
		monvo.setCno(cno);
		String monstate = "N";
		monvo.setMonstate(monstate);
		//conno�� jsp�� �������� ���� �����Ƿ� Ŀ�ǵ尴ü�� ���� �Ѿ�´�
		//�����ΰ� �������̺��� 1:n�̹Ƿ� update�� �ƴ� insert �ؾ���(monno�� ���κο���)
		dao.insertCaregiverMontly(monvo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("monthlyComplete");
		return mav;
	}
}
