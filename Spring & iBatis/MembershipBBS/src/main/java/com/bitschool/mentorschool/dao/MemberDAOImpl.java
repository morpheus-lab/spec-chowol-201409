package com.bitschool.mentorschool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import oracle.jdbc.proxy.annotation.Pre;

import org.springframework.stereotype.Repository;

import com.bitschool.mentorschool.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private DataSource dataSource;
	
	@Override
	public int create(MemberVO member) throws Exception {
		int result = 0;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			
			// MEMBER_SEQ 시퀀스 값 읽기
			String seqSql = "SELECT member_seq.NEXTVAL FROM DUAL";
			PreparedStatement pstmt = conn.prepareStatement(seqSql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				member.setMemberId(rs.getLong(1));
			}
			rs.close();
			pstmt.close();
			
			// MEMBER 테이블에 회원 정보 삽입
			String sql = "INSERT INTO member(memberid,name,email,gender,id,pw,"
										+ "telareacode,tel1,tel2,cellareacode,cell1,cell2,"
										+ "regdate) "
										+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, member.getMemberId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getId());
			pstmt.setString(6, member.getPw());
			pstmt.setString(7, member.getTelAreaCode());
			pstmt.setString(8, member.getTel1());
			pstmt.setString(9, member.getTel2());
			pstmt.setString(10, member.getCellAreaCode());
			pstmt.setString(11, member.getCell1());
			pstmt.setString(12, member.getCell2());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				conn.close();
			} catch (Exception e) {}
		}
		return result;
	}

	@Override
	public MemberVO read(Long memberId) {
		// TODO Auto-generated method stub
		System.out.println("MemberVO의 read 메서드 호출!!!");
		return null;
	}

	@Override
	public MemberVO read(MemberVO member) {
		return null;
	}
	
	@Override
	public MemberVO readById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO readByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MemberVO member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(MemberVO member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByMemberId(Long memberId) {
		// TODO Auto-generated method stub

	}

}
