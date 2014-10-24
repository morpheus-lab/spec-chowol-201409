package com.bitschool.mentorschool.dao;

import com.bitschool.mentorschool.vo.MemberVO;

public interface MemberDAO {
	
	int create(MemberVO member) throws Exception;
	
	MemberVO read(Long memberId) throws Exception;
	MemberVO read(MemberVO member) throws Exception;
	MemberVO readById(String id) throws Exception;
	MemberVO readByEmail(String email) throws Exception;
	
	int update(MemberVO member) throws Exception;
	
	int delete(MemberVO member) throws Exception;
	int deleteByMemberId(Long memberId) throws Exception;
	
}
