package com.care.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.member.dao.MemberDAO;
import com.care.member.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired MemberDAO dao;
	public void join(MemberDTO dto) {
		dao.join(dto);
	}
	public void getM(Model model) {
		model.addAttribute("list", dao.getM());
	}
	public int loginChk(String id, String pwd, Model model)
	{	//select * from member where id=id
		/*
		 * MemberDTO dto = dao.loginChk(id); if(dto != null) {
		 * if(dto.getPwd().equals("re",0)) { model.addAttribute(attributeValue) }
		 * 
		 * }else { model.addAttribute("re",1);
		 * 
		 * }
		 */
	}

}
