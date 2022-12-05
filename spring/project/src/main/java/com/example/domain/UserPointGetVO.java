package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserPointGetVO extends UserPointVO{
	private int user_point_get_code;
	private String user_point_id;
	private int get_point;
	private int get_grade;
	private String get_sort;
	private int getpoint;
	
	
	
	
	public int getGetpoint() {
		return getpoint;
	}
	public void setGetpoint(int getpoint) {
		this.getpoint = getpoint;
	}
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date get_point_Date;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date get_grade_Date;




	@Override
	public String toString() {
		return "UserPointGetVO [user_point_get_code=" + user_point_get_code + ", user_point_id=" + user_point_id
				+ ", get_point=" + get_point + ", get_grade=" + get_grade + ", get_sort=" + get_sort + ", getpoint="
				+ getpoint + ", get_point_Date=" + get_point_Date + ", get_grade_Date=" + get_grade_Date + "]";
	}
	public int getUser_point_get_code() {
		return user_point_get_code;
	}
	public void setUser_point_get_code(int user_point_get_code) {
		this.user_point_get_code = user_point_get_code;
	}
	public String getUser_point_id() {
		return user_point_id;
	}
	public void setUser_point_id(String user_point_id) {
		this.user_point_id = user_point_id;
	}
	public int getGet_point() {
		return get_point;
	}
	public void setGet_point(int get_point) {
		this.get_point = get_point;
	}
	public int getGet_grade() {
		return get_grade;
	}
	public void setGet_grade(int get_grade) {
		this.get_grade = get_grade;
	}
	public String getGet_sort() {
		return get_sort;
	}
	public void setGet_sort(String get_sort) {
		this.get_sort = get_sort;
	}
	public Date getGet_point_Date() {
		return get_point_Date;
	}
	public void setGet_point_Date(Date get_point_Date) {
		this.get_point_Date = get_point_Date;
	}
	public Date getGet_grade_Date() {
		return get_grade_Date;
	}
	public void setGet_grade_Date(Date get_grade_Date) {
		this.get_grade_Date = get_grade_Date;
	}
	
	
	
	
	
}
