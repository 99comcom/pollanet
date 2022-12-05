package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.BoardMapper";
	
	@Override
	public List<BoardVO> boardList(String b_category, String search, int page, int num) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("b_category", b_category);
		map.put("search", search);
		map.put("start", (page-1)*num);
		map.put("num", num);
		return session.selectList(namespace + ".boardList",map);
	}
	@Override
	public List<BoardVO> userBoardList(String b_user_id, int page, int num) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("b_user_id", b_user_id);
		map.put("start", (page-1)*num);
		map.put("num", num);
		return session.selectList(namespace + ".userBoardList", map);
	}
	@Override
	public BoardVO boardRead(int board_code) {
		return session.selectOne(namespace + ".boardRead", board_code);
	}

	@Override
	public void boardInsert(BoardVO vo) {
		session.insert(namespace + ".boardInsert", vo);
	}
	@Override
	public void boardUpdate(BoardVO vo) {
		session.update(namespace + ".boardUpdate", vo);
	}
	@Override
	public void boardDelete(BoardVO vo) {
		session.update(namespace + ".boardDelete", vo);
	}
	@Override
	public void boardReport(int board_code) {
		session.update(namespace + ".boardReport", board_code);
	}
	@Override
	public List<BoardVO> boardReportList(int page, int num) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("start", (page-1)*num);
		map.put("num", num);
		return session.selectList(namespace + ".boardReportList",map);
	}
	@Override
	public List<BoardVO> boardDelList(int page, int num) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("start", (page-1)*num);
		map.put("num", num);
		return session.selectList(namespace + ".boardDelList",map);
	}
	@Override
	public void boardRecommned(int board_code) {
		session.update(namespace + ".boardRecommend", board_code);
	}
	@Override
	public List<BoardVO> boardNoticeList(int page, int num) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("start", (page-1)*num);
		map.put("num", num);
		return session.selectList(namespace + ".boardNoticeList",map);
	}
	@Override
	public void boardDeleteAdmin(BoardVO vo) {
		session.update(namespace + ".boardDeleteadmin", vo);
		
	}
	@Override
	public void boardCommentCnt(int board_code) {
		session.update(namespace + ".boardCommentCnt", board_code);
	}
	@Override
	public List<BoardVO> boardListand(String b_title) {
		return session.selectList(namespace + ".boardListand", b_title);
	}
	@Override
	public int boardListtotal(String b_category, String search) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("b_category", b_category);
		map.put("search", search);
		return session.selectOne(namespace + ".boardListtotal", map);
	}
	@Override
	public void heart(BoardVO vo) {
	
		session.update(namespace + ".heart", vo);

		
	}
	@Override
	public void heartCancel(BoardVO vo) {
		session.update(namespace + ".heartCancel", vo);
		
	}
	@Override
	public List<BoardVO> boardListheart() {
		return session.selectList(namespace + ".boardListheat");
	}
	@Override
	public List<BoardVO> reportBoardList(int page, int num) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("start", (page-1)*num);
		map.put("num", num);
		return session.selectList(namespace + ".reportboardList", map);
	}
	@Override
	public int ReportBoardTotal() {
		return session.selectOne(namespace + ".reportboardListtotal");
	}

}
