package com.care.mvc04;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
@Controller


public class CookieController {
	
	public void cookie(
		HttpServletResponse response,
		HttpServletRequest request,
		@CookieValue(value="myCookie", required = false) Cookie co) {
		
			System.out.println("co: "+co);
			Cookie[] cookies= request.getCookies();
			for(Cookie c: cookies) {
				System.out.println(c.getValue());
				System.out.println(c.getName());
				System.out.println("=============");
			}
		Cookie cook= new Cookie("myCookie", "testCookie");
		//cook.setPath("/");
		cook.getMaxAge();
		response.addCookie(cook);
		}
	 
	

	@GetMapping("session/makeSession")
	public void makeSession(
			HttpServletRequest request,
			Model model) {
		model.addAttribute("id","model 아이디");
		HttpSession session = request.getSession();
		session.setAttribute("id", "홍길동");
		session.setAttribute("name", "홍길동구리구리");
		
	//	return "session/makeSession";
	}
	
	@GetMapping("session/resultSession")
	public void resultSession() {
		
	}
	@GetMapping("session/delSession")
	public String delSession(HttpSession session) {
		session.removeAttribute("id");
		//session.invalidate(); 모든 세션 제거
		return "session/delSession";
	}
}
