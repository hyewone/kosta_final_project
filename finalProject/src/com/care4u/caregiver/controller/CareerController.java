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
		// session에서 얻어온 cno로
		int cno = 2;
		ContractVO conlist = dao.selectCareerList(cno);
		//castate에 따라 출력값이 다르게 해줌
		for (CareerVO e : conlist.getCalist()) {
			if (e.getCastate().equals("N")) {
				e.setCastate("근무중");
			} else if (e.getCastate().equals("Y")) {
				e.setCastate("근무종료");
			}
		}
		m.addAttribute("conlist", conlist);
		return "caregiverMyCareerList";
	}
	
	@RequestMapping("/downloadExcel")
	public ModelAndView downloadExcel(@RequestParam("cno") int cno) {
		//List<ShowVO> listShow = dao.listTboard();
		//엑셀다운 버튼 클릭시 cno를 jsp에서 함께 보내주어 파라미터로 받는다.
		ContractVO conlist = dao.selectCareerList(cno);
		//뷰이름, 모델이름, 모델값주소
		return new ModelAndView("excelView", "conlist" , conlist);
		//test
	}
}
