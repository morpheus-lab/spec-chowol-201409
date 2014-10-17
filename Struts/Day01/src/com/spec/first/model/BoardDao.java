package com.spec.first.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BoardDao {
	
	private Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Board board) throws Exception {
		String sql = "INSERT INTO board VALUES(seq_board_bno.NEXTVAL,?,?,?,SYSDATE,0)";
		// prepare statement
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, board.getSubject());
		pstmt.setString(2, board.getContent());
		pstmt.setString(3, board.getWriter());
		// execute
		pstmt.executeUpdate();// SELECT 이외의 DML
		
		pstmt.close();
	}
	
}
