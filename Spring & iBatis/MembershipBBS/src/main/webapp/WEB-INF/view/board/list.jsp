<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/style/main.css" />
</head>
<body>

	<table>
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
<c:if test="${empty models.boardList}">
		<tr>
			<td colspan="5" align="center">
				조회된 글이 없습니다.
			</td>
		</tr>
</c:if>
<c:if test="${not empty models.boardList}">
	<c:forEach var="board" items="${models.boardList}">
		<tr>
			<td>${board.bno}</td>
			<td><c:forEach begin="2" end="${board.level}">&nbsp;&nbsp;</c:forEach><c:if test="${board.level > 1}"><img src="<%= request.getContextPath() %>/images/indent_arrow.gif" border="0" /></c:if><a href="<%= request.getContextPath() %>/board/read/${board.bno}">${board.subject}</a></td>
			<td>${board.writer}</td>
			<td>${board.writedate}</td>
			<td>${board.hitcount}</td>
		</tr>
	</c:forEach>
</c:if>
	</table>
	
<!-- 페이지 내비게이션 -->
<!--
<c:set var="block" value="${((models.currentPage - 1) - (models.currentPage - 1) % 10) / 10}" />
<c:forEach begin="${block * 10 + 1}" end="${models.totalPages}" var="p" varStatus="status">
	<c:if test="${p != models.currentPage}"><a href="<%= request.getContextPath() %>/board/?page=${p}"></c:if>${p}<c:if test="${p != models.currentPage}"></a></c:if>
</c:forEach>
-->

<%
Map<String, Object> models = (Map<String, Object>) request.getAttribute("models");
int currentPage = (Integer) models.get("currentPage");
int totalPages = (Integer) models.get("totalPages");
int block = (currentPage - 1) / 10;
Integer pageSize = 0;
try {
	pageSize = Integer.parseInt(request.getParameter("pageSize"));
} catch (NumberFormatException e) {
	pageSize = 10;
}

if (currentPage > 1) {
%>
	<a href="<%= request.getContextPath() %>/board/?pageSize=<%= pageSize %>&page=1">처음</a>
<%
}

// 이전 블록
boolean prevBlock = block > 0;
if (prevBlock) {
%>
	<a href="<%= request.getContextPath() %>/board/?pageSize=<%= pageSize %>&page=<%= block * 10 %>">이전</a>
<%
}

for (int i = block * 10 + 1; i <= (block + 1) * 10 && i <= totalPages; i++) {
	if (i != currentPage) {
%>
		<a href="<%= request.getContextPath() %>/board/?pageSize=<%= pageSize %>&page=<%= i %>"><%= i %></a>
<%
	} else {
%>
		<%= i %>
<%
	}
}
int totalBlocks = (totalPages - 1) / 10 + 1;
boolean nextBlock = block < totalBlocks - 1;
if (nextBlock) {
%>
		<a href="<%= request.getContextPath() %>/board/?pageSize=<%= pageSize %>&page=<%= (block + 1) * 10 + 1 %>">다음</a>
<%
}

if (currentPage < totalPages) {
%>
<a href="<%= request.getContextPath() %>/board/?pageSize=<%= pageSize %>&page=<%= totalPages %>">마지막</a>
<%
}
%>

<br/>

<input type="button" value="글쓰기" onclick="location.href='<%= request.getContextPath() %>/board/write';" />

</body>
</html>
















