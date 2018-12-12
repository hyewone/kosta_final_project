package com.care4u.caregiver.vo;

import org.springframework.web.multipart.MultipartFile;

public class CaregiverVO {
	
	private int cno,uno;
	private String cidenimg,cbank,caccount,cdate,cstate;
	private MultipartFile multipartFile;
	//cidenimg 는 이미지파일명 저장될 변수
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getCidenimg() {
		return cidenimg;
	}
	public void setCidenimg(String cidenimg) {
		this.cidenimg = cidenimg;
	}
	public String getCbank() {
		return cbank;
	}
	public void setCbank(String cbank) {
		this.cbank = cbank;
	}
	public String getCaccount() {
		return caccount;
	}
	public void setCaccount(String caccount) {
		this.caccount = caccount;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getCstate() {
		return cstate;
	}
	public void setCstate(String cstate) {
		this.cstate = cstate;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
}
