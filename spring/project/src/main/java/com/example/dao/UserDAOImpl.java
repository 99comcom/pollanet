package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.UserInfoVO;
import com.example.domain.UserStatusVO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SqlSession session;
	String namespace = "com.example.mapper.UserMapper";

	@Override
	public List<UserStatusVO> userStatusList() {
		return session.selectList(namespace + ".userStatusList");
	}

	@Override
	public UserInfoVO userLogin(String user_Id) {
		return session.selectOne(namespace + ".userLogin",user_Id);
	}

	@Override
	public void userIdRegister(UserStatusVO userStatusVo) {
		session.insert(namespace + ".userIdRegister", userStatusVo);
		
	}

	@Override
	public void userStatusRegister(UserStatusVO userStatusVo) {
		session.insert(namespace+".userRegister", userStatusVo);
		
	}

	@Override
	public UserStatusVO userRead(String user_id) {
		return session.selectOne(namespace + ".userRead", user_id);
	}


	@Override
	public int userIdDuplication(String str) {
		return session.selectOne(namespace + ".duplicationId", str);
	}

	@Override
	public int usernickNameDuplication(String str) {
		return session.selectOne(namespace + ".duplicationnickname", str);
	}

	@Override
	public String searchUserId(String name, String tel) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("tel", tel);
		return session.selectOne(namespace + ".searchId", map);
	}

	@Override
	public void updatePassword(UserInfoVO userInfovo) {
		session.insert(namespace + ".passwordupdate", userInfovo);
		
	}

	@Override
	public void updateUserstatus(UserStatusVO userStatusvo) {
		session.update(namespace + ".userupdate", userStatusvo);
	}

	@Override
	public void userdelupdate(UserStatusVO userStatusvo) {
		session.update(namespace + ".userdelupdate", userStatusvo);
		
	}

	@Override
	public HashMap<String, Object> dayTopuser() {
		return session.selectOne(namespace + ".daytopuser");
	}

	@Override
	public HashMap<String, Object> weekTopuser() {
		return  session.selectOne(namespace + ".weektopuser");
	}

	@Override
	public List<HashMap<String, Object>> userStatusListWeb(String search, int page, int num) {
		HashMap<String,Object> map=new HashMap<>();
		map.put("num", num);
		map.put("search", search);
		map.put("start", (page-1)*num);
		return session.selectList(namespace+".userStatusListWeb",map);
	}

	@Override
	public int userTotal(String search) {
		return session.selectOne(namespace + ".userTotal",search);
	}

	@Override
	public void userDelWeb(String user_id) {
		session.update(namespace + ".userDelWeb",user_id);
	}

	@Override
	public int blackUserTotal(String search) {
		return session.selectOne(namespace+ ".blackUserTotal",search);
	}

	@Override
	public void userBlackWeb(String user_id) {
		session.update(namespace+".userBlackWeb",user_id);
		
	}

	@Override
	public List<HashMap<String, Object>> userBlackListWeb(String search, int page, int num) {
		HashMap<String,Object> map=new HashMap<>();
		map.put("num", num);
		map.put("search", search);
		map.put("start", (page-1)*num);
		return session.selectList(namespace+".userBlackListWeb",map);
	}

	@Override
	public void userCharsort(UserStatusVO userStatusVo) {
		session.update(namespace + ".usercharsort", userStatusVo);
		
	}

}
