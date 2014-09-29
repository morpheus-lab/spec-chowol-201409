<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");	// 영어 이외 언어 처리를 위함
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>회원 가입 처리 페이지</title>
</head>
<body>

<h3>회원 가입 양식에 입력한 값</h3>
<br/><br/>
ID: <%= request.getParameter("id") %><br/>
PW: <%= request.getParameter("pw") %><br/>
자기소개: <%= request.getParameter("desc") %>

</body>
</html>