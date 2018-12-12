package com.care4u.caregiver.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.care4u.caregiver.vo.LoginVO;

@Component
public class LoginDaoImple implements LoginDaoInter {

	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public int loginCheck(LoginVO lvo) {
		int cnt = ss.selectOne("user.login", lvo);
//	    String name = ss.selectOne("user.login", vo);
//	    return (name == null) ? false : true;
		return cnt;
	}

	@Override
	public String idck(LoginVO lvo) {
		String id = ss.selectOne("user.idck", lvo);
		return id;
	}

	@Override
	public LoginVO test(int uno) {
		LoginVO lvo = ss.selectOne("user.test",uno);
		return lvo;
	}
	
	
}
