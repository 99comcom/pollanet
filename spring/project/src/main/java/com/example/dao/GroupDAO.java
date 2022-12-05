package com.example.dao;

import java.util.List;

import com.example.domain.GroupVO;

public interface GroupDAO {
	public List<GroupVO> list(String g_keyword);
	public GroupVO read(String group_code);
	public void groupinsert(GroupVO vo); //�׷����
	public void update(GroupVO vo);
	public void delete(int group_code);
	public void groupleaderinsert(String g_user_id); //�׷� ������ �׷��� ����
	public void memberinsert(String g_user_id); //�׷� ��� �߰�

}
