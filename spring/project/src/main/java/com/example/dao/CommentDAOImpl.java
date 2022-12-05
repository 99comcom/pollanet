package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.CommentVO;

@Repository
public class CommentDAOImpl implements CommentDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.CommentMapper";
	
	@Override
	public List<CommentVO> commentList(int page, int num) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("start", (page-1)*num);
		map.put("num", num);
		return session.selectList(namespace + ".commentList", map);
	}
	@Override
	public List<CommentVO> userCommentList(String c_user_id, int page, int num) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("c_user_id", c_user_id);
		map.put("start", (page-1)*num);
		map.put("num", num);
		return session.selectList(namespace + ".userCommentList",map);
	}
	@Override
	public void commentInsert(CommentVO vo) {
		session.insert(namespace + ".commentInsert", vo);
	}
	@Override
	public void commentUpdate(CommentVO vo) {
		session.update(namespace + ".commentUpdate", vo);
	}
	@Override
	public void commentDelete(int comment_code) {
		session.update(namespace + ".commentDelete", comment_code);
	}
	@Override
	public void commentReport(int comment_code) {
		session.update(namespace + ".commentReport", comment_code);
	}
	@Override
	public List<CommentVO> boardCommentList(int board_Code) {
		return session.selectList(namespace + ".boardCommentList", board_Code);
	}
	@Override
	public void commentRecommend(int comment_code) {
		session.update(namespace + ".commentRecommend", comment_code);
	}
	@Override
	public int totalComment(int board_Code) {
		return session.selectOne(namespace + ".totalComment",board_Code);
	}
	@Override
	public int atotalComment() {
		return session.selectOne(namespace + ".atotalComment");
	}
}
