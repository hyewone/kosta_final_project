package com.care4u.caregiver.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.care4u.caregiver.dao.LoginDaoInter;
import com.care4u.caregiver.vo.LoginVO;

@Controller
public class LoginController {
	 private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	   @Autowired
	   private LoginDaoInter dao;

	   @RequestMapping("/loginForm")
	   public String viewForm() {
	      return "loginForm";
	   }	

	   @RequestMapping(value = "/login")
	   public ModelAndView loginCheck(@ModelAttribute("lvo") LoginVO lvo, HttpSession session) {
	      // boolean result = Service.loginCheck(vo, session);
	      int cnt = dao.loginCheck(lvo);
	      //id,uno,cno,pno 를 세션에 등록
	      ModelAndView mav = new ModelAndView();
	      if (cnt == 1) {
	    	  session.setAttribute("id", lvo.getId());
	         mav.setViewName("main");
	      } else if (cnt == 0) {
	         mav.setViewName("loginForm");
	      }
	      return mav;
	   }
	  
	   @RequestMapping(value = "/idchk2")
	   public ModelAndView idck(@ModelAttribute("lvo") LoginVO lvo, HttpSession session) throws UnsupportedEncodingException {
		  String uname = lvo.getUname();
		  String uemail = lvo.getUemail();
		  String uphone = lvo.getUphone();
		  URLEncoder.encode(uname, "UTF-8");
		  URLEncoder.encode(uemail , "UTF-8");
		  URLEncoder.encode(uphone , "UTF-8");
		  System.out.println("uname : "+uname);
		  System.out.println("uemail : "+uemail);
		  System.out.println("uphone : "+uphone);
	      String id = dao.idck(lvo);
	      StringBuffer sb = new StringBuffer();
	      ModelAndView mav = new ModelAndView();      
	      if (id == null) {
	         sb.append("<p style='color:blue'>");
	         sb.append(id).append("없음</p>");
	      } else if (id != null) {
	         sb.append("<p style='color:red'>");
	         sb.append(id).append("입니다</p>");
	      }
	      mav.addObject("msg", sb.toString());
	      mav.setViewName("resources");
	      return mav;
	   }
	   
/*	   @RequestMapping(value="/test")
	   public void test() {
		   int uno = 2;
		   LoginVO lvo = dao.test(uno);
		   
		   String uname = lvo.getUname();
		   String uemail = lvo.getUemail();
		   String uphone = lvo.getUphone();
		   System.out.println(uname);
		   System.out.println(uemail);
		   System.out.println(uphone);
	   }*/

	//
	//   @RequestMapping(value="/logout")
	//   public ModelAndView logout(HttpSession session) {
//	      Service.logout(session);
//	      ModelAndView mav = new ModelAndView();
//	      mav.setViewName("loginForm");
//	      return mav;
	//   }
//	      @RequestMapping(value = "/emp/get/{id}")
//	      public String login(Locale locale,Model model,@PathVariable("id") int id) {
//	         logger.info(""+id);
//	         Date date = new Date();
//	         DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//	         String formattedDate = dateFormat.format(date);
//	         model.addAttribute("serverTime", formattedDate);
//	         return "main";
//	      }
	//   @RequestMapping(value="/login")
	//   public String login(HttpServletRequest request,Model model) {
//	      
//	      return "login";
	//   }
	//   @RequestMapping(value="/logout")
	//   public String logout() {
//	      return "logout";
	//   }
	//   @RequestMapping(value="/denied")
	//   public String denied() {
//	      return "denied";
	//   }


}
