package com.spec.first;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.spec.first.board.Board;
import com.spec.first.board.BoardFile;

public class TestAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Board board = new Board();
		board.setBno(5);
		board.setSubject("첫번째 게시물");
		board.setContent("첫번째 게시물 내용");
		board.setWriter("홍길동");
		board.setWritedate(new java.sql.Date(new java.util.Date().getTime()));
		board.setHitcount(5);
		
		BoardFile boardFile = new BoardFile();
		boardFile.setFno(10);
		boardFile.setBno(5);
		boardFile.setOriginalName("originalname.gif");
		boardFile.setSavedName("savedname.gif");
		boardFile.setContentType("image/gif");
		
		board.getBoardFiles().add(boardFile);
		
		request.setAttribute("board", board);
		
		return mapping.findForward("view");
	}
	
}




















