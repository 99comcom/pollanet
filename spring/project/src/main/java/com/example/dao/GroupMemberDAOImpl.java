package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.GroupMemberVO;

@Repository
public class GroupMemberDAOImpl implements GroupMemberDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.GroupMemberMapper";
	
	@Override
	public List<GroupMemberVO> list(String gm_keyword) {
		return session.selectList(namespace+".list"+gm_keyword) ;
	}

	@Override
	public GroupMemberVO read(int member_code) {
		return session.selectOne(namespace+".read",member_code);
	}

	@Override
	public void groupinsert(String gm_user_id,String g_code) {
		HashMap<String,Object> map =new HashMap<>();
		map.put("gm_user_id", gm_user_id);
		map.put("g_code", g_code);
		System.out.println(".............."+gm_user_id+"..........."+g_code);
		session.insert(namespace+".groupinsert",map);
		
	}

	@Override
	public void memberinsert(GroupMemberVO vo) {
		session.insert(namespace+".memberinsert",vo);
		
	}

	@Override
	public void delete(int group_code) {
		session.delete(namespace+".delete"+group_code) ;
		
	}

	@Override
	public List<GroupMemberVO> memberlist(String g_code) {
		return session.selectList(namespace+".memberlist",g_code);
	}

	@Override
	public GroupMemberVO membercheck(GroupMemberVO vo) {
		
		return session.selectOne(namespace+".membercheck",vo);
	}
	

}
