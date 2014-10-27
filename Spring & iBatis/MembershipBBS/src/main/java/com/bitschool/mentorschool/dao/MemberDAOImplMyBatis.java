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
	public MemberVO read(MemberVO member) {
		System.out.println("read(MemberVO) 호출~!!");
//		return sqlSession.selectOne("selectMember", member);
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
	public int update(MemberVO member) throws Exception {
		return sqlSession.update("updateMember", member);
	}

	@Override
	public int delete(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByMemberId(Long memberId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
