package com.spec.first.board;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.spec.first.model.Board;
import com.spec.first.model.BoardDao;
import com.spec.first.model.BoardFile;
import com.spec.first.model.BoardFileDao;
import com.spec.first.model.ConnectionPool;

public class UpdateAction extends DispatchAction {
	
	public ActionForward updateForm(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) {
		// 게시물 번호 bno
		long bno = Long.parseLong(request.getParameter("bno"));
		
		// DB로부터 게시물 정보 가져오기
		Connection connection = null;
		try {
			connection = ConnectionPool.getConnection();
			// DAO 객체 만들기
			BoardDao boardDao = new BoardDao();
			boardDao.setConnection(connection);
			BoardFileDao boardFileDao = new BoardFileDao();
			boardFileDao.setConnection(connection);
			// 게시판 정보 조회
			Board board = boardDao.select(bno);
			// 첨부 파일 정보 조회
			List<BoardFile> boardFiles = boardFileDao.select(bno);
			board.setBoardFiles(boardFiles);
			
			// request scope에 저장, view에서 이용할 수 있도록
			request.setAttribute("board", board);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {}
		}
		
		return mapping.findForward("updateform");
	}
	
	public ActionForward update(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		BoardForm boardForm = (BoardForm) form;
		
		// DB 작업
		Connection connection = null;
		try {
			connection = ConnectionPool.getConnection();
			// DAO 객체 생성
			BoardDao boardDao = new BoardDao();
			boardDao.setConnection(connection);
			
			// 수정 전 board DTO
			Board board = boardDao.select(Long.parseLong(boardForm.getBno()));
			
			// board DTO에 수정된 값 세팅
			board.setSubject(boardForm.getSubject());
			board.setContent(boardForm.getContent());
			board.setWriter(boardForm.getWriter());
			
			// DB update
			boardDao.update(board);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {}
		}
		
		ActionForward af = new ActionForward();
		af.setPath("view.do?bno=" + boardForm.getBno());
		af.setRedirect(true);
		
		return af;
	}
	
}
