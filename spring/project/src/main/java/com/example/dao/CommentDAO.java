package com.example.dao;

import java.util.List;

import com.example.domain.CommentVO;

public interface CommentDAO {
	public List<CommentVO> commentList(int page, int num);
	public List<CommentVO> userCommentList(String c_user_id, int page, int num);
	public List<CommentVO> boardCommentList(int board_Code);
	public void commentInsert(CommentVO vo);
	public void commentUpdate(CommentVO vo);
	public void commentDelete(int comment_code);
	public void commentReport(int comment_code);
	public void commentRecommend(int comment_code);
	public int totalComment(int board_Code);
	public int atotalComment();
}
