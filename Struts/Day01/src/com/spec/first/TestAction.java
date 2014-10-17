package com.spec.first;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.spec.first.model.Board;
import com.spec.first.model.BoardFile;

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
		
		// ---------------------------------------------
		// <c:forEach> TEST
		
		List bookList = new ArrayList();
		bookList.add("JAVA");
		bookList.add("Servlet/JSP");
		bookList.add("EJB");
		
		request.setAttribute("bookList", bookList);
		
		String cityList = "서울,제주,대전";
		
		request.setAttribute("cityList", cityList);
		
		// -----------------------------------------------
		// <c:forTokens> TEST
		
		String jobList = "프로그래머|디자이너|매니저|공무원|교사";
		
		request.setAttribute("jobList", jobList);
		
		return mapping.findForward("view");
	}
	
}




















