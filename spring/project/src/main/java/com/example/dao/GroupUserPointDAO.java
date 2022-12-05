package com.example.dao;

import java.util.List;

import com.example.domain.GroupUserPointVO;

public interface GroupUserPointDAO {
	public List<GroupUserPointVO> list();
	public GroupUserPointVO read(String group_point_code,String group_user_point_id);
	public void isnert(String group_point_code,String group_user_point_id);
	public void update(String group_point_code,String group_user_point_id,int group_user_point);
	public void delete(String group_point_code,String group_user_point_id);
	
}
