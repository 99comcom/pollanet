package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.BoardHeartVO;

@Repository
public class BoardHeartDAOImpl implements BoardHeartDAO {
	@Autowired
	SqlSession sql;
	
	String namespace="com.example.mapper.BoardHeartMapper";

	@Override
	public List<BoardHeartVO> list() {
		return sql.selectList(namespace+".list");
	}

	@Override
	public int read(BoardHeartVO vo) {
		return sql.selectOne(namespace+".read",vo);
	}

	@Override
	public void insert(String h_user_id, int h_board_code) {
		HashMap<String,Object> map =new HashMap<>();
		map.put("h_user_id", h_user_id);
		map.put("h_board_code", h_board_code);
		sql.insert(namespace+".insert",map);
		
	}

	@Override
	public void delete(String h_user_id, int h_board_code) {
		HashMap<String,Object> map =new HashMap<>();
		map.put("h_user_id", h_user_id);
		map.put("h_board_code", h_board_code);
		sql.insert(namespace+".insert",map);
		
	}

}
