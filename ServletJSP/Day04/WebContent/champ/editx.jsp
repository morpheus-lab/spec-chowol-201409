<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.ConnectionContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

// 요청 파라미터 (수정할 데이터)
int no = Integer.parseInt( request.getParameter("no") );
String name = request.getParameter("name");
String type = request.getParameter("type");
int health = Integer.parseInt( request.getParameter("health") );
int damage = Integer.parseInt( request.getParameter("damage") );

// DB 작업
String sql = "UPDATE champ "
			+"SET name = ?, type = ?, health = ?, damage = ? "
			+"WHERE no = ?";
Connection conn = ConnectionContext.getConnection();

PreparedStatement pstmt = conn.prepareStatement(sql);

pstmt.setString(1, name);
pstmt.setString(2, type);
pstmt.setInt(3, health);
pstmt.setInt(4, damage);
pstmt.setInt(5, no);

int count = pstmt.executeUpdate();

pstmt.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>챔피언 정보 DB 갱신</title>
</head>
<body>

<%= count %>개의 레코드가 변경되었습니다.<br/><br/>

<a href="list.jsp">리스트</a>

</body>
</html>