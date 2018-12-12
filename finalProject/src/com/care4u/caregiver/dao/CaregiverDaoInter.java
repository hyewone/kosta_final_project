package com.care4u.caregiver.dao;

import com.care4u.caregiver.vo.CaregiverProfileVO;
import com.care4u.caregiver.vo.CaregiverVO;
import com.care4u.caregiver.vo.ContractVO;
import com.care4u.caregiver.vo.MonthlyVO;

public interface CaregiverDaoInter {
	
	//간병인 등록 
	public void insertCaregiver(CaregiverVO cvo);
	
	//간병인 프로필 등록
	public void insertCaregiverProfile(CaregiverProfileVO cpvo);
	
	//간병인 프로필수정시 불러올 정보
	public CaregiverProfileVO updateCaregiverSelectProfile(int cpno);
		
	//간병인프로필 수정
	public void updateCaregiverProfile(CaregiverProfileVO cpvo);
	
	//cno를 이용해 contract의 conno 가져오기
	public int getConno(int cno);
	
	//간병인 월차신청
	public void insertCaregiverMontly(MonthlyVO mvo);
	
	//간병인 월차수정시 불러올 정보
	public MonthlyVO updateCaregiverMontly(int monno);
	
	//간병인 경력 리스트
	public ContractVO selectCareerList(int cno);
	
}
