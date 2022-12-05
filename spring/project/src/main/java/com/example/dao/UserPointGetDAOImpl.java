package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.UserPointGetVO;

@Repository
public class UserPointGetDAOImpl implements UserPointGetDAO {
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.UserPointGetMapper";
	

	
	@Override
	public List<UserPointGetVO> list(int page,int number) {
		HashMap<String,Object> map=new HashMap<>();
		map.put("start",(page-1)*number);
		map.put("number", number);
		return session.selectList(namespace+".list",map);
	}

	@Override
	public void pointInsert(String user_point_id,int getPoint) {
		HashMap<String,Object> map=new HashMap<>();
		map.put("user_point_id",user_point_id);
		map.put("getPoint", getPoint);
		session.insert(namespace+".pointInsert",map);
		
	}

	@Override
	public void gradeInsert(UserPointGetVO vo) {
		session.insert(namespace+".gradeInsert",vo);
		
	}

	@Override
	public void delete(int user_point_get_code) {
		session.delete(namespace+".delete",user_point_get_code);
		
	}

}
