package com.example.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.domain.GroupPointGetVO;

public interface GroupPointGetService {

	public void insert(@RequestBody GroupPointGetVO vo);
	
}
