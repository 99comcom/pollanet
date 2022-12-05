package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.CharacterVO;

@Repository
public class CharacterDAOImpl implements CharacterDAO {
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.CharacterMapper";
	
	@Override
	public List<CharacterVO> list() { //�׸��� �󸶳� ������� ������ �� �ȵɰŶ� �Ǵ��ؼ� ���� ����Ʈ
		return session.selectList(namespace+".list");
	}
	@Override
	public CharacterVO read(String character_grade) { //grade�� read�� �ϴ� ������ ���� ���������� ȸ���� grade�� �����ͼ� �����ֱ� ����. 
		return session.selectOne(namespace+".read",character_grade);
	}
	@Override
	public void insert(CharacterVO vo) {
		session.insert(namespace+".insert",vo);
		
	}
	@Override
	public void update(CharacterVO vo) {
		session.update(namespace+".update",vo);
		
	}
	@Override
	public void delete(String character_code) {
		session.delete(namespace+".delete",character_code);
		
	}
	@Override
	public HashMap<String, Object> usercharRead(String user_id) {
		
		return session.selectOne(namespace + ".userchar", user_id );
	}
	@Override
	public List<CharacterVO> listg1() {
		return session.selectList(namespace + ".listg1");
	}
	
	
	
	
}
