package com.example.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.GroupDAO;
import com.example.dao.GroupMemberDAO;
import com.example.dao.GroupPointDAO;
import com.example.dao.GroupUserPointDAO;
import com.example.domain.GroupMemberVO;
import com.example.domain.GroupVO;

@Service
public class GroupServiceImpl implements GroupService {
	@Autowired
	GroupDAO dao;
	@Autowired
	GroupMemberDAO mdao;
	@Autowired
	GroupPointDAO pdao;
	@Autowired
	GroupUserPointDAO udao;

	
	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");

	
	@Transactional
	@Override
	public void groupinsert(GroupVO vo) { //그룹이 생성될떄 그룹리더 멤버테이블과 그룹포인트 테이블 생성
		Date  d= new Date(System.currentTimeMillis());
		vo.setG_code(formatter.format(d)+vo.getG_user_id());

		String gm_user_id =vo.getG_user_id();
		String group_user_point_id=vo.getG_user_id();
		String g_code=vo.getG_code();
		String group_point_code=vo.getG_code();
		dao.groupinsert(vo);
		mdao.groupinsert(gm_user_id, g_code);
		pdao.insert(group_point_code);
		udao.isnert(group_point_code, group_user_point_id);
		
	}
	
	
}
