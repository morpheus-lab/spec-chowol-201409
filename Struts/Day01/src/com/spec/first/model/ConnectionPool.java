package com.spec.first.model;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnectionPool {
	
	private static DataSource dataSource;
	
	// private 생성자 - 인스턴스 생성 막음
	private ConnectionPool() {}
	
	public static DataSource getDataSource() {
		if (dataSource == null) {
			// DBCP 객체 생성
			BasicDataSource bds = new BasicDataSource();
			// JDBC 설정
			bds.setDriverClassName("oracle.jdbc.OracleDriver");
			bds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			bds.setUsername("scott");
			bds.setPassword("tiger");
			bds.setMaxActive(3);
			bds.setInitialSize(1);
			bds.setMaxIdle(1);
			dataSource = bds;
		}
		return dataSource;
	}
	
	public static Connection getConnection() throws Exception {
		return getDataSource().getConnection();
	}
	
}
