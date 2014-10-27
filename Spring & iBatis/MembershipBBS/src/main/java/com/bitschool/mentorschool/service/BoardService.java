package com.bitschool.mentorschool.service;

import java.math.BigInteger;
import java.util.List;

import com.bitschool.mentorschool.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> getBoardList(int page, int pageSize) throws Exception;	// getBoardList(1, 15);
	
	BoardVO read(BigInteger bno) throws Exception;
	
	int write(BoardVO board) throws Exception;
	
	int modify(BoardVO board) throws Exception;
	
	int delete(BoardVO board) throws Exception;
	
}
