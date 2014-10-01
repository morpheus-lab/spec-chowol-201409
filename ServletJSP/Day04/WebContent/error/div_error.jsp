<%@page import="java.io.StringWriter"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%
// HTTP 응답 코드를 강제로 변경
response.setStatus(HttpServletResponse.SC_OK);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>오류 발생!!!</title>
</head>
<body>

나누기 연산 처리 중 오류가 발생하였습니다.<br/><br/>

<a href="div.html">입력폼으로</a>

<br/><br/>

<%= exception.toString() %><br/>
<%= exception.getMessage() %>

<!--
<%
StringWriter sw = new StringWriter();

PrintWriter writer = new PrintWriter(sw);
exception.printStackTrace(writer);

out.print(sw.toString());

sw.close();
writer.close();
%>
-->

</body>
</html>