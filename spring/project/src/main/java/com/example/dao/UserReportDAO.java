package com.example.dao;

import org.springframework.stereotype.Repository;

import com.example.domain.UserReportVO;

public interface UserReportDAO {
	public void BoardReportInsert(UserReportVO vo);
	public void CommentReportInsert(UserReportVO vo);
	
}
