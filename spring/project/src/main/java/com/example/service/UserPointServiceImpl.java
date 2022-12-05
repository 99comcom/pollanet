//package com.example.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.dao.UserPointDAO;
//import com.example.dao.UserPointGetDAO;
//import com.example.domain.UserPointVO;
//
//@Service
//public class UserPointServiceImpl implements UserPointService{
//	@Autowired
//	UserPointDAO udao;
//	
//	@Autowired
//	UserPointGetDAO gdao;
//	
//	
//	@Transactional
//	@Override
//	public void pointUpdate(UserPointVO vo, int getPoint) {
//		System.out.println(getPoint+"...................");
//		String user_point_id=vo.getUser_point_id();
//		udao.pointUpdate(vo, getPoint);
//		getPoint=getPoint;
//		System.out.println(getPoint+"..................."+vo+".........."+user_point_id);
//		gdao.pointInsert(user_point_id, getPoint);
//		
//	}
//
//	@Transactional
//	@Override
//	public void gradeUpdate(UserPointVO vo) {
//		gdao.gradeInsert(vo);
//		udao.gradeUpdate(vo);
//		
//	}
//
//
//}
