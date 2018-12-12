package com.care4u.caregiver.dao;

import com.care4u.caregiver.vo.CaregiverProfileVO;
import com.care4u.caregiver.vo.CaregiverVO;
import com.care4u.caregiver.vo.ContractVO;
import com.care4u.caregiver.vo.MonthlyVO;

public interface CaregiverDaoInter {
	
	//������ ��� 
	public void insertCaregiver(CaregiverVO cvo);
	
	//������ ������ ���
	public void insertCaregiverProfile(CaregiverProfileVO cpvo);
	
	//������ �����ʼ����� �ҷ��� ����
	public CaregiverProfileVO updateCaregiverSelectProfile(int cpno);
		
	//������������ ����
	public void updateCaregiverProfile(CaregiverProfileVO cpvo);
	
	//cno�� �̿��� contract�� conno ��������
	public int getConno(int cno);
	
	//������ ������û
	public void insertCaregiverMontly(MonthlyVO mvo);
	
	//������ ���������� �ҷ��� ����
	public MonthlyVO updateCaregiverMontly(int monno);
	
	//������ ��� ����Ʈ
	public ContractVO selectCareerList(int cno);
	
}
