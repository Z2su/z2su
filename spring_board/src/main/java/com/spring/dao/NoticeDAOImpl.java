package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.dto.NoticeVO;
import com.spring.request.Criteria;

public class NoticeDAOImpl implements NoticeDAO {
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}

/*	@Override
	public List<NoticeVO> selectSearchNoticeList(Criteria cri, int pointCount) throws SQLException {
		
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum()-pointCount;
		RowBounds rowbounds = new RowBounds(offset, limit);
		
		
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectSearchNoticeList",cri, rowbounds);
		
		
		return noticeList;
	}*/
	@Override
	public List<NoticeVO> selectSearchNoticeList(Criteria cri, int pointCount) throws SQLException {
		
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowbounds = new RowBounds(offset, limit);
		
		
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectSearchNoticeList",cri, rowbounds);
		
		
		return noticeList;
	}

	@Override
	public List<NoticeVO> selectNoticeList() throws SQLException {

		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectNoticeList");

		return noticeList;
	}

	@Override
	public List<NoticeVO> selectPointNoticeList() throws SQLException {
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectPointNoticeList");

		return noticeList;
	}

	@Override
	public NoticeVO selectNoticeByNno(int nno) throws SQLException {

		NoticeVO notice = session.selectOne("Notice-Mapper.selectNoticeByNno",nno);
		return notice;
	}

	@Override
	public void insertNotice(NoticeVO notice) throws SQLException {
		
		session.update("Notice-Mapper.insertNotice", notice);
		

	}

	@Override
	public void updateNotice(NoticeVO notice) throws SQLException {
		session.update("Notice-Mapper.updateNotice", notice);


	}

	@Override
	public void deleteNotice(int nno) throws SQLException {
		session.update("Notice-Mapper.deleteNotice", nno);

	}

	@Override
	public void increaseViewCount(int nno) throws SQLException {
		session.update("Notice-Mapper.increaseViewCount",nno);

	}

	@Override
	public int selectNoticeListTotalCount(Criteria cri) throws SQLException {
		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectSearchNoticeList");
		return noticeList.size();
	}

}
