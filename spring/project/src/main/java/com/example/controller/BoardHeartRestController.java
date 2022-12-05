package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.BoardHeartDAO;
import com.example.domain.BoardHeartVO;



@RestController
@RequestMapping("/api/boardheart")
public class BoardHeartRestController {
	@Autowired
	BoardHeartDAO dao;
	
	
	@RequestMapping("/list")
	public List<BoardHeartVO> list(){
		return dao.list();
	}
	
	@RequestMapping(value="/read",method=RequestMethod.POST)//�ɹ����Խ� �ߺ�üũ 1�̸� �ߺ�, 2�� �ߺ��ƴ϶� insert �����ؾ���
	public int read(@RequestBody BoardHeartVO vo){
		int result=0;
		result = dao.read(vo);

		return result;
	}
	
}
