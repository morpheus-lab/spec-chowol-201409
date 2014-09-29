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
String[] items = request.getParameterValues("chk");
if (items != null) {
	for (int i = 0; i < items.length; i++) {
		out.print(items[i]);
		if (i != items.length - 1) {
			out.print(", ");
		}
	}
}
%>
이고,<br/>
선택한 요금제는 <%= request.getParameter("rate") %>입니다.


</body>
</html>