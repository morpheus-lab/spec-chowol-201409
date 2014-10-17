package com.spec.first.board;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.spec.first.model.Board;
import com.spec.first.model.BoardDao;
import com.spec.first.model.ConnectionPool;

public class ListAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Board> boardList = null;
		
		Connection connection = null;
		try {
			// DB에서 게시물 조회 boardList에 담기
			// 커넥션 얻어오기
			connection = ConnectionPool.getConnection();
			// DAO 객체 생성
			BoardDao boardDao = new BoardDao();
			boardDao.setConnection(connection);
			
			boardList = boardDao.getBoardList();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {}
			}
		}
		
		request.setAttribute("boardList", boardList);
		
		return mapping.findForward("listjsp");
	}
	
}
