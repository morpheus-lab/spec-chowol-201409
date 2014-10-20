<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/include/header.jsp" %>

<table border="1">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
<c:forEach var="board" items="${boardList}">
	<tr>
		<td>${board.bno}</td>
		<td><a href="view.do?bno=${board.bno}">${board.subject}</a></td>
		<td>${board.writer}</td>
		<td>${board.writedate}</td>
		<td>${board.hitcount}</td>
	</tr>
</c:forEach>
</table>
<br/>
<a href="insert.do?method=insertForm">새 글 쓰기</a>
<br/>
<%@ include file="/common/include/footer.jsp" %>