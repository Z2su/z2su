package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.NoticeVO;
import com.spring.request.Criteria;

public interface NoticeDAO {

	List<NoticeVO> selectSearchNoticeList(Criteria cri, int pointCount) throws SQLException;
	List<NoticeVO> selectNoticeList() throws SQLException;
	List<NoticeVO> selectPointNoticeList() throws SQLException;
	NoticeVO selectNoticeByNno(int nno) throws SQLException;
	void insertNotice(NoticeVO notice) throws SQLException;
	void updateNotice(NoticeVO notice) throws SQLException;
	void deleteNotice(int nno) throws SQLException;
	void increaseViewCount(int nno) throws SQLException;
	int selectNoticeListTotalCount(Criteria cri) throws SQLException;
	
	
	
}
