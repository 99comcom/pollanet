package com.example.dao;

import java.util.List;

import com.example.domain.BoardVO;

public interface BoardDAO {
	public List<BoardVO> boardList(String b_category, String search, int page, int num);
	public List<BoardVO> userBoardList(String b_user_id, int page, int num);
	public List<BoardVO> boardReportList (int page, int num);
	public List<BoardVO> boardDelList (int page, int num);
	public List<BoardVO> boardNoticeList (int page, int num);
	public BoardVO boardRead(int board_code);
	public void boardInsert(BoardVO vo);
	public void boardUpdate(BoardVO vo);
	public void boardDelete(BoardVO vo);
	public void boardDeleteAdmin(BoardVO vo);
	public void boardReport(int board_code);
	public void boardRecommned(int board_code);
	public void boardCommentCnt(int board_code);
	public List<BoardVO>boardListand(String b_title);
	public int boardListtotal(String b_category, String search);
	public void heart(BoardVO vo);
	public void heartCancel (BoardVO vo);
	public List<BoardVO>boardListheart();
	public List<BoardVO>reportBoardList(int page, int num);
	public int ReportBoardTotal();
}
