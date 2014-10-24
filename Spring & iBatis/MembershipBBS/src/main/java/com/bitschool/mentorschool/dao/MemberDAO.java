package com.bitschool.mentorschool.dao;

import com.bitschool.mentorschool.vo.MemberVO;

public interface MemberDAO {
	
	int create(MemberVO member) throws Exception;
	
	MemberVO read(Long memberId) throws Exception;
	MemberVO read(MemberVO member) throws Exception;
	MemberVO readById(String id) throws Exception;
	MemberVO readByEmail(String email) throws Exception;
	
	void update(MemberVO member) throws Exception;
	
	void delete(MemberVO member) throws Exception;
	void deleteByMemberId(Long memberId) throws Exception;
	
}
