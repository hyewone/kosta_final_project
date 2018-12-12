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

	// ������ ��û
	@Override
	public void insertCaregiver(CaregiverVO cvo) {
		ss.insert("caregiver.insertRequest", cvo);
	}
	
	// ������ ������ ���
	@Override
	public void insertCaregiverProfile(CaregiverProfileVO cpvo) {
		ss.insert("caregiver.insertProfile", cpvo);
	}

	// ������ ������ ������ �ҷ��� ����
	@Override
	public CaregiverProfileVO updateCaregiverSelectProfile(int cpno) {
		CaregiverProfileVO cpvo = ss.selectOne("caregiver.updateSelectProfile", cpno);
		return cpvo;
	}

	// ������ ������ ����
	@Override
	public void updateCaregiverProfile(CaregiverProfileVO cpvo) {
		ss.update("caregiver.updateProfile", cpvo);
	}

	// cno�����޹޾� cpno,mno, conno �� ��ȯ (������û�� �ʿ�)
	@Override
	public int getConno(int cno) {
		int conno = ss.selectOne("caregiver.getConno", cno);
		return conno;
	}

	// ������ ���� ��û �� ����
	@Override
	public void insertCaregiverMontly(MonthlyVO monvo) {
		ss.insert("caregiver.insertMonthly", monvo);
	}

	// ������ ���� ������ �ҷ��� ����
	@Override
	public MonthlyVO updateCaregiverMontly(int monno) {
		MonthlyVO monvo = ss.selectOne("caregiver.updateSelectMontly", monno);
		return monvo;
	}

	// ������ ��� ����Ʈ
	@Override
	public ContractVO selectCareerList(int cno) {
		ContractVO conlist = ss.selectOne("caregiver.selectCareerList", cno);
		return conlist;
	}

}
