package com.bitschool.mentorschool.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

public class BoardVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private BigInteger bno;
	private String subject;
	private String content;
	private String writer;
	private Date writedate;
	private BigInteger hitcount;
	private BigInteger p_bno;
	private Integer level;
	
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
}
