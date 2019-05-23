package com.spring.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.MemberVO;
import com.spring.request.Criteria;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/root-context.xml")
@TransactionConfiguration(transactionManager="transactionManager")
@Transactional
public class MybatisMemberDAOImplTest {
	@Autowired
	private MemberDAO memberDAO;
	

	@Test
	public void testSelectMemberById() throws SQLException {
		String id = "mimi";
		
		MemberVO member = memberDAO.selectMemberById(id);
		assertEquals("mimi", member.getId());
	}

	@Test
	public void testInsertMember() throws SQLException {
		MemberVO member = new MemberVO();
		member.setId("0101");
		member.setPwd("0101");
		member.setEmail("0101");
		member.setPhone("01012341234");
		member.setPicture("");
		memberDAO.insertMember(member);
		MemberVO receiveMember = memberDAO.selectMemberById(member.getId());
		assertEquals(member.getId(), receiveMember.getId());
		
		
	}

	@Test
	public void testUpdateMember() throws SQLException{
		MemberVO member = memberDAO.selectMemberById("mimi");
		String pwd= "mimi2";
		member.setPwd(pwd);
		memberDAO.updateMember(member);
		MemberVO receive = memberDAO.selectMemberById("mimi");
		assertEquals(pwd, receive.getPwd());
	}

	@Test
	public void testDeleteMember() throws SQLException{
		String id ="mimi";
		MemberVO receiveMember = memberDAO.selectMemberById(id);
		if(receiveMember !=null) {
		memberDAO.deleteMember(id);
		MemberVO deletedMember = memberDAO.selectMemberById(id);
		assertNull(deletedMember);
		}else {
			System.out.println("mimi회원은 존재 x");
		}
		
		
	}

	@Test
	public void testDisableMember() throws SQLException{
		String id = "mimi";
		memberDAO.disableMember(id);
		MemberVO disabledMember = memberDAO.selectMemberById(id);
		assertEquals(0, disabledMember.getEnabled());
	}

	@Test
	public void testSelectMemberListCriteria() throws SQLException{
		Criteria cri = new Criteria();
		
		List<MemberVO> memberList = memberDAO.selectMemberList(cri);
		
		assertEquals(cri.getPerPageNum(), memberList.size());
		
	}

	@Test
	public void testSelectMemberListCount() throws SQLException {
		Criteria cri = new Criteria();
		cri.setSearchType("i");
		cri.setKeyword("mimi");
		int count = memberDAO.selectMemberListCount(cri);
		assertEquals(2, count);
		
	}

}
