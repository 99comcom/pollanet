package com.example.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupMemberVO extends UserStatusVO{
private int member_code;
private String gm_user_id;
private String gm_sort;
private String gm_del;
private int gm_report;
private String g_code;
@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone ="Asia/Seoul")
private Date gm_register_Date;
private String nickName;


public String getNickName() {
	return nickName;
}
public void setNickName(String nickName) {
	this.nickName = nickName;
}
public Date getGm_register_Date() {
	return gm_register_Date;
}
public void setGm_register_Date(Date gm_register_Date) {
	this.gm_register_Date = gm_register_Date;
}
public int getMember_code() {
	return member_code;
}
public void setMember_code(int member_code) {
	this.member_code = member_code;
}
public String getGm_user_id() {
	return gm_user_id;
}
public void setGm_user_id(String gm_user_id) {
	this.gm_user_id = gm_user_id;
}
public String getGm_sort() {
	return gm_sort;
}
public void setGm_sort(String gm_sort) {
	this.gm_sort = gm_sort;
}
public String getGm_del() {
	return gm_del;
}
public void setGm_del(String gm_del) {
	this.gm_del = gm_del;
}
public int getGm_report() {
	return gm_report;
}
public void setGm_report(int gm_report) {
	this.gm_report = gm_report;
}
public String getG_code() {
	return g_code;
}
public void setG_code(String g_code) {
	this.g_code = g_code;
}
@Override
public String toString() {
	return "GroupMemberVO [member_code=" + member_code + ", gm_user_id=" + gm_user_id + ", gm_sort=" + gm_sort
			+ ", gm_del=" + gm_del + ", gm_report=" + gm_report + ", g_code=" + g_code + ", gm_register_Date="
			+ gm_register_Date + ", nickName=" + nickName + "]";
}







}
