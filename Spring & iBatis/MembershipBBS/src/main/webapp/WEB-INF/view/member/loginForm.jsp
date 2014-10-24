<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>

<%
String savedId = null;
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie c : cookies) {
		if (c.getName().equals("loginID")) {
			savedId = c.getValue();
			break;
		}
	}
}
%>

<h3>로그인</h3>

<font color="red">${loginMessage}</font><br/>

<form name="loginForm" action="login" method="post">

	<table>
		<tr>
			<td>ID: </td>
			<td><input type="text" name="id" value="<%= savedId != null ? savedId : "" %>" /></td>
		</tr>
		<tr>
			<td>PW: </td>
			<td><input type="password" name="pw"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="checkbox" name="saveId" <%= savedId != null ? "checked=\"checked\"" : "" %> /> 아이디 저장
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그인"/>
			</td>
		</tr>
	</table>

</form>

</body>
</html>