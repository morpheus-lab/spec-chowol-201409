<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

application 객체에 저장된 Attribute 조회<br/><br/>

<!--
appName: <%= application.getAttribute("appName") %><br/>

appVersion: <%= application.getAttribute("appVersion") %>
-->

<%
	Enumeration<String> attrNames = application.getAttributeNames();

	while (attrNames.hasMoreElements()) {
		
		String name = attrNames.nextElement();
		Object value = application.getAttribute(name);
		
		out.println(name + ": " + value);
	}

%>

</body>
</html>


























