package com.spec.first.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BoardFileDao {
	
	private Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(BoardFile boardFile) throws Exception {
		String sql = "INSERT INTO boardfile VALUES(seq_boardfile_fno.NEXTVAL,?,?,?,?)";
		// prepare statement
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setLong(1, 1L);	// TODO - bno 값 넣어줘야 함
		pstmt.setString(2, boardFile.getOriginalName());
		pstmt.setString(3, boardFile.getSavedName());
		pstmt.setString(4, boardFile.getContentType());
		// 실행
		pstmt.executeUpdate();
		// 정리
		pstmt.close();
	}
	
}
