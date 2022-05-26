package com.care.root.member.service;

import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {
	public int logChk(String id,String pwd);
	public void memberInfo(Model model);
	public void info(Model model, String id);
	public int register(MemberDTO dto);
}
