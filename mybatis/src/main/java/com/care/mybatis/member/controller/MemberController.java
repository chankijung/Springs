package com.care.mybatis.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.care.mybatis.member.dto.MemberDTO;
import com.care.mybatis.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService ms;
	@GetMapping("index")
	public String index() {
		return "index";
	}
	@GetMapping("insertview")
	public String insertview() {
		return "insertview";
	}
	@PostMapping("insert")
	public String insert(MemberDTO dto) {
		System.out.println(dto.getId());
		System.out.println(dto.getName());
		ms.insertMember(dto);
		System.out.println("다음 내용 실행");
		return "redirect:index";
	}
	
	@GetMapping("memberview")
	public String memberview(Model model) {
		ms.memverView(model);
		return "memberview";
	}
	
	
	

}
