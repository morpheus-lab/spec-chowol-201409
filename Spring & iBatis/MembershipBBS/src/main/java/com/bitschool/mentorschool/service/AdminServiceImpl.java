package com.bitschool.mentorschool.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitschool.mentorschool.dao.AdminDAO;
import com.bitschool.mentorschool.vo.MemberVO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	AdminDAO dao;
	
	@Override
	public List<MemberVO> getMemberList() throws Exception {
		// DAO를 통해 회원 목록 조회
		List<MemberVO> list = dao.getMemberList();
		// 회원 목록 리턴
		return list;
	}

	@Override
	public MemberVO modifyMemberLevel(MemberVO member) throws Exception {
		
		return null;
	}

}
