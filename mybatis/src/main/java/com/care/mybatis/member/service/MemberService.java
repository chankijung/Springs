package com.care.mybatis.member.service;

import org.springframework.ui.Model;

import com.care.mybatis.member.dto.MemberDTO;
	
public interface MemberService {
	public void insertMember(MemberDTO dto);
	public void memverView(Model model);
}
