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
	public void memberinsert(GroupMemberVO vo) { //�׷� ���� ��ư�� �������� ����߰� �� ��� ���� �׷�����Ʈ ���̺� �߰�		
		dao.memberinsert(vo);
		String group_point_code=vo.getG_code();
		String group_user_point_id=vo.getGm_user_id();
		udao.isnert(group_point_code, group_user_point_id);
	}

}
