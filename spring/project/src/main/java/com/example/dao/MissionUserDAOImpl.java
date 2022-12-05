package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.MissionUserVO;


@Repository
public class MissionUserDAOImpl implements MissionUserDAO {
	@Autowired
	SqlSession session;

	String namespace="com.example.mapper.MissionUserMapper";

@Override
public List<MissionUserVO> list(String um_keyword, int um_start, int um_number) {
	HashMap<String,Object> map =new HashMap<>();
	map.put("um_keyword", um_keyword);
	map.put("um_start", um_start);
	map.put("um_number", um_number);
	return session.selectList(namespace+".list",map);
}

@Override
public MissionUserVO read(String user_mission_code) {
	
	return session.selectOne(namespace+".read",user_mission_code);
}

@Override
public void insert(MissionUserVO vo) {
	session.insert(namespace+".insert",vo);
	
}

@Override
public void update(MissionUserVO vo) {
	HashMap<String,Object> map =new HashMap<>();
	session.update(namespace+".update",vo);	
}

@Override
public void delete(String user_mission_code) {
	session.delete(namespace+".delete",user_mission_code);
}

@Override
public List<MissionUserVO> userMissionList(String um_user_id, int um_start, int um_number) {
	HashMap<String,Object> map =new HashMap<>();
	map.put("um_keyword", um_user_id);
	map.put("um_start", um_start);
	map.put("um_number", um_number);
	return session.selectList(namespace +".userMissionList", map);
}

}

