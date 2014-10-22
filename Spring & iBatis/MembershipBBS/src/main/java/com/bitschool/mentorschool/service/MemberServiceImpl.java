package com.bitschool.mentorschool.service;

import javax.inject.Inject;

import com.bitschool.mentorschool.dao.MemberDAO;
import com.bitschool.mentorschool.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	@Override
	public void checkLogin(MemberVO member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerMember(MemberVO member) {
		// TODO Auto-generated method stub

	}

}
