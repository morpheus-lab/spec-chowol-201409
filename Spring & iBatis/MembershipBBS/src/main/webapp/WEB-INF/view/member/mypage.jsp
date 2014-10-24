<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
</head>
<body>
<%

%>
	<table>
		<tr>
			<td>이름</td>
			<td>${member.name}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${member.email}</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${member.gender}</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${member.id}</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${member.telAreaCode}-${member.tel1}-${member.tel2}</td>
		</tr>
		<tr>
			<td>휴대전화</td>
			<td>${member.cellAreaCode}-${member.cell1}-${member.cell2}</td>
		</tr>
		<tr>
			<td>가입일</td>
			<td>${member.regDate}</td>
		</tr>
	</table>
	
</body>
</html>