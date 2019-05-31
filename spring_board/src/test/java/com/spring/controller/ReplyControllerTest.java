package com.spring.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:context/root-context.xml","classpath:servlet/context/servlet-context.xml"})
@WebAppConfiguration
public class ReplyControllerTest {
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc=MockMvcBuilders.webAppContextSetup(ctx).build();
		
	}
	
	@Test
	public void testListPage() throws Exception{
	
		mockMvc.perform(get("/replies/6991/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.replyList[0].bno",equalTo(6991)))
		.andExpect(jsonPath("$.pageMaker.cri.page",equalTo(1)))
		.andExpect(jsonPath("$.pageMaker.totalCount",equalTo(15)));
	}

}
