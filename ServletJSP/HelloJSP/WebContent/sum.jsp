<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1 ~ 100 합계</title>
</head>
<body>

<%
int sum = 0;
for (int i = 1; i < 101; i++) {
	sum += i;
}
%>

1+2+3+...+98+99+100 = <% out.print(sum); %>

<!--
<h1>Head Level 1</h1>
<h2>Head Level 2</h2>
<h3>Head Level 3</h3>
-->
<br/><br/>
여기는 선언부 이전 - <%= head %>

<br/><br/>

<%!
// 선언부

String head = "Factorial 예제";

public int factorial(int n) throws Exception {
	int fac = 1;

	if (n > 0) {
		for (int i = 1; i < n + 1; i++) {
			fac *= i;
		}
	} else if (n == 0) {
		fac = 1;
	} else {
		throw new Exception("Factorial 연산은 양의 정수만 가능");
	}
	return fac;
}

%>

<h3><%= head %></h3>

여기는 스크립틀릿 이전 (n 선언되기 전) - <%-- <%= n %> --%>
<br/><br/>
<%
int n = 5;

int fac = 1;

if (n > 0) {
	for (int i = 1; i < n + 1; i++) {
		fac *= i;
	}
} else if (n == 0) {
	fac = 1;
} else {
	// 처리불가
}
%>

<%= 4 %>! = <%= factorial(4) %>


</body>
</html>