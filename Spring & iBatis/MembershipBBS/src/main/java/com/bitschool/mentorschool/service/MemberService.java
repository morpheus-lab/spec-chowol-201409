package com.bitschool.mentorschool.service;

import org.springframework.stereotype.Service;

import com.bitschool.mentorschool.vo.MemberVO;

@Service
public interface MemberService {
	
	void checkLogin(MemberVO member);
	
	void registerMember(MemberVO member);
	
}
