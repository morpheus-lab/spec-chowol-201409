package com.bitschool.mentorschool.service;

import java.util.List;

import com.bitschool.mentorschool.vo.MemberVO;

public interface AdminService {
	
	// 회원 목록 조회 기능
	List<MemberVO> getMemberList() throws Exception;
	
	// 회원 레벨 수정 기능
	MemberVO modifyMemberLevel(MemberVO member) throws Exception;
	
}
