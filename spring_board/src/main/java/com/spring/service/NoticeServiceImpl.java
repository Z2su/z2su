package com.spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.dao.NoticeDAO;
import com.spring.dto.MemberVO;
import com.spring.dto.NoticeVO;
import com.spring.request.Criteria;
import com.spring.request.PageMaker;

public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDAO noticeDAO;
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO=noticeDAO;
	}

/*	
  @Override
	public Map<String, Object> getNoticeList(Criteria cri) throws SQLException {
		List<NoticeVO> noticeList = noticeDAO.selectSearchNoticeList(cri);
		int totalCount = noticeDAO.selectNoticeListTotalCount(cri);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		System.out.println("ffffffffffff"+pageMaker.getTotalCount());
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("noticeList", noticeList);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}
	
*/
	@Override
	public Map<String, Object> getNoticeList(Criteria cri) throws SQLException {
		List<NoticeVO> pointList = noticeDAO.selectPointNoticeList();
		int pointCount = pointList.size();
		//int perPageNum = cri.getPerPageNum()-pointCount;
		
		//cri.setPerPageNum(perPageNum);
		

		List<NoticeVO> noticeList = noticeDAO.selectSearchNoticeList(cri, pointCount);
		int totalCount = noticeDAO.selectNoticeListTotalCount(cri);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("pointList", pointList);
		dataMap.put("noticeList", noticeList);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}


	@Override
	public NoticeVO getNotice(int nno) throws SQLException {
		
		NoticeVO notice = noticeDAO.selectNoticeByNno(nno);
		noticeDAO.increaseViewCount(nno);
		return notice;
	}

	@Override
	public NoticeVO getNoticeFormodify(int nno) throws SQLException {
		
		NoticeVO notice = noticeDAO.selectNoticeByNno(nno);
		
		
		return notice;
	}

	@Override
	public void write(NoticeVO notice) throws SQLException {
		noticeDAO.insertNotice(notice);
		
	}

	@Override
	public void modify(NoticeVO notice) throws SQLException {

		noticeDAO.updateNotice(notice);
	}

	@Override
	public void remove(int nno) throws SQLException {

		noticeDAO.deleteNotice(nno);
	}

}
