<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Bean 값 세팅</title>
</head>
<body>

<jsp:useBean id="user" class="bean.User" scope="request" />

<%
user.setId("admin");
user.setName("시비르");
user.setPw("1111");
user.setEmail("admin@localhost");
user.setRegDate(new Date());
%>

<jsp:forward page="useBean.jsp" />

</body>
</html>