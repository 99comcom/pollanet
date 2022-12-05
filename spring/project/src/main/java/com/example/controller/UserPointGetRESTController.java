package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserPointGetDAO;
import com.example.domain.UserPointGetVO;


@RestController
@RequestMapping("/api/getpoint")
public class UserPointGetRESTController {
	@Autowired
	UserPointGetDAO dao;
	
	@RequestMapping("/list")
	public List<UserPointGetVO>list(int page,int number){
		return dao.list(page, number);
		
	}
	@RequestMapping(value="/delete/{user_point_get_code}",method=RequestMethod.POST)
	public void delete(@PathVariable int  user_point_get_code) {
		dao.delete(user_point_get_code);
	}
	
	@RequestMapping(value="/pointintsert/{user_point_id}",method=RequestMethod.POST)
	public void pointInsert(@PathVariable String user_point_id,int getPoint) {
		dao.pointInsert(user_point_id,getPoint);
		
	}
//
//	@RequestMapping("/gradeinsert")
//	public void gradeInsert(UserPointGetVO vo) {
//		dao.gradeInsert(vo);
//		
//	}
	
}
