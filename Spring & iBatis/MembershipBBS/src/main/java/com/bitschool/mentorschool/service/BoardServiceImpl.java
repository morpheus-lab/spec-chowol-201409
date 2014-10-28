package com.bitschool.mentorschool.service;

import java.math.BigInteger;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitschool.mentorschool.dao.BoardDAO;
import com.bitschool.mentorschool.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public Map<String, Object> getBoardList(int page, int pageSize) throws Exception {
		Map<String, Object> result = new Hashtable<String, Object>();
		result.put("boardList", dao.selectList(page, pageSize));
		result.put("totalPages", dao.getTotalPages(pageSize));
		
		return result;
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
