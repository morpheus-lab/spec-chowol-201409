package com.bitschool.mentorschool.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.bitschool.mentorschool.vo.BoardVO;

public interface BoardService {
	
	Map<String, Object> getBoardList(Integer page, Integer pageSize) throws Exception;	// getBoardList(1, 15);
	
	BoardVO read(BigInteger bno) throws Exception;
	
	int write(BoardVO board) throws Exception;
	
	int modify(BoardVO board) throws Exception;
	
	int delete(BoardVO board) throws Exception;
	
}
