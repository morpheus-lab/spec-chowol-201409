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
			<td bgcolor="yellow">제목</td>
			<td><input type="text" name="subject" value="${board.subject}" /></td>
		</tr>
		<tr>
			<td bgcolor="yellow">내용</td>
			<td><textarea name="content" cols="55" rows="5">${board.content}</textarea></td>
		</tr>
		<tr>
			<td bgcolor="yellow">글쓴이</td>
			<td><input type="text" name="writer" value="${board.writer}" /></td>
		</tr>
		<tr>
			<td bgcolor="yellow">첨부파일</td>
			<td>
				<c:forEach var="idx" begin="0" end="1" step="1">
					<div id="file${idx}">
						<c:if test="${not empty board.boardFiles[idx]}">
							${board.boardFiles[idx].originalName}
							<input type="button" value="삭제" onclick="checkFileDelete(${idx})" />
							<input type="hidden" name="boardFilesFno" value="${board.boardFiles[idx].fno}" />
						</c:if>
						<c:if test="${empty board.boardFiles[idx]}">
							<input type="file" name="boardFiles" />
							<input type="hidden" name="boardFilesFno" value="0" />
						</c:if>
					</div>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="수정하기" onclick="checkData()" />
				<input type="button" value="취소" onclick="history.back()" />
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
	
	function checkFileDelete(idx) {
		if (confirm("첨부파일을 삭제하시겠습니까?")) {
			var fileDiv = $("file" + idx);
			while (fileDiv.firstChild) {
				fileDiv.removeChild(fileDiv.firstChild);
			}
			
			var fileInputEl = document.createElement("input");
			fileInputEl.type = "file";
			fileInputEl.name = "boardFiles";
			
			fileDiv.appendChild(fileInputEl);
			
			var hiddenInputEl = document.createElement("input");
			hiddenInputEl.type = "hidden";
			hiddenInputEl.name = "boardFilesFno";
			hiddenInputEl.value = "0";
			
			fileDiv.appendChild(hiddenInputEl);
		}
	}
	
</script>



<%@ include file="/common/include/footer.jsp" %>