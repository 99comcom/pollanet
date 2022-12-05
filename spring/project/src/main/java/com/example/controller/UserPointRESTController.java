package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserPointDAO;
import com.example.domain.UserPointVO;



@RestController
@RequestMapping("/api/point")
public class UserPointRESTController {
	@Autowired
	UserPointDAO dao;
	
//	@Autowired
//	UserPointService service;
	
	@RequestMapping("/list")
	public List<UserPointVO>list(){
		return dao.list();
	}
	
	@RequestMapping("/read/{user_point_id}")
	public UserPointVO read(@PathVariable String user_point_id){		
		return dao.read(user_point_id);
		
	}
	@RequestMapping("/rank/{user_point_id}")
	public int userRank(@PathVariable String user_point_id){
		return dao.userRank(user_point_id);
	}
	@RequestMapping("/rankList")
	public List<HashMap<String,Object>>rankList(){
		return dao.rankList();
	}
	@RequestMapping("/rankListWeb")
	public HashMap<String,Object> rankListWeb(String search, int page, int num){
		//System.out.println("................"+search+page+num);
		HashMap<String,Object> map = new HashMap<>();
		map.put("rankList", dao.rankListWeb(search, page, num));
		map.put("total", dao.userTotal());
		return map;
	}
	
	@RequestMapping("/rankReadWeb/{user_id}")
	public HashMap<String,Object> userRead(@PathVariable String user_id){
		return dao.rankReadWeb(user_id);
	}
	//포인트 등록
//	 @RequestMapping(method = RequestMethod.POST, path = "/insert")
////	@RequestMapping(value="/insert", method=RequestMethod.POST)
//	public void insert(@RequestBody UserPointVO vo){
//		System.out.println("..................................."+vo);
//		dao.insert(vo);
//	}
	
//	 @RequestMapping(method = RequestMethod.POST, path = "/pointupdate")
////	@RequestMapping(value="/pointupdate", method=RequestMethod.POST)
//	public void pointUpdate(@RequestBody UserPointVO vo,int getPoint){
//		service.pointUpdate(vo,getPoint);
//	}
//	
//	@RequestMapping(value="/geradupdate", method=RequestMethod.POST)
//	public void gradeUpdate(UserPointVO vo){
//		service.gradeUpdate(vo);
//	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void delete( String user_point_id){
//		System.out.println("..................................."+user_point_id);
		dao.delete(user_point_id);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/pointupdate/{user_point_id}")
	public void pointUpdate(@PathVariable String user_point_id,  int getPoint){
		dao.pointUpdate(user_point_id, getPoint);
	}
	@RequestMapping("/userrankread/{user_id}")
	   public HashMap<String,Object> rankRead(@PathVariable String user_id){
	      return dao.rankRead(user_id);
	   }
	
}
