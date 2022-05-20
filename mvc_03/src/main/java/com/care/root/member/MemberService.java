package com.care.root.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mmmm")//어노테이션 옆에 바로 빈의 이름 지정 가능
				// 이름이 없으면 클래스 이름을 따라감

//연산을 담당함
public class MemberService {
	@Autowired MemberDAO dao;
	public MemberService() {
		System.out.println("service");
	}
	public void insert() {
		System.out.println("dao :" + dao);
		
	}

}
