package com.spec.first.board;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.spec.first.model.BoardFile;
import com.spec.first.model.BoardFileDao;
import com.spec.first.model.ConnectionPool;

public class DownloadAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// fno 요청 파라미터 얻기
		long fno = Long.parseLong(request.getParameter("fno"));
		
		// boardfile 테이블에서 파일 정보 조회
		BoardFile boardFile = null;
		Connection connection = null;
		
		try {
			connection = ConnectionPool.getConnection();
			// DAO 객체 생성 및 Connection 설정
			BoardFileDao boardFileDao = new BoardFileDao();
			boardFileDao.setConnection(connection);
			
			boardFile = boardFileDao.selectOne(fno);
		} catch (Exception e) {
		} finally {
			try {
				connection.close();
			} catch (Exception e) {}
		}
		
		// boardFile이 null이라면?
		if (boardFile == null) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		// null이 아니라면 다운로드되도록..
		else {
			String originalName = boardFile.getOriginalName();
			originalName = new String(originalName.getBytes("UTF-8"), "ISO-8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=" + originalName);
			response.setContentType(boardFile.getContentType());
			
			String saveDir = "C:/TEMP/";
			// 읽어들일 파일
			File file = new File(saveDir, boardFile.getSavedName());
			FileInputStream in = new FileInputStream(file);
			
			// 내보낼 stream
			ServletOutputStream out = response.getOutputStream();
			
			// 버퍼 준비
			byte[] buf = new byte[4096];
			int len = -1;
			
			// in으로부터 데이터 읽고, out으로 데이터 쓰기
			while ((len = in.read(buf)) > -1) {
				out.write(buf, 0, len);
			}
			out.flush();
			
			// in/out 스트림 닫기
			in.close();
			out.close();
		}
		
		return null;
	}
	
}
