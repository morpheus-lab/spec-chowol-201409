package com.bitschool.mentorschool.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

public class BoardVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private BigInteger bno;
	private String subject;
	private String content;
	private BigInteger writer;
	private String writerName;
	private Date writedate;
	private BigInteger hitcount;
	private BigInteger p_bno;
	private BigInteger level;
	
	public BigInteger getBno() {
		return bno;
	}
	public void setBno(BigInteger bno) {
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
	public BigInteger getWriter() {
		return writer;
	}
	public void setWriter(BigInteger writer) {
		this.writer = writer;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public BigInteger getHitcount() {
		return hitcount;
	}
	public void setHitcount(BigInteger hitcount) {
		this.hitcount = hitcount;
	}
	public BigInteger getP_bno() {
		return p_bno;
	}
	public void setP_bno(BigInteger p_bno) {
		this.p_bno = p_bno;
	}
	public BigInteger getLevel() {
		return level;
	}
	public void setLevel(BigInteger level) {
		this.level = level;
	}
	
}
