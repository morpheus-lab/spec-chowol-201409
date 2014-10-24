package com.bitschool.mentorschool.vo;

import java.io.Serializable;
import java.sql.Date;

public class MemberVO implements Serializable {
	
	private Long memberId;
	private String name;
	private String gender;
	private String email;
	private String id;
	private String pw;
	private String telAreaCode;
	private String tel1;
	private String tel2;
	private String cellAreaCode;
	private String cell1;
	private String cell2;
	private Date regDate;
	private Integer level;
	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTelAreaCode() {
		return telAreaCode;
	}
	public void setTelAreaCode(String telAreaCode) {
		this.telAreaCode = telAreaCode;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getCellAreaCode() {
		return cellAreaCode;
	}
	public void setCellAreaCode(String cellAreaCode) {
		this.cellAreaCode = cellAreaCode;
	}
	public String getCell1() {
		return cell1;
	}
	public void setCell1(String cell1) {
		this.cell1 = cell1;
	}
	public String getCell2() {
		return cell2;
	}
	public void setCell2(String cell2) {
		this.cell2 = cell2;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public String toString() {
		return "memberId: " + memberId +
				", name: " + name +
				", id: " + id +
				", email: " + email;
	}
	
	public boolean equals(Object m) {
		if (m == null) {
			return false;
		}
		if (!(m instanceof MemberVO)) {
			return false;
		}
		if (memberId != ((MemberVO) m).getMemberId()) {
			return false;
		}
		return true;
	}
	
}
