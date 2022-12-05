package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserReportDAO;
import com.example.domain.UserReportVO;
import com.example.domain.UserStatusVO;
import com.example.service.UserReportService;

@RestController
@RequestMapping("/api/reportuser")
public class UserReportRESTController {

	@Autowired
	UserReportDAO udao;
	
	@Autowired
	UserReportService urService;
	
	@RequestMapping(value = "/boardReport",method=RequestMethod.POST)
	public void boardReport(@RequestBody UserReportVO vo){
		urService.BoardReportInsert(vo);
	}
	@RequestMapping(value = "/commentReport",method=RequestMethod.POST)
	public void commentReport(@RequestBody UserReportVO vo){
		urService.CommentReportInsert(vo);
	}
}
