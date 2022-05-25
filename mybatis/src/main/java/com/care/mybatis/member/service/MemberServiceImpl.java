package com.care.mybatis.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.mybatis.member.dao.MemberDAO;
import com.care.mybatis.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO mapper;
	
	
	public void insertMember(MemberDTO dto) {
		try {
			mapper.insertMember(dto);
			//사용자에게 에러를 보이면 안되니까 예외처리 해줌
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void memverView(Model model) {
		model.addAttribute("list", mapper.memberView());
		
	}
}
