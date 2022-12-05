package com.example.dao;

import java.util.List;

import com.example.domain.GroupMemberVO;

public interface GroupMemberDAO {
	public List<GroupMemberVO> list(String gm_keyword);
	public List<GroupMemberVO> memberlist(String g_code);
	public GroupMemberVO read(int member_code);
	public GroupMemberVO membercheck(GroupMemberVO vo);
	public void groupinsert(String gm_user_id,String g_code);	
	public void memberinsert(GroupMemberVO vo);
	public void delete(int member_code);	

}
