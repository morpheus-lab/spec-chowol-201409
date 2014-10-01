<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--@ page buffer="none" --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>&lt;jsp:forward&gt; 액션태그</title>
</head>
<body>

&lt; : less than (부등호 작다, 꺽쇠 왼 괄호)<br/>
&gt; : greater than (부등호 크다, 꺽쇠 오른 괄호)<br/>
&amp; : ampersand (and 기호)<br/>
&quot; : 따옴표<br/><br/>

여기는 from.jsp<br/>

<jsp:forward page="to.jsp" />

</body>
</html>