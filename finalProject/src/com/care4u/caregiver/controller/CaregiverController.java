package com.care4u.caregiver.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.care4u.caregiver.dao.CaregiverDaoInter;
import com.care4u.caregiver.vo.CaregiverVO;

@Controller
public class CaregiverController {

	@Autowired
	CaregiverDaoInter dao;

	// ������ ��� ��û��
	@RequestMapping("/caregiverForm")
	public String insertCaregiverForm() {
		return "caregiverForm";
	}

	// ������ data insert
	// �������͸� Ŀ�ǵ尴ü�� �޾Ƽ�
	// dao�� ������ ����
	// session �̿�� �Ű��� ������Ʈ����
	@RequestMapping("/insertCaregiver")
	public ModelAndView insertCaregiver(@ModelAttribute("cvo") CaregiverVO cvo, HttpServletRequest request) {
		// session�� ���� ������ user��ȣ
		int uno = 3;
		String cstate = "N";
		cvo.setUno(uno);
		cvo.setCstate(cstate);
		// cvo�� uno�� set���־� cvo�뤊�� ����
		String img_path = "resources\\imgfile";
		String r_path = request.getRealPath("/");
		System.out.println("r_path : " + r_path);
		String oriFn = cvo.getMultipartFile().getOriginalFilename();
		System.out.println("oriFn : " + oriFn);
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append("\\");
		path.append(oriFn);
		File f = new File(path.toString());
		try {
			cvo.getMultipartFile().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		cvo.setCidenimg(oriFn);
		dao.insertCaregiver(cvo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("caregiverList");
		return mav;
	}
	/*
	 * @RequestMapping(value="/upsave3",method=RequestMethod.POST) public
	 * ModelAndView save2(@ModelAttribute("svo") ShowVO vo, HttpServletRequest
	 * request) { System.out.println("ddddzdzsefsfdf"); String img_path =
	 * "resources\\imgfile"; String r_path = request.getRealPath("/"); String oriFn
	 * = vo.getMultipartFile().getOriginalFilename(); StringBuffer path = new
	 * StringBuffer(); path.append(r_path).append(img_path).append("\\");
	 * path.append(oriFn); File f = new File(path.toString()); try {
	 * vo.getMultipartFile().transferTo(f); } catch (IllegalStateException |
	 * IOException e) { e.printStackTrace(); }
	 * vo.setPath(vo.getMultipartFile().getOriginalFilename()); dao.saveShow(vo);
	 * ModelAndView mav = new ModelAndView();
	 * mav.setViewName("redirect:/showlist?page=1"); return mav; }
	 */

}
