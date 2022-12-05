package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MissionUserVO extends MissionVO{

	private int user_mission_code;
	private int mission_code;
	private String um_user_id;
	private String um_content;
	private String um_title;
	private String um_image;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date um_register_Date;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
	private Date um_updateDate;
	private int um_get_point;
	@Override
	public String toString() {
		return "MissionUserVO [user_mission_code=" + user_mission_code + ", mission_code=" + mission_code
				+ ", um_user_id=" + um_user_id + ", um_content=" + um_content + ", um_title=" + um_title + ", um_image="
				+ um_image + ", um_register_Date=" + um_register_Date + ", um_updateDate=" + um_updateDate
				+ ", um_get_point=" + um_get_point + "]";
	}
	public int getUser_mission_code() {
		return user_mission_code;
	}
	public void setUser_mission_code(int user_mission_code) {
		this.user_mission_code = user_mission_code;
	}
	public int getMission_code() {
		return mission_code;
	}
	public void setMission_code(int mission_code) {
		this.mission_code = mission_code;
	}
	public String getUm_user_id() {
		return um_user_id;
	}
	public void setUm_user_id(String um_user_id) {
		this.um_user_id = um_user_id;
	}
	public String getUm_content() {
		return um_content;
	}
	public void setUm_content(String um_content) {
		this.um_content = um_content;
	}
	public String getUm_title() {
		return um_title;
	}
	public void setUm_title(String um_title) {
		this.um_title = um_title;
	}
	public String getUm_image() {
		return um_image;
	}
	public void setUm_image(String um_image) {
		this.um_image = um_image;
	}
	public Date getUm_register_Date() {
		return um_register_Date;
	}
	public void setUm_register_Date(Date um_register_Date) {
		this.um_register_Date = um_register_Date;
	}
	public Date getUm_updateDate() {
		return um_updateDate;
	}
	public void setUm_updateDate(Date um_updateDate) {
		this.um_updateDate = um_updateDate;
	}
	public int getUm_get_point() {
		return um_get_point;
	}
	public void setUm_get_point(int um_get_point) {
		this.um_get_point = um_get_point;
	}
	
	
	
	
	
}
