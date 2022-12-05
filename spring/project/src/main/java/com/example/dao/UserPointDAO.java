package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.UserPointVO;

public interface UserPointDAO {
	public List<UserPointVO> list();
	public UserPointVO read(String user_point_id);
	public void pointUpdate(String user_point_id,int getPoint);
	public void gradeUpdate(UserPointVO vo);
	public void Reginsert(UserPointVO vo);
	public void delete(String user_point_id);
	public int userRank(String user_point_id);
	public List<HashMap<String,Object>> rankList();
	public List<HashMap<String,Object>> rankListWeb(String search, int start, int num);
	public HashMap<String,Object> rankReadWeb(String user_id);
	public int userTotal();
	public HashMap<String,Object> rankRead(String user_id);
}
