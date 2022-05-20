package com.care.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.member.dto.MemberDTO;
import com.care.member.service.MemberService;

@Controller

public class MemberController {
	@Autowired MemberService ms;
	@GetMapping("index")
	public String index() {
		return "member/index";
	}
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	@PostMapping("reg")
	public String reg(MemberDTO dto) {
		System.out.println(dto.getId());
		System.out.println(dto.getPwd());
		System.out.println(dto.getName());
		ms.join(dto);
		return "member/index";
	}
	@GetMapping("views")
	public String views(Model model) {
		
		ms.getM(model);
		return "views";
	}
}
