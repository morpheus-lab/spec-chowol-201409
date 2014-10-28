package com.bitschool.mentorschool.dao;

import java.math.BigInteger;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bitschool.mentorschool.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public int insert(BoardVO board) {
		return sqlSession.insert("insertBoard", board);
	}

	@Override
	public BoardVO select(BigInteger bno) {
		return sqlSession.selectOne("selectBoardByBno", bno);
	}

	@Override
	public List<BoardVO> selectList(int page, int pageSize) {
		Map<String, Integer> params = new Hashtable<String, Integer>();
		params.put("page", page);
		params.put("pageSize", pageSize);
		
		return sqlSession.selectList("selectBoardList", params);
	}

	@Override
	public int update(BoardVO board) {
		return sqlSession.update("updateBoard", board);
	}

	@Override
	public int delete(BoardVO board) {
		return sqlSession.delete("deleteBoard", board);
	}

	@Override
	public int deleteByBno(BigInteger bno) {
		return sqlSession.delete("deleteBoardByBno", bno);
	}

	@Override
	public int getTotalPages(int pageSize) {
		return sqlSession.selectOne("getTotalPages", pageSize);
	}
	
}



























