package com.example.dao;

import java.util.List;

import com.example.domain.UserPointGetVO;



public interface UserPointGetDAO {
	public List<UserPointGetVO>list(int page,int number);
	public 	void gradeInsert(UserPointGetVO vo);
	public void delete(int  user_point_get_code);
	public void pointInsert(String user_point_id ,int getPoint);


}
