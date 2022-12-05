package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDAO;
import com.example.dao.UserPointDAO;
import com.example.domain.UserPointVO;
import com.example.domain.UserStatusVO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO udao;
	@Autowired
	UserPointDAO updao;
	

	@Transactional
	@Override
	public void userRegister(UserStatusVO userStatusVo) {
		
		udao.userIdRegister(userStatusVo);
		udao.userStatusRegister(userStatusVo);
		UserPointVO upvo = new UserPointVO();
		upvo.setUser_id(userStatusVo.getUser_id());
		updao.Reginsert(upvo);
		
	}
	
	@Transactional
	@Override
	public void userDelUpdate(UserStatusVO userStatusVo) {
		UserPointVO userPointVo = updao.read(userStatusVo.getUser_id());
		udao.userdelupdate(userStatusVo);
		String user_point_id=userStatusVo.getUser_id();
		int getPoint=-(userPointVo.getUser_point());
		updao.pointUpdate(user_point_id, getPoint);
	}

	


}
