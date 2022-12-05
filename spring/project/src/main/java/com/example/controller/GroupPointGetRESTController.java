package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.GroupPointGetDAO;
import com.example.domain.GroupPointGetVO;
import com.example.service.GroupPointGetService;

@RestController
@RequestMapping("/api/grouppointget")
public class GroupPointGetRESTController {
	@Autowired
	GroupPointGetDAO dao;
	
	@Autowired
	GroupPointGetService service;
	
	@RequestMapping("/list")
	public List<GroupPointGetVO> list(){
		return dao.list();
	}
	@RequestMapping("/insert")
	public void insert(@RequestBody GroupPointGetVO vo){
		service.insert(vo);
	}
	

	
	
}
