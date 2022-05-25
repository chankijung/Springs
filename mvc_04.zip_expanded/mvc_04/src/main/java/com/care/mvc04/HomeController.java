package com.care.mvc04;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@GetMapping("index")
	public String index() {
		return "index";
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
}














