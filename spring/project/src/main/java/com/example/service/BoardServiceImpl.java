package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.BoardDAO;
import com.example.dao.BoardHeartDAO;
import com.example.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO bdao;
	
	@Autowired
	BoardHeartDAO hdao;
	
	@Transactional
	@Override
	public void heart( BoardVO vo, String h_user_id) {
		bdao.heart(vo);
		int h_board_code=vo.getBoard_code();
		hdao.insert(h_user_id, h_board_code);
		
	}
	@Transactional
	@Override
	public void heartCancel(BoardVO vo, String h_user_id) {
		bdao.heartCancel(vo);
		int h_board_code=vo.getBoard_code();
		hdao.delete(h_user_id, h_board_code);
		
	}

}
