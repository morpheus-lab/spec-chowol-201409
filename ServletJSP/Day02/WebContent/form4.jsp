<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SELECT 태그 처리</title>
</head>
<body>
<%

String noodle = request.getParameter("noodle");
String bread = request.getParameter("bread");
String[] games = request.getParameterValues("game");

%>
선택한 항목은<br/>
면류: <%= noodle %><br/>
빵류: <%= bread %><br/>
게임:
<%
if (games != null) {
	
	for (int i = 0; i < games.length; i++) {
		out.print(games[i]);
		if (i != games.length - 1) {
			out.print(", ");
		}
	}
	
}
%>


</body>
</html>