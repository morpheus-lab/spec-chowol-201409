package com.spec.first.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Board implements Serializable {

	private Long bno;
	private String bnoString;
	private String subject;
	private String content;
	private String writer;
	private Date writedate;
	private Integer hitcount;
	private List<BoardFile> boardFiles = new ArrayList<BoardFile>();

	public Long getBno() {
		return bno;
	}

	public void setBno(Long bno) {
		this.bno = bno;
		this.bnoString = (bno == null ? null : bno.toString());
	}
	
	public String getBnoString() {
		return bnoString;
	}

	public void setBnoString(String bnoString) {
		this.bnoString = bnoString;
		try {
			this.bno = bnoString == null ? null : Long.parseLong(bnoString);
		} catch (NumberFormatException e) {
			setBno(null);
		}
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

	public Integer getHitcount() {
		return hitcount;
	}

	public void setHitcount(Integer hitcount) {
		this.hitcount = hitcount;
	}

	public List<BoardFile> getBoardFiles() {
		return boardFiles;
	}

	public void setBoardFiles(List<BoardFile> boardFiles) {
		this.boardFiles = boardFiles;
	}

}
