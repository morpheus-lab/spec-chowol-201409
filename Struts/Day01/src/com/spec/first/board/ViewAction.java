package com.spec.first.board;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.spec.first.model.Board;
import com.spec.first.model.BoardDao;
import com.spec.first.model.BoardFile;
import com.spec.first.model.BoardFileDao;
import com.spec.first.model.ConnectionPool;

public class ViewAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		long bno = Long.parseLong(request.getParameter("bno"));
		
		Board board = null;
		Connection conn = null;
		
		try {
			conn = ConnectionPool.getConnection();
			// DB에서 bno에 해당하는 게시물 조회 (board 테이블 조회)
			BoardDao boardDao = new BoardDao();
			boardDao.setConnection(conn);
			board = boardDao.select(bno);
			String content = board.getContent().replaceAll("\\n", "<br/>");
			board.setContent(content);
			
			// 게시물 딸린 첨부파일 조회 (boardfile 테이블 조회)
			BoardFileDao boardFileDao = new BoardFileDao();
			boardFileDao.setConnection(conn);
			List<BoardFile> boardFileList = boardFileDao.select(bno);
			board.setBoardFiles(boardFileList);
			
			// 조회수 1 증가
			boardDao.increaseHitCount(bno);
		} catch (Exception e) {
		} finally {
			try {
				conn.close();
			} catch (Exception e) {}
		}
		
		// 위 내용을 View에 전달할 수 있도록 request attribute로 저장
		request.setAttribute("board", board);
		
		// View로 이동
		return mapping.findForward("viewjsp");
	}
	
}
