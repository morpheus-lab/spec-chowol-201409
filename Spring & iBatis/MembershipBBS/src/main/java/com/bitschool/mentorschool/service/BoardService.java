package com.bitschool.mentorschool.service;

import java.util.List;

import com.bitschool.mentorschool.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> getBoardList(int page, int pageSize);	// getBoardList(1, 15);
	
	BoardVO write(BoardVO board);
	
	BoardVO modify(BoardVO board);
	
	boolean delete(BoardVO board);
	
}
