package com.bitschool.mentorschool.service;

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitschool.mentorschool.dao.BoardDAO;
import com.bitschool.mentorschool.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> getBoardList(int page, int pageSize) throws Exception {
		return dao.selectList(page, pageSize);
	}

	@Override
	public BoardVO read(BigInteger bno) throws Exception {
		return dao.select(bno);
	}

	@Override
	public int write(BoardVO board) throws Exception {
		return dao.insert(board);
	}

	@Override
	public int modify(BoardVO board) throws Exception {
		return dao.update(board);
	}

	@Override
	public int delete(BoardVO board) throws Exception {
		return dao.delete(board);
	}

}
