<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.ConnectionContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello, JDBC!</title>
</head>
<body>

<%
String msg = null;
// SQL 쿼리문 준비
//String sql = "SELECT 'Hello, JDBC' FROM DUAL";
String sql = "SELECT ename FROM emp WHERE empno=7788";
// Connection 얻기
Connection conn = ConnectionContext.getConnection();
// PreparedStatement 준비
PreparedStatement pstmt = conn.prepareStatement(sql);
// 쿼리 실행
ResultSet rs = pstmt.executeQuery();
// 결과 데이터 추출
if (rs.next()) {
	msg = rs.getString(1);
}
rs.close();
pstmt.close();
%>

쿼리문: <%= sql %><br/><br/>

쿼리결과: <%= msg %>

</body>
</html>