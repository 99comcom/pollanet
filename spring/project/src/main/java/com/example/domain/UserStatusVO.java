package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserStatusVO extends UserInfoVO{
	private String user_id;
	private String name;
	private String nickName;
	private String tel;
	private String email;
	private String character_sort;
	private String address;
	private String admin_Code;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date register_Date;
	private String attendance;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date attendance_Date;
	private String user_del;
	private String user_black;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCharacter_sort() {
		return character_sort;
	}
	public void setCharacter_sort(String character_sort) {
		this.character_sort = character_sort;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdmin_Code() {
		return admin_Code;
	}
	public void setAdmin_Code(String admin_Code) {
		this.admin_Code = admin_Code;
	}
	public Date getRegister_Date() {
		return register_Date;
	}
	public void setRegister_Date(Date register_Date) {
		this.register_Date = register_Date;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public Date getAttendance_Date() {
		return attendance_Date;
	}
	public void setAttendance_Date(Date attendance_Date) {
		this.attendance_Date = attendance_Date;
	}
	public String getUser_del() {
		return user_del;
	}
	public void setUser_del(String user_del) {
		this.user_del = user_del;
	}
	public String getUser_black() {
		return user_black;
	}
	public void setUser_black(String user_black) {
		this.user_black = user_black;
	}

	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", name=" + name + ", nickName=" + nickName + ", tel=" + tel + ", email="
				+ email + ", image=" + character_sort + ", address=" + address + ", admin_Code=" + admin_Code
				+ ", register_Date=" + register_Date + ", attendance=" + attendance + ", attendance_Date="
				+ attendance_Date + ", user_del=" + user_del + ", user_black=" + user_black + ", user_grade="
				 + "]";
	}
	
}
