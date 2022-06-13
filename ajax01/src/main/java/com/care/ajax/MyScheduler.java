package com.care.ajax;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//객체로만 쓰겠음
@EnableScheduling
public class MyScheduler {
	//@Scheduled(cron ="0-59 * * * * *")
	public void test() {
		System.out.println("test 실행");
		//특정 날짜에 뭔가를 실행해서 웹브라우저에 표현하겠다 
	}
}
