package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.MissionVO;

public interface MissionDAO {
	public List<MissionVO> list(String m_keyword, int m_start, int m_number); //�̼� �˻� �� ������
	public List<MissionVO> categorylist(String m_category, String m_sort,int m_start, int m_number); //���� �������� ī�װ� �� ������ũ ���� ����Ʈ
	public MissionVO read(int mission_code);
	public void insert(MissionVO vo);
	public void update(MissionVO vo);
	public void resultupdate(int mission_code);
	public void delete(int mission_code);
	public HashMap<String, Object> topmission(String m_sort);
	public HashMap<String, Object> topwmission(String m_sort);
	public MissionVO bestMission();
	public int clearMission(String um_user_id,int mission_code);
	public int clearMissionTotal(String um_user_id);
	public int listTotal();
}
