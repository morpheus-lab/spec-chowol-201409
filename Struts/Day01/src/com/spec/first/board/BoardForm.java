package com.spec.first.board;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class BoardForm extends ActionForm {

	private String bno; // 게시물 번호
	private String subject; // 게시물 제목
	private String content; // 게시물 내용
	private String writer; // 게시물 작성자
	private String writedate; // 게시물 작성일
	private String hitcount; // 게시물 조회수
	private FormFile[] boardFiles = new FormFile[2]; // 첨부파일

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

	public FormFile[] getBoardFiles() {
		return boardFiles;
	}

	public void setBoardFiles(FormFile[] boardFiles) {
		this.boardFiles = boardFiles;
	}

}
