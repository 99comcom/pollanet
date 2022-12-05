package com.example.service;

import com.example.domain.UserStatusVO;

public interface UserService {

	public void userRegister(UserStatusVO userStatusVo);
	public void userDelUpdate(UserStatusVO userStatusVo);
}
