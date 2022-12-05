package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.GroupPointDAO;
import com.example.dao.GroupPointGetDAO;
import com.example.dao.GroupUserPointDAO;
import com.example.domain.GroupPointGetVO;

@Service
public class GroupPointGetServiceImpl implements GroupPointGetService{
	@Autowired
	GroupPointDAO pdao;
	
	@Autowired
	GroupPointGetDAO gdao;
	
	@Autowired
	GroupUserPointDAO udao;
	
	
	@Transactional
	@Override
	public void insert(GroupPointGetVO vo) {
		gdao.insert(vo);
		
		int group_point=vo.getGet_point();
		String group_point_code=vo.getGroup_point_code();
		String group_user_point_id=vo.getGroup_user_point_id();
		int group_user_point=vo.getGet_point();
		pdao.update(group_point, group_point_code);
		udao.update(group_point_code, group_user_point_id,group_user_point);
		
	}

}
