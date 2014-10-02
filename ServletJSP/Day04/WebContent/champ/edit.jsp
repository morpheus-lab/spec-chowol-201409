<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.ConnectionContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int no = Integer.parseInt( request.getParameter("no") );

String sql = "SELECT * FROM champ WHERE no = ?";
Connection conn = ConnectionContext.getConnection();
PreparedStatement pstmt = conn.prepareStatement(sql);
// pstmt에 파라미터 세팅
pstmt.setInt(1, no);

ResultSet rs = pstmt.executeQuery();

String name = null;
String type = null;
int health = 0;
int damage = 0;

if (rs.next()) {
	name = rs.getString("name");
	type = rs.getString("type");
	health = rs.getInt("health");
	damage = rs.getInt("damage");
}

rs.close();
pstmt.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>챔피언 정보 수정</title>
</head>
<body>

<form action="editx.jsp" method="post">

<input type="hidden" name="no" value="<%= no %>" />

<table>
	<tr>
		<td>챔프명</td>
		<td><input type="text" name="name" value="<%= name %>" /></td>
		<td>타입</td>
		<td><input type="text" name="type" value="<%= type %>" /></td>
	</tr>
	<tr>
		<td>체력</td>
		<td><input type="text" name="health" value="<%= health %>" /></td>
		<td>공격력</td>
		<td><input type="text" name="damage" value="<%= damage %>" /></td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" value="수정" />
		</td>
	</tr>
</table>

</form>

</body>
</html>