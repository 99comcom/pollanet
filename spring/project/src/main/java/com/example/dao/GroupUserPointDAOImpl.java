package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.GroupUserPointVO;

@Repository
public class GroupUserPointDAOImpl implements GroupUserPointDAO{

	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.GroupUserPointMapper";
	
	
	@Override
	public List<GroupUserPointVO> list() {
		return session.selectList(namespace+".list");
	}

	@Override
	public GroupUserPointVO read(String group_point_code, String group_user_point_id) {
		HashMap<String,Object> map=new HashMap<>();
		map.put("group_point_code", group_point_code);
		map.put("group_user_point_id", group_user_point_id);
		return session.selectOne(namespace+".read",map);
	}

	@Override
	public void isnert(String group_point_code, String group_user_point_id) {
		HashMap<String,Object> map=new HashMap<>();
		map.put("group_point_code", group_point_code);
		map.put("group_user_point_id", group_user_point_id);
		session.insert(namespace+".insert",map);
		
	}

	@Override
	public void update(String group_point_code, String group_user_point_id,int group_user_point) {
		HashMap<String,Object> map=new HashMap<>();
		map.put("group_point_code", group_point_code);
		map.put("group_user_point_id", group_user_point_id);
		map.put("group_user_point", group_user_point);
		session.update(namespace+".update",map);
		
	}

	@Override
	public void delete(String group_point_code, String group_user_point_id) {
		HashMap<String,Object> map=new HashMap<>();
		map.put("group_point_code", group_point_code);
		map.put("group_user_point_id", group_user_point_id);
		session.delete(namespace+".delete",map);
		
	}

}
