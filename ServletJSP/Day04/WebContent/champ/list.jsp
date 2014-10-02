<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.ConnectionContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String sql = "SELECT * FROM champ ORDER BY no DESC";
Connection conn = ConnectionContext.getConnection();
PreparedStatement pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>챔피언 목록 조회</title>
</head>
<body>

<table border="1">
	<tr>
		<th>이름</th>
		<th>타입</th>
		<th>체력</th>
		<th>공격력</th>
		<th>등록일</th>
		<th>관리</th>
	</tr>
<%
while (rs.next()) {
%>
	<tr>
		<td><%= rs.getString("name") %></td>
		<td><%= rs.getString("type") %></td>
		<td><%= rs.getInt("health") %></td>
		<td><%= rs.getInt("damage") %></td>
		<td><%= rs.getDate("regdate") %></td>
		<td>
			<a href="edit.jsp?no=<%= rs.getInt("no") %>">수정</a>
			/
			<a href="delete.jsp?no=<%= rs.getInt("no") %>">삭제</a>
		</td>
	</tr>
<%
}

rs.close();
pstmt.close();
%>
</table>

<br/>
<a href="add.jsp">신규 등록</a>

</body>
</html>