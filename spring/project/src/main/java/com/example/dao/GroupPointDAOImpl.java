package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.GroupPointVO;

@Repository
public class GroupPointDAOImpl implements GroupPointDAO{
	@Autowired
	SqlSession session;
	
	String namespace="com.example.mapper.GroupPointMapper";
	
	

	@Override
	public List<GroupPointVO> list(String group_point_code) {
		return session.selectList(namespace+".list",group_point_code);
	}


	@Override
	public void insert(String group_point_code) {
		session.insert(namespace+".insert",group_point_code);
		
	}

	@Override
	public void delete(String group_point_code) {
		session.delete(namespace+".delete",group_point_code);
		
	}

	@Override
	public GroupPointVO read(String group_point_code) {
		return session.selectOne(namespace+".read",group_point_code);
	}


	@Override
	public void update(int group_point, String group_point_code) {
		HashMap<String,Object> map=new HashMap<>();
		map.put("group_point", group_point);
		map.put("group_point_code", group_point_code);
		session.update(namespace+".update",map);
	}

}
