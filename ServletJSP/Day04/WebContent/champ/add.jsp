<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>챔피언 등록</title>
</head>
<body>

<form action="addx.jsp" method="post">

<table>
	<tr>
		<td>챔프명</td>
		<td><input type="text" name="name" /></td>
		<td>타입</td>
		<td><input type="text" name="type" /></td>
	</tr>
	<tr>
		<td>체력</td>
		<td><input type="text" name="health" /></td>
		<td>공격력</td>
		<td><input type="text" name="damage" /></td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" value="챔프등록" />
		</td>
	</tr>
</table>

</form>

</body>
</html>