package com.bitschool.mentorschool.service;

import com.bitschool.mentorschool.vo.MemberVO;

public interface MemberService {
	
	void checkLogin(MemberVO member);
	
	void registerMember(MemberVO member);
	
}
