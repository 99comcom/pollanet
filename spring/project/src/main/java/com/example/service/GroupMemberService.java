package com.example.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.domain.GroupMemberVO;

public interface GroupMemberService {
	public void memberinsert(@RequestBody GroupMemberVO vo);

}
