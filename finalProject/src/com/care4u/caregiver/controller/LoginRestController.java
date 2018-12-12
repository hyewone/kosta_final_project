package com.care4u.caregiver.controller;

import javax.servlet.http.HttpSession;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.care4u.caregiver.vo.LoginVO;

@RestController
public class LoginRestController {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	 @RequestMapping(value="/mybatisList",produces = "application/text; charset=EUC-KR")
		public ResponseEntity<String> respList2(@ModelAttribute("lvo") LoginVO lvo, HttpSession session) throws UnsupportedEncodingException{
		/*String uname = URLEncoder.encode(lvo.getUname(), "EUC-KR");
		String duname = URLDecoder.decode(lvo.getUname(), "EUC-KR");*/
		 /*String uemail = URLEncoder.encode(lvo.getUemail(), "UTF-8");
		 String uphone = URLEncoder.encode(lvo.getUphone(), "UTF-8");
		 String duname = URLDecoder.decode(lvo.getUname(), "UTF-8");*/
		 System.out.println(lvo.getUemail());
		 System.out.println(lvo.getUphone());
		/* lvo.setUname(uname);
		 lvo.setUemail(uemail);
		 lvo.setUphone(uphone);*/
		 String id = null;
		 String msg = null;
		 StringBuffer sb = new StringBuffer();
			try {
				
				id = ss.selectOne("user.idck", lvo);
				
				 if (id == null) {
			         sb.append("<p style='color:red'>").append("일치하는 정보가 없습니다.</p>");
			         msg = sb.toString();
			      } else if (id != null) {
			         sb.append("<p style='color:blue'>").append("고객님 ID는 ");
			         sb.append(" "+id+" ").append(" 입니다.</p>");
			         msg = sb.toString();
			      }
				return new ResponseEntity<>(msg,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			}
		}
}
