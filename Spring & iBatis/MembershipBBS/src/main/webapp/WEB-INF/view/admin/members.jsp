<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 - 회원 목록</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/style/main.css" />
</head>
<body>

<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>성별</th>
		<th>이메일</th>
		<th>전화</th>
		<th>휴대폰</th>
		<th>레벨</th>
	</tr>
<c:if test="${empty members}">
	<tr>
		<td colspan="7" align="center">조회된 회원이 없습니다.</td>
	</tr>
</c:if>
<c:if test="${not empty members}">
	<c:forEach begin="0" end="${fn:length(members) - 1}" var="i">
		<tr>
			<td>${members[i].memberId}</td>
			<td>${members[i].name}</td>
			<td>${members[i].gender}</td>
			<td>${members[i].email}</td>
			<td>${members[i].telAreaCode}-${members[i].tel1}-${members[i].tel2}</td>
			<td>${members[i].cellAreaCode}-${members[i].cell1}-${members[i].cell2}</td>
			<td>${members[i].level}</td>
		</tr>
	</c:forEach>
</c:if>


</table>

</body>
</html>