package com.care.root.mybatis.member;

import java.util.List;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	

	public MemberDTO logChk(String id);
	public List<MemberDTO> memberInfo();
	public int register(MemberDTO dto);

}
