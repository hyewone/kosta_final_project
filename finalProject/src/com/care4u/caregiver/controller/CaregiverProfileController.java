package com.care4u.caregiver.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.care4u.caregiver.dao.CaregiverDaoInter;
import com.care4u.caregiver.vo.CaregiverProfileVO;

@Controller
public class CaregiverProfileController {

	@Autowired
	CaregiverDaoInter dao;

	// 간병인 프로필 등록폼
	@RequestMapping("/profileForm")
	public String insertProfileForm() {
		return "caregiverProfileForm";
	}

	// 간병인 프로필 등록
	@RequestMapping("/insertProfile")
	public ModelAndView insertProfile(@ModelAttribute("cpvo") CaregiverProfileVO cpvo, HttpServletRequest request) {
		// session.getAttribute(cno);
		int cno = 3;
		String cpagree = "Y";
		cpvo.setCno(cno);
		cpvo.setCpagree(cpagree);
		String img_path = "resources\\imgfile";
		String r_path = request.getRealPath("/");
		System.out.println("r_path : " + r_path);
		String oriFn = cpvo.getMultipartFile().getOriginalFilename();
		System.out.println("oriFn : " + oriFn);
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append("\\");
		path.append(oriFn);
		File f = new File(path.toString());
		try {
			cpvo.getMultipartFile().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		cpvo.setCpimg(oriFn);
		dao.insertCaregiverProfile(cpvo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("caregiverProfileComplete");
		return mav;
	}

	// 간병인 프로필 수정폼
	//caregiverProfileUpdateForm?cpno=5 로 테스트함
	@RequestMapping("/caregiverProfileUpdateForm")
	public String updateProfileForm(@RequestParam("cpno")int cpno, Model m) {
		//dao로부터 list or dto를 가져옴
		CaregiverProfileVO cpvo = dao.updateCaregiverSelectProfile(cpno);
		//view로 전송하기 위해 model 객체로 key,value값으로 지정
		m.addAttribute("cpvo", cpvo);
		return "caregiverProfileUpdateForm";
	}

	// 간병인 프로필 수정
	@RequestMapping("/updateProfile")
	public ModelAndView updateProfile(@ModelAttribute("cpvo") CaregiverProfileVO cpvo, HttpServletRequest request) {
		//cno,cpno 는 jsp에서 hidden하여 커맨드객체로 받을 수 있다.
		String img_path = "resources\\imgfile";
		String r_path = request.getRealPath("/");
		String oriFn = cpvo.getMultipartFile().getOriginalFilename();
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append("\\");
		path.append(oriFn);
		File f = new File(path.toString());
		try {
			cpvo.getMultipartFile().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		cpvo.setCpimg(oriFn);
		dao.updateCaregiverProfile(cpvo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("caregiverProfileComplete");
		return mav;
	}

}
