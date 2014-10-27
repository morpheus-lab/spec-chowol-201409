package com.bitschool.mentorschool.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitschool.mentorschool.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	
	
	@Override
	public List<BoardVO> getBoardList(int page, int pageSize) {
		return null;
	}

	@Override
	public BoardVO write(BoardVO board) {
		return null;
	}

	@Override
	public BoardVO modify(BoardVO board) {
		return null;
	}

	@Override
	public boolean delete(BoardVO board) {
		return false;
	}

}
