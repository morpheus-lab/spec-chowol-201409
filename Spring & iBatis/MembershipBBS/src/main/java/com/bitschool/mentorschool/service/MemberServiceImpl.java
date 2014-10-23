package com.bitschool.mentorschool.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitschool.mentorschool.dao.MemberDAO;
import com.bitschool.mentorschool.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	@Override
	public void checkLogin(MemberVO member) {
		// TODO Auto-generated method stub
		dao.read(0L);
	}

	@Override
	public void registerMember(MemberVO member) {
		// TODO Auto-generated method stub

	}

}
