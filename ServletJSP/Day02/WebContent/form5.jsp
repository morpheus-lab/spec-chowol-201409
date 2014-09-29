<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전송 방식에 따른 처리</title>
</head>
<body>
<h3><%= request.getContentType() %></h3>
<%
InputStream in = request.getInputStream();
int data = -1;
while ((data = in.read()) != -1) {
	out.print((char) data);
}
%>
</body>
</html>