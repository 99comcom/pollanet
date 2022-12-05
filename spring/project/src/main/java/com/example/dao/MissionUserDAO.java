package com.example.dao;

import java.util.List;

import com.example.domain.MissionUserVO;

public interface MissionUserDAO {

	public List<MissionUserVO> list(String um_keyword, int um_start, int um_number);
	public List<MissionUserVO> userMissionList(String um_user_id, int um_start, int um_number);
	public MissionUserVO read(String user_mission_code);
	public void insert(MissionUserVO vo);
	public void update(MissionUserVO vo);
	public void delete(String user_mission_code);
	
	
}
