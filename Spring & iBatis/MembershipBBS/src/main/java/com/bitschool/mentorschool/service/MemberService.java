package com.bitschool.mentorschool.service;

import com.bitschool.mentorschool.vo.MemberVO;

public interface MemberService {
	
	MemberVO checkLogin(MemberVO member) throws Exception;
	
	void registerMember(MemberVO member) throws Exception;
	
	MemberVO modifyMember(MemberVO member) throws Exception;
	
}
