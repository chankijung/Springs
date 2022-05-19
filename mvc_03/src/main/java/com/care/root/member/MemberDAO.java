package com.care.root.member;

import org.springframework.stereotype.Repository;

@Repository
// db 연결을 담당한다
public class MemberDAO {
	public MemberDAO() {
		System.out.println("memberDAO");
	}

}
