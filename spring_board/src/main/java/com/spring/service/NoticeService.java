package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.dto.NoticeVO;
import com.spring.request.Criteria;

public interface NoticeService {
	
	 Map<String, Object> getNoticeList(Criteria cri) throws SQLException;
	 
	 NoticeVO getNotice(int nno) throws SQLException;
	 NoticeVO getNoticeFormodify(int nno) throws SQLException;
	 
	 void write(NoticeVO notice) throws SQLException;
	 void modify(NoticeVO notice) throws SQLException;
	 void remove(int nno) throws SQLException;
	 
	 

}
