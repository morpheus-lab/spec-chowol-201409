package com.bitschool.mentorschool.dao;

import com.bitschool.mentorschool.vo.MemberVO;

public interface MemberDAO {
	
	void create(MemberVO member);
	
	MemberVO read(Long memberId);
	MemberVO readById(String id);
	MemberVO readByEmail(String email);
	
	void update(MemberVO member);
	
	void delete(MemberVO member);
	void deleteByMemberId(Long memberId);
	
}
