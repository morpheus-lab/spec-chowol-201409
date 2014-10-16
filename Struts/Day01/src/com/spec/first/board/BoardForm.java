package com.spec.first.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class BoardForm extends ActionForm {

	private String bno; // 게시물 번호
	private String subject; // 게시물 제목
	private String content; // 게시물 내용
	private String writer; // 게시물 작성자
	private String writedate; // 게시물 작성일
	private String hitcount; // 게시물 조회수
	private List<FormFile> boardFiles; // 첨부파일

	public String getBno() {
		return bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	public String getHitcount() {
		return hitcount;
	}

	public void setHitcount(String hitcount) {
		this.hitcount = hitcount;
	}

	public List<FormFile> getBoardFiles() {
		return boardFiles;
	}

	public void setBoardFiles(List<FormFile> boardFiles) {
		this.boardFiles = boardFiles;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		subject = subject.trim();
		if (subject.equals("")) {
			errors.add("subject", new ActionMessage("제목에 공백만 입력할 수 없음", false));
		}
		
		content = content.trim();
		if (content.equals("")) {
			errors.add("content", new ActionMessage("내용에 공백만 입력할 수 없음", false));
		}
		
		writer = writer.trim();
		if (writer.equals("")) {
			errors.add("writer", new ActionMessage("작성자에 공백만 입력할 수 없음", false));
		}
		
		return errors;
	}

}
