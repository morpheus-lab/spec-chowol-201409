<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="bean.User" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Bean 사용 (데이터 꺼내기)</title>
</head>
<body>

사용자정보<br/>
아이디: <%= user.getId() %><br/>
이름: <%= user.getName() %><br/>
비밀번호: <%= user.getPw() %><br/>
이메일: <%= user.getEmail() %><br/>
등록일: <%= user.getRegDate() %><br/>

</body>
</html>