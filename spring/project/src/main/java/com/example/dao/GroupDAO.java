package com.example.dao;

import java.util.List;

import com.example.domain.GroupVO;

public interface GroupDAO {
	public List<GroupVO> list(String g_keyword);
	public GroupVO read(String group_code);
	public void groupinsert(GroupVO vo); //그룹생성
	public void update(GroupVO vo);
	public void delete(int group_code);
	public void groupleaderinsert(String g_user_id); //그룹 생성시 그룹장 생성
	public void memberinsert(String g_user_id); //그룹 멤버 추가

}
