package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.GroupVO;

@Repository
public class GroupDAOImpl implements GroupDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.GroupMapper";

	@Override
	public List<GroupVO> list(String g_keyword) {
		return session.selectList(namespace+".list",g_keyword);
	}

	@Override
	public GroupVO read(String group_code) {
		
		return session.selectOne(namespace+".read",group_code);
	}

	@Override
	public void groupinsert(GroupVO vo) {


		
		session.insert(namespace+".groupinsert",vo);
		
	}

	@Override
	public void update(GroupVO vo) {
		session.update(namespace+".update",vo);
		
	}

	@Override
	public void delete(int group_code) {
		session.delete(namespace+".delete",group_code);
		
	}

	@Override
	public void groupleaderinsert(String g_user_id) {
		session.insert(namespace+".groupleaderinsert",g_user_id);
		
	}

	@Override
	public void memberinsert(String g_user_id) {
		session.insert(namespace+".memberinsert",g_user_id);
		
	}

}
