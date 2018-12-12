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

	// 월차 신청폼
	@RequestMapping("/monthlyForm")
	public String insertMonthlyForm() {
		return "monthlyForm";
	}

	// 월차 신청
	@RequestMapping("/requestMonthly")
	public ModelAndView insertMonthly(@ModelAttribute("monvo") MonthlyVO monvo) {
		// cno는 세션에 담겨있고
		int cno = 3;
		monvo.setCno(cno);
		// monstate 기본값
		String monstate = "N";
		monvo.setMonstate(monstate);
		int conno = dao.getConno(cno);
		monvo.setConno(conno);
		ModelAndView mav = new ModelAndView();
		dao.insertCaregiverMontly(monvo);
		mav.setViewName("monthlyComplete");
		return mav;
	}

	// 월차 수정폼
	@RequestMapping("/monthlyUpdateForm")
	public String updateMonthlyForm(@RequestParam("monno")int monno, Model m) {
		//dao로부터 list or dto를 가져옴
		MonthlyVO monvo = dao.updateCaregiverMontly(monno);
		//view로 전송하기 위해 model 객체로 key,value값으로 지정
		m.addAttribute("monvo", monvo);
		return "monthlyUpdateForm";
	}
	
	// 월차 수정
	@RequestMapping("/requestUpdateMonthly")
	public ModelAndView updateMonthlyForm(@ModelAttribute("monvo") MonthlyVO monvo) {
		//수정폼에서 넘어오는 데이터를 커맨드객체로 받아 처리
		// cno는 세션에 담겨있고
		int cno = 3;
		monvo.setCno(cno);
		String monstate = "N";
		monvo.setMonstate(monstate);
		//conno는 jsp에 히든으로 값이 있으므로 커맨드객체로 같이 넘어온다
		//간병인과 월차테이블은 1:n이므로 update가 아닌 insert 해야함(monno는 새로부여됨)
		dao.insertCaregiverMontly(monvo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("monthlyComplete");
		return mav;
	}
}
