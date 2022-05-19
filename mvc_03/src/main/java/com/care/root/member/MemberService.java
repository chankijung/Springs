package com.care.root.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
