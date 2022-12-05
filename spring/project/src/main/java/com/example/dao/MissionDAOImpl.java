package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.MissionVO;

@Repository
public class MissionDAOImpl implements MissionDAO {
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.MissionMapper";

	@Override
	public List<MissionVO> list(String m_keyword, int m_start, int m_number) {
		HashMap<String,Object> map =new HashMap<>();
		map.put("m_keyword", m_keyword);
		map.put("m_start", m_start);
		map.put("m_number", m_number);
		return session.selectList(namespace+".list",map);
	}

	@Override
	public MissionVO read(int mission_code) {
		return session.selectOne(namespace+".read",mission_code) ;
	}

	@Override
	public void insert(MissionVO vo) {
		session.insert(namespace+".insert", vo);
		
	}

	@Override
	public void update(MissionVO vo) {
		session.update(namespace+".update",vo);
		
	}

	@Override
	public void delete(int mission_code) {
	session.delete(namespace+".delete",mission_code);
	
		
	}

	@Override
	public List<MissionVO> categorylist(String m_category, String m_sort, int m_start, int m_number) {
		HashMap<String,Object> map =new HashMap<>();
		map.put("m_category", m_category);
		map.put("m_sort", m_sort);
		map.put("m_start", m_start);
		map.put("m_number", m_number);
		return session.selectList(namespace+".categorylist",map);
	}

	@Override
	public void resultupdate(int mission_code) {
		session.update(namespace+".resultupdate",mission_code);
		
	}

	@Override
	public HashMap<String, Object> topmission(String m_sort) {
		HashMap<String, Object> result = session.selectOne(namespace + ".topdaymission", m_sort);
		//System.out.println(result);
		return session.selectOne(namespace + ".topdaymission", m_sort);
	}

	@Override
	public HashMap<String, Object> topwmission(String m_sort) {

		return session.selectOne(namespace + ".topweekmission", m_sort);
	}

	@Override
	public MissionVO bestMission() {
		return session.selectOne(namespace + ".bestmission");
	}

	@Override
	public int clearMission(String um_user_id, int mission_code) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("um_user_id", um_user_id);
		map.put("mission_code", mission_code);
		return session.selectOne(namespace + ".clearMision", map);
	}

	@Override
	public int clearMissionTotal(String um_user_id) {

		return session.selectOne(namespace + ".clearMisionTotal", um_user_id);
	}
	
	@Override
	public int listTotal() {
		return session.selectOne(namespace + ".listTotal");
	}
	

}
