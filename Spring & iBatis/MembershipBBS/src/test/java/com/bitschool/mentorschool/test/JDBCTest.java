package com.bitschool.mentorschool.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCTest extends TestConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(JDBCTest.class);
	
	@Inject
	@Named("dataSource")
	DataSource dataSource;
	
	@Test
	public void testConnection() {
		logger.info(dataSource.toString());
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			logger.info("conn: " + conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
		
	}
	
}
