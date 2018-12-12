package com.care4u.caregiver.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.care4u.caregiver.vo.CaregiverVO;

@RestController
public class CaregiverRestController {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	 @RequestMapping(value="/chkaccount",produces = "application/text; charset=EUC-KR")
		public ResponseEntity<String> respList2(@ModelAttribute("cvo") CaregiverVO cvo, HttpSession session) throws UnsupportedEncodingException{
		 System.out.println(cvo.getCaccount());
		 int cnt = 0;
		 String msg = null;
		 StringBuffer sb = new StringBuffer();
			try {
				
				cnt = ss.selectOne("caregiver.chkaccount", cvo);
				
				 if (cnt == 1) {
			         sb.append("<p style='color:red'>").append("이미 사용중인 계좌입니다.</p>");
			         msg = sb.toString();
			      } else if (cnt == 0) {
			         sb.append("<p style='color:blue'>").append("사용 가능한");
			         sb.append(" 계좌입니다.</p>");
			         msg = sb.toString();
			      }
				return new ResponseEntity<>(msg,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			}
		}

}
