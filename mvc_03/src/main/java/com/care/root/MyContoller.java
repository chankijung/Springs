package com.care.root;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyContoller {
	@RequestMapping("index")
	//내가 입력하는 경로
	public String testIndex() {
		
		return "member/index";
		//컨트롤러가 보내주는 경로(VIEW의 특정경로)
//		멤버폴더의 index.jsp로 보내줌
	}
	@RequestMapping("logout")
	public String testLogout(Model model) {
		//model은 jps 페이지에 값을 전달하고 싶을때 사용
		//session도 
		model.addAttribute("test","내용전달");
		return "member/logout";
	}
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv =new ModelAndView();
		mv.addObject("login","로그인 값 전달");
		mv.setViewName("member/login");
		return mv;
	}
	
}
