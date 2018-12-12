package com.care4u.caregiver.vo;

import java.util.List;

public class ContractVO {
	private int conno,mno;
	private String condate,conaddr1,conaddr2,conperweek,
	conperhour,constartdate,conenddate,conagree,constate;
	private List<CareerVO> calist;
	
	public int getConno() {
		return conno;
	}
	public void setConno(int conno) {
		this.conno = conno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getCondate() {
		return condate;
	}
	public void setCondate(String condate) {
		this.condate = condate;
	}
	public String getConaddr1() {
		return conaddr1;
	}
	public void setConaddr1(String conaddr1) {
		this.conaddr1 = conaddr1;
	}
	public String getConaddr2() {
		return conaddr2;
	}
	public void setConaddr2(String conaddr2) {
		this.conaddr2 = conaddr2;
	}
	public String getConperweek() {
		return conperweek;
	}
	public void setConperweek(String conperweek) {
		this.conperweek = conperweek;
	}
	public String getConperhour() {
		return conperhour;
	}
	public void setConperhour(String conperhour) {
		this.conperhour = conperhour;
	}
	public String getConstartdate() {
		return constartdate;
	}
	public void setConstartdate(String constartdate) {
		this.constartdate = constartdate;
	}
	public String getConenddate() {
		return conenddate;
	}
	public void setConenddate(String conenddate) {
		this.conenddate = conenddate;
	}
	public String getConagree() {
		return conagree;
	}
	public void setConagree(String conagree) {
		this.conagree = conagree;
	}
	public String getConstate() {
		return constate;
	}
	public void setConstate(String constate) {
		this.constate = constate;
	}
	public List<CareerVO> getCalist() {
		return calist;
	}
	public void setCalist(List<CareerVO> calist) {
		this.calist = calist;
	}
}
