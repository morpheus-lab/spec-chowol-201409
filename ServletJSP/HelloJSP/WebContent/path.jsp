<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>웹 애플리케이션의 실제 경로</title>
</head>
<body>

현재 웹 애플리케이션의 context 경로: <br/>
<%= application.getContextPath() %><br/>
<%= request.getContextPath() %><br/>


<br/>
현재 jsp 페이지의 실제 경로: <%= application.getRealPath("/path.jsp") %>


</body>
</html>