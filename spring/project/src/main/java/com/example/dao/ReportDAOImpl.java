package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

import com.example.domain.ReportVO;

@Repository
public class ReportDAOImpl implements ReportDAO{

	@Autowired
	SqlSession session;
	String namespace = "com.example.mapper.ReportMapper";
	
	@Override
	public List<ReportVO> reportList() {
		return session.selectList(namespace + ".reportListcategory");
	}

}
