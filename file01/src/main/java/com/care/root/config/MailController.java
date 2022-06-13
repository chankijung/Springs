package com.care.root.config;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {
	@Autowired MailService ms;
	@GetMapping("sendmail")
	public void sendMail( HttpServletRequest request,
					HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ms.sendMail("gajua9507@gmail.com", 
				"테스트 메일(제목)", 
				"(내용)안녕하세요!!");
		out.print("메일을 전송하였습니다");
		
		
		
	}
}
