package com.spec.first.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDao {
	
	private Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public long insert(Board board) throws Exception {
		long bno = -1L;
		
		String sql = "SELECT seq_board_bno.NEXTVAL FROM DUAL";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			bno = rs.getLong(1);
			board.setBno(bno);
		}
		rs.close();
		pstmt.close();
		
		sql = "INSERT INTO board VALUES(?,?,?,?,SYSDATE,0)";
		// prepare statement
		pstmt = connection.prepareStatement(sql);
		pstmt.setLong(1, board.getBno());
		pstmt.setString(2, board.getSubject());
		pstmt.setString(3, board.getContent());
		pstmt.setString(4, board.getWriter());
		// execute
		pstmt.executeUpdate();// SELECT 이외의 DML
		
		pstmt.close();
		
		return bno;
	}
	
}
