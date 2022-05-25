package com.care.mybatis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.care.mybatis.member.controller.MemberController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
		"classpath:testMember.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class TestMock {
	@Autowired 
	MemberController mc;
	MockMvc mock;
	
	@Before
	public void setUp() {
		System.out.println("test 실행전 -----");
		mock= MockMvcBuilders.standaloneSetup(mc).build();
	}
	//org.junit
	@Test
	public void testIndex() throws Exception {
		System.out.println("----teset 코드 실행");
		Assert.assertNull(null);
		mock.perform(get("/index"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("member/index"));
	}
	
	@Test
	@Transactional(transactionManager = "txMgr")
	public void testInsert() throws Exception{
		mock.perform(post("/insert")
				.param("id", "999").param("name", "ddd"))
				.andDo(print())
				//redirect값이 302인지 확인
				//302면 다른위치로 이동시킴
				.andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void testMemberView() throws Exception{
		mock.perform(get("/memberview"))
				.andDo(print())
				.andExpect(forwardedUrl("memberview"))
				.andExpect(model().attributeExists("list"));
	}
}
