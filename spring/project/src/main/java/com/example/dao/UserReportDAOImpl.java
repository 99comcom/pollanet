package com.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.UserReportVO;



@Repository
public class UserReportDAOImpl implements UserReportDAO{
	
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.UserReportMapper";

	@Override
	public void BoardReportInsert(UserReportVO vo) {
		session.insert(namespace + ".boardreportInser", vo);
	}

	@Override
	public void CommentReportInsert(UserReportVO vo) {
		session.insert(namespace + ".commentreportInser", vo);
		
	}
	
	
}
