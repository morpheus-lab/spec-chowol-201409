package com.bitschool.mentorschool.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.bitschool.mentorschool.dao.MemberDAO;
import com.bitschool.mentorschool.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	@Named("memberDAO-myBatis")
	private MemberDAO dao;
	
	@Override
	public void checkLogin(MemberVO member) {
		
	}

	@Override
	public void registerMember(MemberVO member) throws Exception {
		if (member == null) {
			throw new Exception("MemberVO가 NULL입니다.");
		}
		
		int insertResult = 0;
		
		try {
			insertResult = dao.create(member);
		} catch (Exception e) {
			throw e;
		}
		
	}

}
