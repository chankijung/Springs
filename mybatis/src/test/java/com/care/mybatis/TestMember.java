package com.care.mybatis;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.mybatis.member.controller.MemberController;
import com.care.mybatis.member.dao.MemberDAO;
import com.care.mybatis.member.dto.MemberDTO;
import com.care.mybatis.member.service.MemberService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
		"classpath:testMember.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class TestMember {
	@Autowired MemberController mc;
	@Autowired MemberService ms;
	@Autowired MemberDAO dao;
	
	@Test
	public void testMc() {
		System.out.println("===mc =>"+mc);
		assertNotNull(mc);
	}
	
	@Test
	public void testMs() {
		System.out.println("===ms =>"+ms);
		assertNotNull(ms);
		
		MemberDTO dto = new MemberDTO();
		dto.setId(333);
		dto.setName("고고고");
		ms.insertMember(dto);
	}
	
	@Test
	public void testDao() {
		System.out.println("==dao =>" +dao);
		assertNotNull(dao);
		
		MemberDTO dto = new MemberDTO();
		dto.setId(222);
		dto.setName("김김김");
		ms.insertMember(dto);
	}
	
	
	}
