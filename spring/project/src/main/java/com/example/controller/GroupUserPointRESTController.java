package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.GroupUserPointDAO;
import com.example.domain.GroupUserPointVO;

@RestController
@RequestMapping("/api/groupUserPoint")
public class GroupUserPointRESTController {
	@Autowired
	GroupUserPointDAO dao;

	@RequestMapping("/list")
	public List<GroupUserPointVO>list(){
		return dao.list();
	}
	

	
}
