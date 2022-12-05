package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GroupVO {
	private int group_code;
	private String g_user_id;
	private String g_code;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date g_register_Date;
	private String g_category;
	private String g_title;
	private String g_content;
	private String g_image;
	private String g_del;
	private String g_report;
	private String g_user_sort;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date g_join_Date;
	
	
	
	
	public String getG_code() {
		return g_code;
	}
	public void setG_code(String g_code) {
		this.g_code = g_code;
	}
	@Override
	public String toString() {
		return "GroupVO [group_code=" + group_code + ", g_user_id=" + g_user_id + ", g_register_Date=" + g_register_Date
				+ ", g_category=" + g_category + ", g_title=" + g_title + ", g_content=" + g_content + ", g_image="
				+ g_image + ", g_del=" + g_del + ", g_report=" + g_report + ", g_user_sort=" + g_user_sort
				+ ", g_join_Date=" + g_join_Date + "]";
	}
	public int getGroup_code() {
		return group_code;
	}
	public void setGroup_code(int group_code) {
		this.group_code = group_code;
	}
	public String getG_user_id() {
		return g_user_id;
	}
	public void setG_user_id(String g_user_id) {
		this.g_user_id = g_user_id;
	}
	public Date getG_register_Date() {
		return g_register_Date;
	}
	public void setG_register_Date(Date g_register_Date) {
		this.g_register_Date = g_register_Date;
	}
	public String getG_category() {
		return g_category;
	}
	public void setG_category(String g_category) {
		this.g_category = g_category;
	}
	public String getG_title() {
		return g_title;
	}
	public void setG_title(String g_title) {
		this.g_title = g_title;
	}
	public String getG_content() {
		return g_content;
	}
	public void setG_content(String g_content) {
		this.g_content = g_content;
	}
	public String getG_image() {
		return g_image;
	}
	public void setG_image(String g_image) {
		this.g_image = g_image;
	}
	public String getG_del() {
		return g_del;
	}
	public void setG_del(String g_del) {
		this.g_del = g_del;
	}
	public String getG_report() {
		return g_report;
	}
	public void setG_report(String g_report) {
		this.g_report = g_report;
	}
	public String getG_user_sort() {
		return g_user_sort;
	}
	public void setG_user_sort(String g_user_sort) {
		this.g_user_sort = g_user_sort;
	}
	public Date getG_join_Date() {
		return g_join_Date;
	}
	public void setG_join_Date(Date g_join_Date) {
		this.g_join_Date = g_join_Date;
	}
	
	
	
	
	
	
	
	
}
