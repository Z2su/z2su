package com.java.dataSource;



import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dataSource-context.xml")
public class SqlSessionTest {
	
	@Autowired
	private SqlSession session;
	
	@Test
	public void sqlSessionTest() throws SQLException{
	
		Collection<String> mapNames=
				(Collection<String>) session.getConfiguration().getMappedStatementNames();
		
		
		assertTrue(mapNames.contains("MemberMapper.selectMemberList"));
		
	}
	
	
	
	

}
