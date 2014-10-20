package com.spec.first.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Board> getBoardList() throws Exception {
		List<Board> boardList = new ArrayList<Board>();
		
		String sql = "SELECT bno, subject, writer, writedate, "
				+ "hitcount "
				+ "FROM board";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			// Board DTO에 쿼리 결과 담기
			Board board = new Board();
			board.setBno(rs.getLong(1));
			board.setSubject(rs.getString(2));
			board.setWriter(rs.getString(3));
			board.setWritedate(rs.getDate(4));
			board.setHitcount(rs.getInt(5));
			// 위 Board DTO 객체를 돌려줄 리스트에 담기
			boardList.add(board);
		}
		// 정리
		rs.close();
		pstmt.close();
		
		return boardList;
	}
	
	public Board select(long bno) throws SQLException {
		String sql = "SELECT * FROM board WHERE bno=?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setLong(1, bno);
		ResultSet rs = pstmt.executeQuery();
		
		Board board = null;
		if (rs.next()) {
			board = new Board();
			board.setBno(rs.getLong("bno"));
			board.setSubject(rs.getString("subject"));
			board.setContent(rs.getString("content"));
			board.setWriter(rs.getString("writer"));
			board.setWritedate(rs.getDate("writedate"));
			board.setHitcount(rs.getInt("hitcount"));
		}
		
		rs.close();
		pstmt.close();
		
		return board;
	}
	
	public boolean increaseHitCount(long bno) throws SQLException {
		String sql = "UPDATE board SET hitcount = hitcount + 1 WHERE bno=?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setLong(1, bno);
		int result = pstmt.executeUpdate();
		pstmt.close();
		
		return (result > 0);
	}
	
}

























