package com.example.dao;

import java.util.List;

import com.example.domain.GroupPointGetVO;

public interface GroupPointGetDAO {
	public List<GroupPointGetVO> list();
	public void insert(GroupPointGetVO vo);

}
