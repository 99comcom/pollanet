package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.GroupMemberDAO;
import com.example.domain.GroupMemberVO;
import com.example.service.GroupMemberService;

@RestController
@RequestMapping("/api/member")
public class GroupMemberRESTController {
	@Autowired
	GroupMemberDAO dao;
	@Autowired
	GroupMemberService service;
	
	@RequestMapping("/list")
	public List<GroupMemberVO> list(String gm_keyword){
		return dao.list(gm_keyword);
		
	}
	@RequestMapping("/memberlist")
	public List<GroupMemberVO> memberlist(String  g_code){
		return dao.memberlist(g_code);
		
	}
	
	
	@RequestMapping("/read/{member_code}")
	public GroupMemberVO read(@PathVariable int member_code){
		return dao.read(member_code);
		
	}
	
	@RequestMapping(value="/delete/{member_code}", method=RequestMethod.POST)
	public void delete(@PathVariable int member_code){
		dao.delete(member_code);
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)//맴버가입시 중복체크 1이면 중복, 2면 중복아니라서 insert 실행해야함
	public int membercheck(@RequestBody GroupMemberVO vo){
		int result=0;
		GroupMemberVO gvo=dao.membercheck(vo);
		if(gvo != null){
			result =1;
			
		}else{
			result=2;
		}
//		System.out.println("......"+vo.getGm_user_id());
		System.out.println("............."+result);
		return result;

		
	}
	
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void memberinsert(@RequestBody GroupMemberVO vo){
		service.memberinsert(vo);
	}


}
