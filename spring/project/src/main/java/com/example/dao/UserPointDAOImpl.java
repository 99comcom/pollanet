package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.UserPointVO;

@Repository
public class UserPointDAOImpl implements UserPointDAO {
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.UserPointMapper";

	@Override
	public List<UserPointVO> list() {
		return session.selectList(namespace+".list");
	}

	@Override
	public UserPointVO read(String user_point_id) {
		return session.selectOne(namespace+".read",user_point_id);
	}

	@Override
	public void pointUpdate(String user_point_id,int getPoint) {
		HashMap<String,Object> map=new HashMap<>();
		map.put("user_point_id",user_point_id);
		map.put("getPoint", getPoint);
		session.update(namespace+".pointUpdate",map);
		
	}

	@Override
	public void gradeUpdate(UserPointVO vo) {
		session.update(namespace+".gradeUpdate",vo);
		
	}

	@Override
	public void Reginsert(UserPointVO vo) {
		session.insert(namespace+".Reginsert",vo);
		
	}

	@Override
	public void delete(String user_point_id) {
		session.delete(namespace+".delete",user_point_id);
		
	}

	@Override
	public int userRank(String user_point_id) {
		return session.selectOne(namespace+".userrank", user_point_id);
	}

	@Override
	public List<HashMap<String,Object>> rankList() {	
		return session.selectList(namespace + ".rankList");
	}
	@Override
	public List<HashMap<String, Object>> rankListWeb(String search, int page, int num) {
		HashMap<String,Object> map=new HashMap<>();
		map.put("search",search);
		map.put("num", num);
		map.put("start", (page-1)*num);
		return session.selectList(namespace+".rankListWeb",map);
	}

	@Override
	public int userTotal() {
		return session.selectOne(namespace + ".userTotal");
	}

	@Override
	public HashMap<String,Object> rankReadWeb(String user_id) {
		return session.selectOne(namespace+".rankReadWeb",user_id);
	}
	   @Override
	   public HashMap<String, Object> rankRead(String user_id) {
	      
	      return session.selectOne(namespace + ".rankRead", user_id);
	   }
}
