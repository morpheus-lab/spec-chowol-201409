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
			<td><a href="<%= request.getContextPath() %>/board/read/${board.bno}">${board.subject}</a></td>
			<td>${board.writer}</td>
			<td>${board.writedate}</td>
			<td>${board.hitcount}</td>
		</tr>
	</c:forEach>
</c:if>
	</table>
	
<!-- 페이지 내비게이션 -->
<c:forEach begin="1" end="${models.totalPages}" var="p" varStatus="status">
	<c:if test="${p != models.currentPage}"><a href="<%= request.getContextPath() %>/board/?page=${p}"></c:if>${p}<c:if test="${p != models.currentPage}"></a></c:if>
</c:forEach>

</body>
</html>