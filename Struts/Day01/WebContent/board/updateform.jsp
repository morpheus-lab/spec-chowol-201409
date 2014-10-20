<%@page import="com.spec.first.model.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/include/header.jsp" %>

<h3>게시물 수정</h3>

<form name="updateForm" method="post" action="update.do?method=update"
	enctype="multipart/form-data">

	<input type="hidden" name="bno" value="${board.bno}" />

	<table border="1" width="500">
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject" value="${board.subject}" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" cols="55" rows="5">${board.content}</textarea></td>
		</tr>
		<tr>
			<td>글쓴이</td>
			<td><input type="text" name="writer" value="${board.writer}" /></td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
				<c:if test="${not empty board.boardFiles}">
					<c:forEach var="boardFile" items="${board.boardFiles}">
						${boardFile.originalName}
						<input type="button" value="삭제" onclick="" />
						<br/>
					</c:forEach>
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정하기" onclick="checkData()" />
			</td>
		</tr>
	</table>

</form>

<script type="text/javascript">
	function checkData() {
		var subjectEl = window.document.updateForm.subject;
		var contentEl = window.document.updateForm.content;
		var writerEl = window.document.updateForm.writer;
		
		if (subjectEl.value == "") {
			alert("제목을 입력하세요.");
			subjectEl.focus();
			return;
		}
		
		if (contentEl.value == "") {
			alert("내용을 입력하세요.");
			contentEl.focus();
			return;
		}
		
		if (writerEl.value == "") {
			alert("글쓴이를 입력하세요.");
			writerEl.focus();
			return;
		}
		
		window.document.updateForm.submit();
	}
</script>



<%@ include file="/common/include/footer.jsp" %>