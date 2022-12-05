package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.UserInfoVO;
import com.example.domain.UserStatusVO;

public interface UserDAO {
	public List<UserStatusVO> userStatusList();//유저리스트
	public List<HashMap<String,Object>> userStatusListWeb(String search, int page, int num);//유저리스트(웹)
	public List<HashMap<String,Object>> userBlackListWeb(String search, int page, int num);
	public UserInfoVO userLogin(String user_Id);//유저 read(userinfo버전)
	public void userIdRegister(UserStatusVO userStatusVo);//userInfo 등록 
	public void userStatusRegister(UserStatusVO userStatusVo);//userStatus등록
	public UserStatusVO userRead(String user_id);//유저 read(userStatus버
	public int userIdDuplication(String str);//중복체크(id)
	public int usernickNameDuplication(String str);//중복체크(nickname)
	public String searchUserId(String name, String tel);
	public void updatePassword(UserInfoVO userInfovo);
	public void updateUserstatus(UserStatusVO userStatusvo);
	public void userdelupdate(UserStatusVO userStatusvo);
	public HashMap<String, Object> dayTopuser();
	public HashMap<String, Object> weekTopuser();
	public int userTotal(String search);//유저 총 명수
	public int blackUserTotal(String search);//블랙 유저 총 명수
	public void userDelWeb(String user_id);//유저 탈퇴
	public void userBlackWeb(String user_id);//유저 블랙
	public void userCharsort(UserStatusVO userStatusVo); //캐릭터 선택
}
