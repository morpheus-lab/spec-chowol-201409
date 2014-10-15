package com.spec.first.board;

import java.io.Serializable;
import java.util.List;

public class Board implements Serializable {

	private String subject;
	private String content;
	private String writer;
	private List<BoardFile> boardFiles;

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

	public List<BoardFile> getBoardFiles() {
		return boardFiles;
	}

	public void setBoardFiles(List<BoardFile> boardFiles) {
		this.boardFiles = boardFiles;
	}

}
