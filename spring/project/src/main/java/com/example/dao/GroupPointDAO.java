package com.example.dao;

import java.util.List;

import com.example.domain.GroupPointVO;

public interface GroupPointDAO {
	public List<GroupPointVO> list(String group_point_code);
	public GroupPointVO read(String group_point_code);
	public void insert(String group_point_code);
	public void delete(String group_point_code);
	public void update(int group_point,String group_point_code);

}
