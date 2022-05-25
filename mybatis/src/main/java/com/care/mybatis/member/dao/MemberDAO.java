package com.care.mybatis.member.dao;

import java.util.List;

import com.care.mybatis.member.dto.MemberDTO;

public interface MemberDAO {
	public void insertMember(MemberDTO dto);
	public List<MemberDTO> memberView();
}
