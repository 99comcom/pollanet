package com.example.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommentVO extends ReportVO{
	
	private int comment_code;										//��� �ڵ�
	private String c_user_id;											//�ۼ��� ���̵�
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date c_register_Date;										//��� �ۼ���
	private String c_comment;												//��� ����
	private String c_del;												//��� ���� ���� (����:1, ����:0)
	private int c_report;												//��� �Ű� ��
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date c_update_Date;											//��� ������
	private int board_Code;											//��� �޸� �Խñ� �ڵ�
	private int c_recommend;
	
	//getter and setter
	
	

	public int getC_recommend() {
		return c_recommend;
	}
	public int getComment_code() {
		return comment_code;
	}
	public void setComment_code(int comment_code) {
		this.comment_code = comment_code;
	}
	public void setC_recommend(int c_recommend) {
		this.c_recommend = c_recommend;
	}
	public String getC_comment() {
		return c_comment;
	}
	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}
	
	public String getC_user_id() {
		return c_user_id;
	}
	public void setC_user_id(String c_user_id) {
		this.c_user_id = c_user_id;
	}
	public Date getC_register_Date() {
		return c_register_Date;
	}
	public void setC_register_Date(Date c_register_Date) {
		this.c_register_Date = c_register_Date;
	}
	public String getC_del() {
		return c_del;
	}
	public void setC_del(String c_del) {
		this.c_del = c_del;
	}
	public int getC_report() {
		return c_report;
	}
	public void setC_report(int c_report) {
		this.c_report = c_report;
	}
	public Date getC_update_Date() {
		return c_update_Date;
	}
	public void setC_update_Date(Date c_update_Date) {
		this.c_update_Date = c_update_Date;
	}
	public int getBoard_Code() {
		return board_Code;
	}
	public void setBoard_Code(int board_Code) {
		this.board_Code = board_Code;
	}
	@Override
	public String toString() {
		return "CommentVO [comment_code=" + comment_code + ", c_user_id=" + c_user_id + ", c_register_Date="
				+ c_register_Date + ", c_comment=" + c_comment + ", c_del=" + c_del + ", c_report=" + c_report
				+ ", c_update_Date=" + c_update_Date + ", board_Code=" + board_Code + "]";
	}


	
	//toString
	
}
