package com.care.root.get_post;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("m2")
@RequestMapping("member")
public class MyController {
	@RequestMapping(value="index")
	//다른 컨트롤러와 경로가 겹치거나, 클래스의 이름이 같으면 에러가 생긴다
	//에러를 방지하기 위해 컨트롤러의 이름을 지정하고,
	//경로의 이름을 누구의 인덱스~ 이런식으로 바꾼다
	
	//requestMapping을 통해 여러 경로의 공통부분을 퉁칠 수 있따
	// 위에 적은 걸로는 member의 index와 result 경로를 호출 가능
	
	public String index() {
		return "get_post/index";
	}

	/*
	 * @RequestMapping(value="member/result" , method= RequestMethod.GET )
	 * get방식만 받는 방법 >> getMapping 이용
	 */
	@GetMapping("member/result")
	public String get(HttpServletRequest request, Model model) {
		String name= request.getParameter("name");
		String age= request.getParameter("age");
		
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		model.addAttribute("method",request.getMethod());
		
		
	
		
		System.out.println(name);
		System.out.println(age);
		return "get_post/result";
	}

	@PostMapping("result")
	public String post(HttpServletRequest request, Model model,
			@RequestParam("name") String name,
			@RequestParam String age) {
		
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		model.addAttribute("method",request.getMethod());
		
		System.out.println(name);
		System.out.println(age);
		return "get_post/result";
	}
	@RequestMapping(value="obj", method=RequestMethod.POST)
	public String obj(Model model, MyDTO dto) {
		
		model.addAttribute("name", dto.getName());
		model.addAttribute("age", dto.getAge());
		
		
		model.addAttribute("dto", dto);
		return "get_post/result";
	}
	
}
