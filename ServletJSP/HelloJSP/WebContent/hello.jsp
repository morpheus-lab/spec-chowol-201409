<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<%

String message = "HELLO~!! JSP~!!!";

out.println(message);

for (int i = 0; i < 10; i++) {
	out.println("Hello World!<br/>");
}

// 주석

%>

<%!
String m = "hello";	// 이 jsp파일을 담당하는 클래스의 멤버 변수가 됨

// 메소드 정의
public void foo() {
	System.out.println("foo 메소드 호출");
}
%>

<!-- HTML 주석 (XML 주석) -->
<%-- JSP 주석 --%>

</body>
</html>