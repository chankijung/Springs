package com.care.root;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WayController {
	@RequestMapping("index1")
	public String wayIndex(Model model) {
		model.addAttribute("way","request:기본페이지");
		return "way/index";
	}
	@RequestMapping("logout1")
	public String wayLogout(Model model) {
		model.addAttribute("way","el:로그아웃페이지");
		return "way/logout";
	}
	@RequestMapping("login1")
	public ModelAndView wayLogin() {
		ModelAndView mv =new ModelAndView();
		mv.addObject("login","로그인 페이지");
		mv.setViewName("way/login");
		return mv;
	}
}
