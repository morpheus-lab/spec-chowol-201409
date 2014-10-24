package com.bitschool.mentorschool.dao;

import java.util.List;

import com.bitschool.mentorschool.vo.MemberVO;

public interface AdminDAO {
	
	// member 테이블로부터 회원 정보 목록을 조회
	List<MemberVO> getMemberList() throws Exception;
	
}
