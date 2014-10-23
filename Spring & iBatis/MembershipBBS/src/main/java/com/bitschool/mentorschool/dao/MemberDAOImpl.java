package com.bitschool.mentorschool.dao;

import org.springframework.stereotype.Repository;

import com.bitschool.mentorschool.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Override
	public void create(MemberVO member) {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberVO read(Long memberId) {
		// TODO Auto-generated method stub
		System.out.println("MemberVO의 read 메서드 호출!!!");
		return null;
	}

	@Override
	public MemberVO readById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO readByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MemberVO member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(MemberVO member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByMemberId(Long memberId) {
		// TODO Auto-generated method stub

	}

}
