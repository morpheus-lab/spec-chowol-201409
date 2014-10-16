<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/include/header.jsp" %>

<%-- <c:set> 태그 --%>

<c:set var="counter" value="${counter + 1}" scope="application" />

${counter}<br/>

<hr/>

<%-- <c:if> 태그 --%>

<c:if test="${empty param.id}">
	파라미터 id가 null이거나 빈 스트링임<br/>
</c:if>

id: ${param.id}<br/>
pw: ${param.pw}<br/>

<hr/>

<%-- <c:choose> 태그 --%>

<c:choose>
	<c:when test="${param.color == 'red'}">
		<font color="${param.color}">${param.color}</font>
	</c:when>
	
	<c:when test="${param.color eq 'blue'}">
		<font color="${param.color}">${param.color}</font>
	</c:when>
	
	<c:when test="${param.color == 'green'}">
		<font color="${param.color}">${param.color}</font>
	</c:when>
	
	<c:otherwise>
		<font color="black">black</font>
	</c:otherwise>
</c:choose>

<hr/>

<%-- <c:forEach> 태그 --%>

<table border="1" cellspacing="0">

	<tr bgcolor="yellow">
		<td>숫자</td>
		<td>제곱</td>
	</tr>
	
	<c:forEach var="x" begin="0" end="10" step="2">
		
		<tr>
			<td><c:out value="${x}" /></td>
			<td><c:out value="${x * x}" /></td>
		</tr>
		
	</c:forEach>
	
</table>

<br/><br/>

도시:
<c:forEach var="city" items="${cityList}" varStatus="loop">
	<c:if test="${loop.first}">
		<select>
	</c:if>
	
			<option>${city}</option>
	
	<c:if test="${loop.last}">
		</select>
	</c:if>
</c:forEach>

<br/><br/>

책 선택:
<c:forEach var="book" items="${bookList}">
	<input type="checkbox" name="book" value="${book}" /> ${book}
</c:forEach>

<hr/>

<%-- < c:forTokens > 태그 --%>

<c:forTokens var="job" items="${jobList}" delims="|" varStatus="status">
	<c:if test="${status.first}">
		<select size="3">
	</c:if>
			<option>${job}</option>
	<c:if test="${status.last}">
		</select>
	</c:if>
</c:forTokens>

<hr/>

<%-- <c:redirect> 태그 --%>

<c:redirect url="/welcome.jsp" />















<!--
<h3>게시물 정보</h3>
번호: ${board.bno}<br/>
제목: ${board.subject}<br/>
내용: ${board.content}<br/>
저자: ${board.writer}<br/>
날짜: ${board.writedate}<br/>
조회: ${board.hitcount}<br/>

<h3>첨부파일 정보</h3>
번호: ${board.boardFiles[0].fno}<br/>
원제: ${board.boardFiles[0].originalName}<br/>
저장: ${board.boardFiles[0].savedName}<br/>
타입: ${board.boardFiles[0].contentType}<br/>
-->
<%@ include file="/common/include/footer.jsp" %>