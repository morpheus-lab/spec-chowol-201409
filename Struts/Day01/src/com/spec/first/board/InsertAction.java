package com.spec.first.board;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.spec.first.util.StringUtils;

public class InsertAction extends DispatchAction {
	
	public ActionForward insertForm(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("insertForm 호출됨");
		return null;
	}
	
	public ActionForward insert(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		// 클라이언트가 보낸 데이터
		BoardForm boardForm = (BoardForm) form;
		
		// 모델 영역으로 보낼 DTO 준비
		Board board = new Board();
		board.setSubject(
				StringUtils.convertCharset(
						boardForm.getSubject(), null, null));
		board.setContent(
				StringUtils.convertCharset(
						boardForm.getContent(), null, null));
		board.setWriter(
				StringUtils.convertCharset(
						boardForm.getWriter(), null, null));
		// 클라이언트가 보낸 파일 처리
		List<BoardFile> boardFiles = new ArrayList<BoardFile>();
		for (int i = 0; i < boardForm.getBoardFiles().size(); i++) {
			FormFile formFile = boardForm.getBoardFiles().get(i);
			if (formFile != null && formFile.getFileSize() > 0) {
				BoardFile boardFile = new BoardFile();
				boardFile.setOriginalName(formFile.getFileName());
				boardFile.setContentType(formFile.getContentType());
				boardFile.setSavedName(saveFile(formFile));
				
				boardFiles.add(boardFile);
			}
		}
		
		board.setBoardFiles(boardFiles);
		
		// view 이동
		
		return null;
	}
	
	public String saveFile(FormFile formFile) {
		// 파일시스템에 파일을 저장
		
		// 저장된 파일의 이름을 리턴
		return null;
	}
	
}
