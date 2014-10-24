package com.bitschool.mentorschool.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bitschool.mentorschool.vo.MemberVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<MemberVO> getMemberList() throws Exception {
		return sqlSession.selectList("selectMemberList");
	}

}
