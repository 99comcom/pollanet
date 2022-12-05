package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dao.BoardDAO;
import com.example.dao.BoardHeartDAO;
import com.example.dao.CharacterDAO;
import com.example.dao.CommentDAO;
import com.example.dao.MissionDAO;
import com.example.dao.UserDAO;
import com.example.dao.UserPointDAO;
import com.example.domain.BoardHeartVO;
import com.example.domain.BoardVO;
import com.example.domain.CommentVO;
import com.example.domain.MissionUserVO;
import com.example.domain.MissionVO;
import com.example.domain.UserPointVO;
import com.example.domain.UserReportVO;
import com.example.domain.UserStatusVO;
import com.example.service.CommentService;
import com.example.service.MissionService;
import com.example.service.UserReportService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MysqlTest {	
	
	@Autowired
	BoardDAO bdao;
	@Autowired
	MissionDAO mdao;
	@Autowired
	CharacterDAO cdao;
	@Autowired
	CommentService cservice;
	

//	@Test
//	public void update(){
//		UserStatusVO usvo = new UserStatusVO();
//		usvo.setUser_id("tarry");
//		usvo.setName("Tarry");
//		usvo.setTel("010-0111-1111");
//		usvo.setNickName("Tarry");
//		udao.updateUserstatus(usvo);
//	}
//	@Test
//	public void upatedel(){
//		UserStatusVO usvo = new UserStatusVO();
//		usvo.setUser_del("0");
//		usvo.setUser_id("tarry");
//		udao.userdelupdate(usvo);
//	}
	@Test
	public void minsert(){
		MissionVO vo = new MissionVO();
		vo.setM_category("1");
		vo.setM_image("zz");
		vo.setM_title("test");
		vo.setM_info("test");
		vo.setM_content("test");
		vo.setM_target(1);
		vo.setM_get_point(20);
		vo.setM_user_id("tarry");
		vo.setM_sort("1");
		mdao.insert(vo);
	}
//}
//	@Test
//	public void read(){
//		updao.rankListWeb("a", 1, 5);
//		}
	}

	
