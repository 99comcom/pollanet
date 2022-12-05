package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.BoardDAO;
import com.example.dao.CommentDAO;
import com.example.dao.UserReportDAO;
import com.example.domain.BoardVO;
import com.example.domain.UserReportVO;

@Service
public class UserReportServiceImpl implements UserReportService{
	
	@Autowired
	UserReportDAO udao;
	@Autowired
	BoardDAO bdao;
	@Autowired
	CommentDAO cdao;
	
	@Transactional
	@Override
	public void BoardReportInsert(UserReportVO urvo){
		udao.BoardReportInsert(urvo);
		bdao.boardReport(urvo.getReport_board_code());
	}

	@Transactional
	@Override
	public void CommentReportInsert(UserReportVO urvo) {
		udao.CommentReportInsert(urvo);
		cdao.commentReport(urvo.getReport_comment_code());
		
	}
}
