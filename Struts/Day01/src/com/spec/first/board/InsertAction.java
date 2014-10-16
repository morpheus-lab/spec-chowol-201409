package com.spec.first.board;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
		return mapping.findForward("insertform");	// => /insertform.jsp로 포워딩
	}
	
	public ActionForward insert(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
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
				// BoardFile DTO 생성
				BoardFile boardFile = new BoardFile();
				boardFile.setOriginalName(formFile.getFileName());
				boardFile.setContentType(formFile.getContentType());
				boardFile.setSavedName(saveFile(formFile));
				
				boardFiles.add(boardFile);
			}
		}
		
		board.setBoardFiles(boardFiles);
		
		// view 이동
		
		return mapping.findForward("list");	// 글로벌 포워드 "list" => /list.do로 redirect
	}
	
	public String saveFile(FormFile formFile) throws IOException {
		// 파일시스템에 파일을 저장
		
		// 파일 저장 경로
		String saveDir = "C:/TEMP/";
		// 파일명에서 확장자 분리
		String fileName = formFile.getFileName();
		int lastDotIdx = fileName.lastIndexOf(".");
		String extName = fileName.substring(lastDotIdx + 1);
		
		// 저장할 파일의 이름을 생성
		String saveFileName = Long.toString(System.currentTimeMillis());
		
		// 파일 저장
		File saveFile = new File(saveDir, saveFileName + "." + extName);
		
		int fileNo = 1;
		
		while (saveFile.exists()) {
			// 저장하려는 파일명이 이미 존재한다면, 파일명을 변경
			saveFile = new File(saveDir,
					saveFileName + "-" + (fileNo++) + "." + extName);
		}
		
		FileOutputStream fos = new FileOutputStream(saveFile);
		InputStream in = formFile.getInputStream();
		
		byte[] data = new byte[1024];
		int len = -1;
		while ((len = in.read(data)) > -1) {
			fos.write(data, 0, len);
		}
		
		fos.close();
		in.close();
		
		System.out.println("오리지널 파일명: " + formFile.getFileName());
		System.out.println("저장된 파일명  : " + saveFile.getName());
		// 저장된 파일의 이름을 리턴
		return saveFile.getName();
	}
	
}

























