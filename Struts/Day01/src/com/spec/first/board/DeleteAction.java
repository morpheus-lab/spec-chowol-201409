package com.spec.first.board;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.spec.first.model.BoardDao;
import com.spec.first.model.BoardFileDao;
import com.spec.first.model.ConnectionPool;

public class DeleteAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		// 삭제할 게시물 bno
		long bno = Long.parseLong(request.getParameter("bno"));
		
		Connection connection = null;
		try {
			// ConnectionPool로부터 Connection 얻기
			connection = ConnectionPool.getConnection();
			connection.setAutoCommit(false);
			
			// DAO 객체 생성 및 Connection 설정
			BoardDao boardDao = new BoardDao();
			boardDao.setConnection(connection);
			BoardFileDao boardFileDao = new BoardFileDao();
			boardFileDao.setConnection(connection);
			
			// 게시물 삭제
			boardDao.delete(bno);
			
			// 첨부파일 삭제
			boardFileDao.deleteByBno(bno);
			
			// 커밋
			connection.commit();
		} catch (Exception e) {
			connection.rollback();
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (Exception e) {}
			try {
				connection.close();
			} catch (Exception e) {}
		}
		
		return mapping.findForward("list");
	}
	
}
