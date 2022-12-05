package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.GroupMemberDAO;
import com.example.dao.GroupUserPointDAO;
import com.example.domain.GroupMemberVO;

@Service
public class GroupMemberServiceImpl implements GroupMemberService {
	
	@Autowired 
	GroupMemberDAO dao;
	@Autowired
	GroupUserPointDAO udao;
	
	@Transactional
	@Override
	public void memberinsert(GroupMemberVO vo) { //그룹 가입 버튼을 눌렀을때 멤버추가 및 멤버 개인 그룹포인트 테이블 추가		
		dao.memberinsert(vo);
		String group_point_code=vo.getG_code();
		String group_user_point_id=vo.getGm_user_id();
		udao.isnert(group_point_code, group_user_point_id);
	}

}
