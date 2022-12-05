package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.CommentDAO;
import com.example.domain.CommentVO;
import com.example.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentRESTController {

	@Autowired
	CommentDAO dao;
	@Autowired
	CommentService service;
	
	
	//전체 댓글 리스트
	@RequestMapping("/allList")
	public HashMap<String,Object>  commentList(int page, int num){
		HashMap<String,Object>  map = new HashMap<>();
		map.put("list", dao.commentList(page, num));
		map.put("total", dao.atotalComment());
		return map;
	}
	
	//특정 유저의 전체 댓글 리스트
	@RequestMapping("/uclist")
	public List<CommentVO> userCommentList(String c_user_id,int page, int num){
		return dao.userCommentList(c_user_id, page, num);
	}
	
	   //특정 게시글의 댓글 리스트
	   @RequestMapping("/list/{board_Code}")
	   public List<CommentVO> boardCommentList(@PathVariable int board_Code){
	      return dao.boardCommentList(board_Code);
	   }
	
	 //댓글 등록
		@RequestMapping(value="/insert", method=RequestMethod.POST)
		public void insert(@RequestBody CommentVO vo){
			service.insert(vo);
		}
	
	//댓글 수정
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(@RequestBody CommentVO vo){
		dao.commentUpdate(vo);
	}
	
	//댓글 삭제
	@RequestMapping(value="/delete/{comment_code}", method=RequestMethod.POST)
	public void delete(@PathVariable int comment_code){
		dao.commentDelete(comment_code);
	}
	
	//댓글 추천
	@RequestMapping(value="/recommend/{comment_code}", method=RequestMethod.POST)
	public void recommend(@PathVariable int comment_code){
		dao.commentRecommend(comment_code);
	}
	
	//댓글 신고
	@RequestMapping(value="/report/{comment_code}", method=RequestMethod.POST)
	public void report(@PathVariable int comment_code){
		dao.commentReport(comment_code);
	}
	
	
}
