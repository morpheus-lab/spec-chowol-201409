<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="div_error.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나눗셈 연산 처리 페이지</title>
</head>
<body>
<%--
try {
%>
	<%= num1 %> / <%= num2 %> = <%= ((double) num1 / (double) num2) %><br/><br/>
<%
} catch (Exception e) {
	e.printStackTrace();
%>
	나누기 연산 처리 중 에러 발생!!! - 여기는 CATCH
<%
}
--%>
<%
Integer num1 = null;
Integer num2 = null;
Double result = null;
try {
	num1 = Integer.parseInt(request.getParameter("num1"));
	num2 = Integer.parseInt(request.getParameter("num2"));
	result = (double) num1 / (double) num2;
} catch (Exception e) {
	out.println("오류발생!!! - 여기는 CATCH 구문");
}
%>
<%= num1 %> / <%= num2 %> = <%= result %><br/><br/>

<a href="div.html">돌아가기</a>

</body>
</html>