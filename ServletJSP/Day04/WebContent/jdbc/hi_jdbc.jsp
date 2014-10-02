<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.ConnectionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JDBC</title>
</head>
<body>
<%
String deptno = request.getParameter("deptno");
String query = request.getParameter("query");

// EMP, DEPT 테이블로부터 사원번호, 사원이름, 부서이름, 부서위치를 조회
String sql = "SELECT e.empno, e.ename, d.dname, d.loc FROM emp e, dept d "
			+"WHERE e.deptno = d.deptno AND d.deptno = ? AND e.ename LIKE '%' || ? || '%'";
// Connection 객체 얻기
Connection conn = ConnectionContext.getConnection();
// PreparedStatement 또는 Statement 객체 생성
//Statement stmt = conn.createStatement();
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, Integer.parseInt(deptno));
pstmt.setString(2, query);
// P...Statement 또는 Statement로 쿼리 실행
//ResultSet rs = stmt.executeQuery(sql);
ResultSet rs = pstmt.executeQuery();
// ResultSet 타입의 결과 받아서 처리
%>
<table border="1">
	<tr>
		<th>사원번호</th>
		<th>사원이름</th>
		<th>부서이름</th>
		<th>부서위치</th>
	</tr>
<%
while (rs.next()) {
	// 하나의 데이터(로우; row)에 대한 처리
	int empno		= rs.getInt("empno");		//rs.getInt(1);
	String ename	= rs.getString("ename");	// rs.getString(2);
	String dname	= rs.getString("dname");	// rs.getString(3);
	String loc		= rs.getString("loc");		// rs.getString(4);
%>
	<tr>
		<td><%= empno %></td>
		<td><%= ename %></td>
		<td><%= dname %></td>
		<td><%= loc %></td>
	</tr>
<%
}

// 사용한 자원의 정리
rs.close();
//stmt.close();
pstmt.close();
%>
</table>

</body>
</html>