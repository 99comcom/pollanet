package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.BoardDAO;
import com.example.dao.CommentDAO;
import com.example.domain.BoardVO;
import com.example.domain.CommentVO;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentDAO cdao;
	@Autowired
	BoardDAO bdao;
	
	//댓글 작성히 보드 테아블의 commentcnt 갯수 증가
	@Transactional
	@Override
	public void insert(CommentVO vo) {
		cdao.commentInsert(vo);
		BoardVO bvo=bdao.boardRead(vo.getBoard_Code());
		bdao.boardCommentCnt(bvo.getBoard_code());
	}

}
