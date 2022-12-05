package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.UserInfoVO;
import com.example.domain.UserStatusVO;

public interface UserDAO {
	public List<UserStatusVO> userStatusList();//��������Ʈ
	public List<HashMap<String,Object>> userStatusListWeb(String search, int page, int num);//��������Ʈ(��)
	public List<HashMap<String,Object>> userBlackListWeb(String search, int page, int num);
	public UserInfoVO userLogin(String user_Id);//���� read(userinfo����)
	public void userIdRegister(UserStatusVO userStatusVo);//userInfo ��� 
	public void userStatusRegister(UserStatusVO userStatusVo);//userStatus���
	public UserStatusVO userRead(String user_id);//���� read(userStatus��
	public int userIdDuplication(String str);//�ߺ�üũ(id)
	public int usernickNameDuplication(String str);//�ߺ�üũ(nickname)
	public String searchUserId(String name, String tel);
	public void updatePassword(UserInfoVO userInfovo);
	public void updateUserstatus(UserStatusVO userStatusvo);
	public void userdelupdate(UserStatusVO userStatusvo);
	public HashMap<String, Object> dayTopuser();
	public HashMap<String, Object> weekTopuser();
	public int userTotal(String search);//���� �� ���
	public int blackUserTotal(String search);//�� ���� �� ���
	public void userDelWeb(String user_id);//���� Ż��
	public void userBlackWeb(String user_id);//���� ��
	public void userCharsort(UserStatusVO userStatusVo); //ĳ���� ����
}
