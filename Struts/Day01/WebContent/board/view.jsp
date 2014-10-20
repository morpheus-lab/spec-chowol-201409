<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/include/header.jsp" %>

<h3>게시물 내용 보기</h3>
<hr/>

<table border="1" width="500">
	<tr>
		<td bgcolor="yellow">번호</td>
		<td>${board.bno}</td>
	</tr>
	<tr>
		<td bgcolor="yellow">제목</td>
		<td>${board.subject}</td>
	</tr>
	<tr>
		<td bgcolor="yellow">작성자</td>
		<td>${board.writer}</td>
	</tr>
	<tr>
		<td bgcolor="yellow">작성일</td>
		<td>${board.writedate}</td>
	</tr>
	<tr>
		<td bgcolor="yellow">조회수</td>
		<td>${board.hitcount}</td>
	</tr>
	<tr>
		<td bgcolor="yellow">내용</td>
		<td>${board.content}</td>
	</tr>
	<tr>
		<td bgcolor="yellow">첨부파일</td>
		<td>
			<c:if test="${empty board.boardFiles}">
				첨부파일이 없습니다
			</c:if>
			<c:if test="${not empty board.boardFiles}">
				<c:forEach var="boardFile" items="${board.boardFiles}">
					<a href="download.do?fno=${boardFile.fno}">${boardFile.originalName}</a><br/>
				</c:forEach>
			</c:if>
		</td>
	</tr>
</table>
<br/>
<a href="list.do">목록으로</a>
<br/>

<%@ include file="/common/include/footer.jsp" %>