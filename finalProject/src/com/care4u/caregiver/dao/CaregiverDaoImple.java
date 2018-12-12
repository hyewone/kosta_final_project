package com.care4u.caregiver.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.care4u.caregiver.vo.CaregiverProfileVO;
import com.care4u.caregiver.vo.CaregiverVO;
import com.care4u.caregiver.vo.ContractVO;
import com.care4u.caregiver.vo.MonthlyVO;

@Component
public class CaregiverDaoImple implements CaregiverDaoInter {

	@Autowired
	SqlSessionTemplate ss;

	// 간병인 신청
	@Override
	public void insertCaregiver(CaregiverVO cvo) {
		ss.insert("caregiver.insertRequest", cvo);
	}
	
	// 간병인 프로필 등록
	@Override
	public void insertCaregiverProfile(CaregiverProfileVO cpvo) {
		ss.insert("caregiver.insertProfile", cpvo);
	}

	// 간병인 프로필 수정시 불러올 정보
	@Override
	public CaregiverProfileVO updateCaregiverSelectProfile(int cpno) {
		CaregiverProfileVO cpvo = ss.selectOne("caregiver.updateSelectProfile", cpno);
		return cpvo;
	}

	// 간병인 프로필 수정
	@Override
	public void updateCaregiverProfile(CaregiverProfileVO cpvo) {
		ss.update("caregiver.updateProfile", cpvo);
	}

	// cno를전달받아 cpno,mno, conno 를 반환 (월차신청시 필요)
	@Override
	public int getConno(int cno) {
		int conno = ss.selectOne("caregiver.getConno", cno);
		return conno;
	}

	// 간병인 월차 신청 및 수정
	@Override
	public void insertCaregiverMontly(MonthlyVO monvo) {
		ss.insert("caregiver.insertMonthly", monvo);
	}

	// 간병인 월차 수정시 불러올 정보
	@Override
	public MonthlyVO updateCaregiverMontly(int monno) {
		MonthlyVO monvo = ss.selectOne("caregiver.updateSelectMontly", monno);
		return monvo;
	}

	// 간병인 경력 리스트
	@Override
	public ContractVO selectCareerList(int cno) {
		ContractVO conlist = ss.selectOne("caregiver.selectCareerList", cno);
		return conlist;
	}

}
