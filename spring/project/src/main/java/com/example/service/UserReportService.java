package com.example.service;

import com.example.domain.UserReportVO;

public interface UserReportService {
	public void BoardReportInsert(UserReportVO urvo);
	public void CommentReportInsert(UserReportVO urvo);

}
