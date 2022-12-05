package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.GroupPointGetVO;

@Repository
public class GroupPointGetDAOImpl implements GroupPointGetDAO {

	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.GroupPointGetMapper";
	
	@Override
	public List<GroupPointGetVO> list() {
		return session.selectList(namespace+".list") ;
	}

	@Override
	public void insert(GroupPointGetVO vo) {
//		HashMap<String,Object> map=new HashMap<>();
//		map.put("group_point_code", group_point_code);
//		map.put("get_point", get_point);
//		map.put("group_user_point_id", group_user_point_id);
		session.insert(namespace+".insert",vo);
		
	}

}
