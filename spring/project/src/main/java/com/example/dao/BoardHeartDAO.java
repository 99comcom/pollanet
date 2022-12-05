package com.example.dao;

import java.util.List;

import com.example.domain.BoardHeartVO;

public interface BoardHeartDAO {
	public List<BoardHeartVO> list();
	public int read(BoardHeartVO vo);
	public void insert(String h_user_id, int h_board_code);
	public void delete(String h_user_id, int h_board_code);
}
