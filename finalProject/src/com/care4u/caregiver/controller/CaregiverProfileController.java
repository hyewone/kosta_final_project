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

	// ������ ������ �����
	@RequestMapping("/profileForm")
	public String insertProfileForm() {
		return "caregiverProfileForm";
	}

	// ������ ������ ���
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

	// ������ ������ ������
	//caregiverProfileUpdateForm?cpno=5 �� �׽�Ʈ��
	@RequestMapping("/caregiverProfileUpdateForm")
	public String updateProfileForm(@RequestParam("cpno")int cpno, Model m) {
		//dao�κ��� list or dto�� ������
		CaregiverProfileVO cpvo = dao.updateCaregiverSelectProfile(cpno);
		//view�� �����ϱ� ���� model ��ü�� key,value������ ����
		m.addAttribute("cpvo", cpvo);
		return "caregiverProfileUpdateForm";
	}

	// ������ ������ ����
	@RequestMapping("/updateProfile")
	public ModelAndView updateProfile(@ModelAttribute("cpvo") CaregiverProfileVO cpvo, HttpServletRequest request) {
		//cno,cpno �� jsp���� hidden�Ͽ� Ŀ�ǵ尴ü�� ���� �� �ִ�.
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
