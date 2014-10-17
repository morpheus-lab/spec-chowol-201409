package com.spec.first.model;

import java.io.Serializable;

public class BoardFile implements Serializable {

	private long fno;
	private long bno;
	private String originalName;
	private String savedName;
	private String contentType;

	public long getFno() {
		return fno;
	}

	public void setFno(long fno) {
		this.fno = fno;
	}

	public long getBno() {
		return bno;
	}

	public void setBno(long bno) {
		this.bno = bno;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getSavedName() {
		return savedName;
	}

	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
