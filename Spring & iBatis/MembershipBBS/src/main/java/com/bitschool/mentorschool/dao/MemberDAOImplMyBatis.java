package com.bitschool.mentorschool.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bitschool.mentorschool.vo.MemberVO;

@Repository("memberDAO-myBatis")
public class MemberDAOImplMyBatis implements MemberDAO {
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public int create(MemberVO member) throws Exception {
		return sqlSession.insert("registerMember", member);
	}

	@Override
	public MemberVO read(Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO readById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO readByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MemberVO member) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(MemberVO member) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByMemberId(Long memberId) throws Exception {
		// TODO Auto-generated method stub

	}

}
