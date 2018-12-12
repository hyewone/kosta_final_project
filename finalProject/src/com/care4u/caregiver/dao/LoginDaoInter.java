package com.care4u.caregiver.dao;

import com.care4u.caregiver.vo.LoginVO;

public interface LoginDaoInter {

	public int loginCheck(LoginVO vo);

	public String idck(LoginVO vo);
	
	public LoginVO test(int uno);

}
