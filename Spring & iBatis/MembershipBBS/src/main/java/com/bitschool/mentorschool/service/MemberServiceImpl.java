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
	public MemberVO checkLogin(MemberVO member) throws Exception {
		return dao.read(member);
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

	@Override
	public MemberVO modifyMember(MemberVO member) throws Exception {
		// DAO에게 update를 시킴
		dao.update(member);
		// 업데이트 된 MemberVO 객체를 리턴
		return member;
	}

}
