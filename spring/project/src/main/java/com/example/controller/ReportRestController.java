package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ReportDAO;
import com.example.domain.MissionVO;
import com.example.domain.ReportVO;

@RestController
@RequestMapping("/api/report")
public class ReportRestController {
	
	@Autowired
	ReportDAO rdao;
	
	@RequestMapping("/list")
	public List<ReportVO> list(){
		return rdao.reportList();
	}
}
