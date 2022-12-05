package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GroupPointVO {
	private String group_point_code;
	private int group_point;
	private String group_grade;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date group_point_Date;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date group_grade_Date;
	
	private String g_title;
	
	
	
	
	
	public String getG_title() {
		return g_title;
	}
	public void setG_title(String g_title) {
		this.g_title = g_title;
	}
	public String getGroup_point_code() {
		return group_point_code;
	}
	public void setGroup_point_code(String group_point_code) {
		this.group_point_code = group_point_code;
	}
	public int getGroup_point() {
		return group_point;
	}
	public void setGroup_point(int group_point) {
		this.group_point = group_point;
	}
	public String getGroup_grade() {
		return group_grade;
	}
	public void setGroup_grade(String group_grade) {
		this.group_grade = group_grade;
	}
	public Date getGroup_point_Date() {
		return group_point_Date;
	}
	public void setGroup_point_Date(Date group_point_Date) {
		this.group_point_Date = group_point_Date;
	}
	public Date getGroup_grade_Date() {
		return group_grade_Date;
	}
	public void setGroup_grade_Date(Date group_grade_Date) {
		this.group_grade_Date = group_grade_Date;
	}
	
	
	
	
	
	
	
	
}
