package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BoardVO extends ReportVO{
	private int board_code;												//�Խñ� �ڵ�
	private String b_user_id;											//���� ���̵�
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date b_register_Date;										//�Խñ� �����
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date b_update_Date;											//�Խñ� ������
	private String b_title;												//�Խñ� ����
	private String b_content;											//�Խñ� ����
	private String b_image;												//÷�� ����
	private String b_del;												//���� ����(1:���� 0:����)
	private int b_report;												//�Խñ� �Ű� ����
	private int b_recommend;
	private int b_comment_count;
	private String b_category;
	private int b_report_content;
	//getter and setter
	private int b_heart; //���ƿ� ��
	
	public int getB_heart() {
		return b_heart;
	}
	public void setB_heart(int b_heart) {
		this.b_heart = b_heart;
	}
	
	public int getBoard_code() {
		return board_code;
	}
	public int getB_comment_count() {
		return b_comment_count;
	}
	public void setB_comment_count(int b_comment_count) {
		this.b_comment_count = b_comment_count;
	}
	public String getB_category() {
		return b_category;
	}
	public void setB_category(String b_category) {
		this.b_category = b_category;
	}
	public void setBoard_Code(int board_Code) {
		this.board_code = board_Code;
	}
	public String getB_user_id() {
		return b_user_id;
	}
	public void setB_user_id(String b_user_id) {
		this.b_user_id = b_user_id;
	}
	public Date getB_register_Date() {
		return b_register_Date;
	}
	public void setB_register_Date(Date b_register_Date) {
		this.b_register_Date = b_register_Date;
	}
	public Date getB_update_Date() {
		return b_update_Date;
	}
	public void setB_update_Date(Date b_update_Date) {
		this.b_update_Date = b_update_Date;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_image() {
		return b_image;
	}
	public void setB_image(String b_image) {
		this.b_image = b_image;
	}
	public String getB_del() {
		return b_del;
	}
	public void setB_del(String b_del) {
		this.b_del = b_del;
	}
	public int getB_report() {
		return b_report;
	}
	public void setB_report(int b_report) {
		this.b_report = b_report;
	}
	public int getB_recommend() {
		return b_recommend;
	}
	public void setB_recommend(int b_recommend) {
		this.b_recommend = b_recommend;
	}
	
	public int getB_report_content() {
		return b_report_content;
	}
	public void setB_report_content(int b_report_content) {
		this.b_report_content = b_report_content;
	}
	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}
	//toString
	@Override
	public String toString() {
		return "BoardVO [board_code=" + board_code + ", b_user_id=" + b_user_id + ", b_register_Date=" + b_register_Date
				+ ", b_update_Date=" + b_update_Date + ", b_title=" + b_title + ", b_content=" + b_content
				+ ", b_image=" + b_image + ", b_del=" + b_del + ", b_report=" + b_report + ", b_recommend="
				+ b_recommend + ", b_comment_count=" + b_comment_count + ", b_category=" + b_category + "]";
	}
	
	
}
