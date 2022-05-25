package com.care.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("result")
	public String result(
			HttpServletRequest req, Model model,
			RedirectAttributes rs) {
		String id = req.getParameter("id");
		if(id.equals("abc")) {
			model.addAttribute("result","abcd");
			rs.addFlashAttribute("result1","새로운값");
			return "redirect:rs_ok";
			//return "rs_ok";
		}
		return "redirect:rs_no";
	}
	@GetMapping("rs_ok")
	public String rsOk(Model model,
			@RequestParam(value = "result", required = false) String r) {
		System.out.println("r : "+r);
		model.addAttribute("id",
				"로그인 성공시 데이터베이스로 부터 가져온 값");
		return "rs_ok";
	}
	@GetMapping("rs_no")
	public String rsNo() {
		return "rs_no";
	}
	
	@PostMapping("loginChk")
	public String loginChk(@RequestParam String id,
		@RequestParam String pwd,
		Model model) {
		int result = ms.loginChk(id,pwd,model)
		
	}

}
