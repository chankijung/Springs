package com.care.root.member;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//연결하는 역할만 함
public class MemberController {
	//@Autowired
	@Inject
	@Qualifier("mmmm")
	MemberService ms;
	
	public MemberController() {
		System.out.println("controller");
	}
	@RequestMapping("insert")
	public String insert() {
		System.out.println("ms : "+ms);
		
		//MemberService ms = new MemberService();
		//autowired를 쓰면 전부 autowired에 연결해야함
		// 따로 객체를 만들면 연결이 안되기때문에 null값이 저장돼버림
		// 이럴 일 없지만 new를 사용하지 않도록 한다
		
		
		ms.insert();
		return "index";
	}
}
