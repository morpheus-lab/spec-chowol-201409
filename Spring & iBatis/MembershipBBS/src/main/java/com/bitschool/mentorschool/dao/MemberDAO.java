package com.bitschool.mentorschool.dao;

import org.springframework.stereotype.Repository;

import com.bitschool.mentorschool.vo.MemberVO;

@Repository
public interface MemberDAO {
	
	void create(MemberVO member);
	
	MemberVO read(Long memberId);
	MemberVO readById(String id);
	MemberVO readByEmail(String email);
	
	void update(MemberVO member);
	
	void delete(MemberVO member);
	void deleteByMemberId(Long memberId);
	
}
