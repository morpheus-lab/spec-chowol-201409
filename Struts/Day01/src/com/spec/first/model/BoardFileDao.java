package com.spec.first.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardFileDao {
	
	private Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(BoardFile boardFile) throws Exception {
		String sql = "INSERT INTO boardfile VALUES(seq_boardfile_fno.NEXTVAL,?,?,?,?)";
		// prepare statement
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setLong(1, boardFile.getBno());
		pstmt.setString(2, boardFile.getOriginalName());
		pstmt.setString(3, boardFile.getSavedName());
		pstmt.setString(4, boardFile.getContentType());
		// 실행
		pstmt.executeUpdate();
		// 정리
		pstmt.close();
	}
	
	public List<BoardFile> select(long bno) throws SQLException {
		String sql = "SELECT * FROM boardfile WHERE bno=? ORDER BY fno";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setLong(1, bno);
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardFile> boardfileList = new ArrayList<BoardFile>();
		while (rs.next()) {
			BoardFile boardFile = new BoardFile();
			// 값 세팅
			boardFile.setFno(rs.getLong("fno"));
			boardFile.setBno(rs.getLong("bno"));
			boardFile.setOriginalName(rs.getString("originalname"));
			boardFile.setSavedName(rs.getString("savedname"));
			boardFile.setContentType(rs.getString("contenttype"));
			
			boardfileList.add(boardFile);
		}
		
		rs.close();
		pstmt.close();
		
		return boardfileList;
	}
	
	public BoardFile selectOne(long fno) throws SQLException {
		BoardFile boardFile = null;
		
		String sql = "SELECT * FROM boardfile WHERE fno=?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setLong(1, fno);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			boardFile = new BoardFile();
			boardFile.setFno(rs.getLong("fno"));
			boardFile.setBno(rs.getLong("bno"));
			boardFile.setOriginalName(rs.getString("originalname"));
			boardFile.setSavedName(rs.getString("savedname"));
			boardFile.setContentType(rs.getString("contenttype"));
		}
		
		// 자원 반납
		rs.close();
		pstmt.close();
		
		return boardFile;
	}

	public boolean deleteByBno(long bno) throws SQLException {
		boolean result = false;
		String sql = "DELETE FROM boardfile WHERE bno=?";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setLong(1, bno);
		result = pstmt.executeUpdate() > 0;
		
		pstmt.close();
		
		return result;
	}
	
}





















