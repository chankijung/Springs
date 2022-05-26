package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberMapper mapper;

	@Override
	public int logChk(String id, String pwd) {
		int result=1;
		//쿼리문
		// selet * from table where id=id
		MemberDTO dto = mapper.logChk(id);
		if(dto != null) {
			if(dto.getPw().equals(pwd)) {
				return 0;
			}
		}
		return result;
	}

	@Override
	public void memberInfo(Model model) {
		model.addAttribute("memberList",mapper.memberInfo());
	}

	@Override
	public void info(Model model,String id) {
		model.addAttribute("info",mapper.logChk(id));
	}

	@Override
	public int register(MemberDTO dto) {
		//insert into membership values('aaa','aaa',aaa')'
		int result=0;
		try {
			result = mapper.register(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
