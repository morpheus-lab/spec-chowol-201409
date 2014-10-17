package com.spec.first.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Board implements Serializable {

	private long bno;
	private String subject;
	private String content;
	private String writer;
	private Date writedate;
	private int hitcount;
	private List<BoardFile> boardFiles = new ArrayList<BoardFile>();

	public long getBno() {
		return bno;
	}

	public void setBno(long bno) {
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

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public int getHitcount() {
		return hitcount;
	}

	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}

	public List<BoardFile> getBoardFiles() {
		return boardFiles;
	}

	public void setBoardFiles(List<BoardFile> boardFiles) {
		this.boardFiles = boardFiles;
	}

}
