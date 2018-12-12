package com.care4u.caregiver.vo;

import org.springframework.web.multipart.MultipartFile;

public class CaregiverProfileVO {
	
	private int cpno,cno;
	private String cpname,cpimg,cpcareeryear,cpcareermonth,cpbirth,cploc,cpintroduce,cpagree;
	private MultipartFile multipartFile;
	
	public int getCpno() {
		return cpno;
	}
	public void setCpno(int cpno) {
		this.cpno = cpno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCpname() {
		return cpname;
	}
	public void setCpname(String cpname) {
		this.cpname = cpname;
	}
	public String getCpimg() {
		return cpimg;
	}
	public void setCpimg(String cpimg) {
		this.cpimg = cpimg;
	}
	public String getCpcareeryear() {
		return cpcareeryear;
	}
	public void setCpcareeryear(String cpcareeryear) {
		this.cpcareeryear = cpcareeryear;
	}
	public String getCpcareermonth() {
		return cpcareermonth;
	}
	public void setCpcareermonth(String cpcareermonth) {
		this.cpcareermonth = cpcareermonth;
	}
	public String getCpbirth() {
		return cpbirth;
	}
	public void setCpbirth(String cpbirth) {
		this.cpbirth = cpbirth;
	}
	public String getCploc() {
		return cploc;
	}
	public void setCploc(String cploc) {
		this.cploc = cploc;
	}
	public String getCpintroduce() {
		return cpintroduce;
	}
	public void setCpintroduce(String cpintroduce) {
		this.cpintroduce = cpintroduce;
	}
	public String getCpagree() {
		return cpagree;
	}
	public void setCpagree(String cpagree) {
		this.cpagree = cpagree;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
}
