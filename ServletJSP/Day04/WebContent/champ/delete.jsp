<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.ConnectionContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int no = Integer.parseInt(request.getParameter("no"));

//DB 작업
String sql = "DELETE FROM champ WHERE no = ?";
Connection conn = ConnectionContext.getConnection();

PreparedStatement pstmt = conn.prepareStatement(sql);

pstmt.setInt(1, no);

int count = pstmt.executeUpdate();

pstmt.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>챔피언 정보 삭제</title>
</head>
<body>

<%= count %>개의 레코드가 삭제되었습니다.<br/><br/>

<a href="list.jsp">리스트</a>

</body>
</html>