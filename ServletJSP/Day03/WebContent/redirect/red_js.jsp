<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

Random random = new Random();
int rInt = random.nextInt();
String number = Integer.toString(rInt);

String forwardURI = request.getContextPath() + "/redirect/recv.jsp?num=" + number;

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaScript를 이용한 Forwarding</title>
<script type="text/javascript">
	location.href = "<%= forwardURI %>";
</script>
</head>
<body>

</body>
</html>