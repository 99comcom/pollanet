package com.example.service;

import com.example.domain.BoardVO;

public interface BoardService {
	public void heart(BoardVO vo, String h_user_id);
	public void heartCancel (BoardVO vo, String  h_user_id);
}
