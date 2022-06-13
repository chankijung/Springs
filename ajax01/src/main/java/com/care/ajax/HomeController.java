package com.care.ajax;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@GetMapping("rest01")
	public String rest01() {
		return "rest01";
	}
	@GetMapping("getuser")
	public String getuser() {
		return "getuser";
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@GetMapping("non_ajax")
	public String nonAjax() {
		System.out.println("non_ajax");
		return "non_ajax";
	}
	
	@GetMapping("ajax")
	public String ajax() {
		System.out.println("ajax");
		return "ajax";
	}
	@GetMapping("ajax02")
	public String ajax02() {
		return "ajax02";
}
	static int cnt= 0;
	@GetMapping("ajax_result02")
	@ResponseBody()
	// 없으면 jsp로 날아감, 있으면 data로 날아감
	public String ajax_result02() {
		return ++cnt+"";
	}
	
	@GetMapping("ajax03")
	public String ajax03() {
		return "ajax03";
	}
	
	@PostMapping(value="ajax_result03",
			produces = "application/json; charset=utf-8")
	@ResponseBody
	public InfoDTO ajax_result03(@RequestBody InfoDTO dto) {
		System.out.println("이름 :"+dto.getName());
		System.out.println("나이:"+dto.getAge());
		
		return dto;
		
	}
	
	@GetMapping("ajax04")
	public String ajax04() {
		return "ajax04";
	}
	
	@PostMapping(value="ajax_result04",
			produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> ajax_result04(@RequestBody Map<String, Object> dto) {
		return dto;
	}
	
	
}
