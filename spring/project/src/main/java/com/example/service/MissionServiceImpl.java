package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.MissionDAO;
import com.example.dao.MissionUserDAO;
import com.example.dao.UserPointDAO;
import com.example.dao.UserPointGetDAO;
import com.example.domain.MissionUserVO;
import com.example.domain.MissionVO;
import com.example.domain.UserPointVO;

@Service
public class MissionServiceImpl implements MissionService {
	@Autowired
	MissionUserDAO mdao;
	@Autowired
	MissionDAO dao;
	@Autowired
	UserPointDAO udao;
	@Autowired
	UserPointGetDAO gdao;
	
	
	
	@Transactional
	@Override
	public void insert(MissionUserVO vo) { //미션완료시 포인트 증가 유저포인트에는 더해주고 유저겟포인트에는 기록만 남기고
		mdao.insert(vo);
		String user_point_id=vo.getUm_user_id();
		int getPoint=vo.getUm_get_point();
		int mission_code=vo.getMission_code();
		udao.pointUpdate(user_point_id, getPoint);
		UserPointVO upvo = udao.read(user_point_id);
		int userGrade = (upvo.getUser_point()/500);
		String usergrade = Integer.toString(userGrade);
		upvo.setUser_grade(usergrade);
		udao.gradeUpdate(upvo);
		gdao.pointInsert(user_point_id, getPoint);
		dao.resultupdate(mission_code);
		
	}
	

	

}
