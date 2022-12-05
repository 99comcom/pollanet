package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.GroupPointDAO;
import com.example.domain.GroupPointVO;


@RestController
@RequestMapping("/api/grouppoint")
public class GroupPointRESTController {
	@Autowired
	GroupPointDAO dao;

	
	
	@RequestMapping("/list")
	public List<GroupPointVO> list(String group_point_code){
		return dao.list(group_point_code);
		
	}
	
	@RequestMapping("/read/{group_point_code}")
	public GroupPointVO read(@PathVariable String group_point_code){
		return dao.read(group_point_code);
		
	}
	

	
	
}
