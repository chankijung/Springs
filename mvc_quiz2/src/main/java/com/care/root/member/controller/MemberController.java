package com.care.root.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.common.SessionName;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController implements SessionName {
	@Autowired MemberService ms;
	
	@GetMapping("login")
	public String loginForm() {
		return "member/login";
	}
	@PostMapping("logChk")
	public String logChk(@RequestParam String id, @RequestParam String pwd,
						RedirectAttributes ra
							//,HttpServletRequest req
			) {
		int result= ms.logChk(id, pwd);
		if(result==0) {
			//ra.addFlashAttribute("id", id);			
			ra.addAttribute("id",id); // 아이디를 받고 여기에 세션 부여

			return "redirect:successLogin";
		}
		return "redirect:login";
	}
	
	@GetMapping("successLogin")
	public String successLogin(@RequestParam String id, HttpSession session) {
		session.setAttribute(LOGIN, id); //위에서 받은 아이디에 세션 적용
		return "member/successLogin";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
	@GetMapping("memberInfo")
	public String memberInfo(Model model) {
		ms.memberInfo(model);
		return "member/memberInfo";
	}
	
	@GetMapping("info")
	public String info(Model model, @RequestParam String id) {
		ms.info(model, id);
		return "member/info";
	}
	
	@GetMapping("register_form")
	public String register_form() {
		return "member/register";
	}
	
	@PostMapping("register")
	public String register(MemberDTO dto) {
		int result = ms.register(dto);
		if(result ==1) 
			return "redirect:login";
		return "redirect:register_form";
	}
}
