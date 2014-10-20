package com.spec.first.board;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

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
			connection.setAutoCommit(false);
			// DAO 객체 생성
			BoardDao boardDao = new BoardDao();
			boardDao.setConnection(connection);
			BoardFileDao boardFileDao = new BoardFileDao();
			boardFileDao.setConnection(connection);
			
			// 수정 전 board DTO
			Board board = boardDao.select(Long.parseLong(boardForm.getBno()));
			
			// board DTO에 수정된 값 세팅
			board.setSubject(boardForm.getSubject());
			board.setContent(boardForm.getContent());
			board.setWriter(boardForm.getWriter());
			
			// DB update
			boardDao.update(board);
			
			// boardfile 테이블 작업

			// fno를 기준으로 기존 파일 외 다른 파일은 모두 삭제
			// => 사용자가 브라우저에서 삭제한 모든 파일을 DB로부터 삭제
			// DELETE FROM boardfile WHERE fno NOT IN (24, 0);
			String[] boardFilesFnos = boardForm.getBoardFilesFno();
			boardFileDao.deleteFileNotInFnos(board.getBno(), boardFilesFnos);
			
			// 새롭게 등록한 파일 DB에 등록
			List<FormFile> boardFiles = boardForm.getBoardFiles();
			for (FormFile file : boardFiles) {
				if (!file.getFileName().trim().equals("")) {
					// 파일 시스템에 저장하고 저장된 이름 리턴받음
					String savedName = InsertAction.saveFile(file);
					// BoardFile DTO 만들고
					BoardFile boardFile = new BoardFile();
					boardFile.setBno(board.getBno());
					boardFile.setOriginalName(file.getFileName());
					boardFile.setSavedName(savedName);
					boardFile.setContentType(file.getContentType());
					// DB에 저장
					boardFileDao.insert(boardFile);
				}
			}
			
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (Exception e) {}
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
