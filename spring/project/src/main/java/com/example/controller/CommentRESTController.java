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
	
	
	//��ü ��� ����Ʈ
	@RequestMapping("/allList")
	public HashMap<String,Object>  commentList(int page, int num){
		HashMap<String,Object>  map = new HashMap<>();
		map.put("list", dao.commentList(page, num));
		map.put("total", dao.atotalComment());
		return map;
	}
	
	//Ư�� ������ ��ü ��� ����Ʈ
	@RequestMapping("/uclist")
	public List<CommentVO> userCommentList(String c_user_id,int page, int num){
		return dao.userCommentList(c_user_id, page, num);
	}
	
	   //Ư�� �Խñ��� ��� ����Ʈ
	   @RequestMapping("/list/{board_Code}")
	   public List<CommentVO> boardCommentList(@PathVariable int board_Code){
	      return dao.boardCommentList(board_Code);
	   }
	
	 //��� ���
		@RequestMapping(value="/insert", method=RequestMethod.POST)
		public void insert(@RequestBody CommentVO vo){
			service.insert(vo);
		}
	
	//��� ����
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(@RequestBody CommentVO vo){
		dao.commentUpdate(vo);
	}
	
	//��� ����
	@RequestMapping(value="/delete/{comment_code}", method=RequestMethod.POST)
	public void delete(@PathVariable int comment_code){
		dao.commentDelete(comment_code);
	}
	
	//��� ��õ
	@RequestMapping(value="/recommend/{comment_code}", method=RequestMethod.POST)
	public void recommend(@PathVariable int comment_code){
		dao.commentRecommend(comment_code);
	}
	
	//��� �Ű�
	@RequestMapping(value="/report/{comment_code}", method=RequestMethod.POST)
	public void report(@PathVariable int comment_code){
		dao.commentReport(comment_code);
	}
	
	
}
