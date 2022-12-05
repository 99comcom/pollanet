package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GroupPointGetVO {
	private int group_point_get_code;
	private String group_point_code;
	private String  group_user_point_id;
	private int group_user_point;
	private int get_point;
	private String get_grade;
	private String  get_sort;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date get_point_Date;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date get_grade_Date;
	public int getGroup_point_get_code() {
		return group_point_get_code;
	}
	public void setGroup_point_get_code(int group_point_get_code) {
		this.group_point_get_code = group_point_get_code;
	}
	public String getGroup_point_code() {
		return group_point_code;
	}
	public void setGroup_point_code(String group_point_code) {
		this.group_point_code = group_point_code;
	}
	public String getGroup_user_point_id() {
		return group_user_point_id;
	}
	public void setGroup_user_point_id(String group_user_point_id) {
		this.group_user_point_id = group_user_point_id;
	}
	public int getGroup_user_point() {
		return group_user_point;
	}
	public void setGroup_user_point(int group_user_point) {
		this.group_user_point = group_user_point;
	}
	public int getGet_point() {
		return get_point;
	}
	public void setGet_point(int get_point) {
		this.get_point = get_point;
	}
	public String getGet_grade() {
		return get_grade;
	}
	public void setGet_grade(String get_grade) {
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
