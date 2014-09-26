<%@ page contentType="text/html;charset=utf-8"%>
<html>
<head>
<title>전체 이름 사용</title>
</head>
<body>
	<%
		java.util.Calendar cal = java.util.Calendar.getInstance();
	%>
	오늘의 날짜:
	<%=cal.get(java.util.Calendar.YEAR)%>
	년
	<%=cal.get(java.util.Calendar.MONTH) + 1%>
	월
	<%=cal.get(java.util.Calendar.DATE)%>
	일
</body>
</html>