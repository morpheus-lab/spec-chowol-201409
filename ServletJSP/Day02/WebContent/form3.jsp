<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>체크박스, 라디오 버튼 처리 페이지</title>
</head>
<body>

당신의 관심제품은<br/>
<%
Enumeration<String> paramNames = request.getParameterNames();
// 예: paramNames = { "chk1", "chk2", "rate", "id", "pw" }

while (paramNames.hasMoreElements()) {
	
	String paramName = paramNames.nextElement();
	
	if (paramName.startsWith("chk")) {	// "chk1", "chk2"
		
		out.print(request.getParameter(paramName) + ", ");
		
	}
	
}
%>
이고,<br/>
선택한 요금제는 <%= request.getParameter("rate") %>입니다.


</body>
</html>