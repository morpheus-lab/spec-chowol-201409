<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/include/header.jsp" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<h3>게시물 작성</h3>

<form name="insertForm" method="post"
	action="insert.do?method=insert"
	enctype="multipart/form-data">
	
	<table>
		<tr>
			<td>제목</td>
			<td>
				<input type="text" name="subject" value="${param.subject}" />
				<font color="red"><html:errors property="subject" /></font>
			</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea name="content" rows="5" cols="30">${param.content}</textarea>
				<font color="red"><html:errors property="content" /></font>
			</td>
		</tr>
		<tr>
			<td>글쓴이</td>
			<td>
				<input type="text" name="writer" value="${param.writer}" />
				<font color="red"><html:errors property="writer" /></font>
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
				<input type="file" name="boardFiles" /><br/>
				<input type="file" name="boardFiles" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="글올리기" onclick="checkData();" />
				<input type="reset" value="다시쓰기" />
				<input type="button" value="목록가기" onclick="goList();" />
			</td>
		</tr>
	</table>
	
</form>

<script type="text/javascript">
	function goList() {
		window.location = "list.do";
	}
	
	function checkData() {
		var subject = window.document.insertForm.subject.value;
		var content = window.document.insertForm.content.value;
		var writer = window.document.insertForm.writer.value;
		
		if (subject == "") {
			alert("제목이 누락되었습니다.");
			window.document.insertForm.subject.focus();
			return;
		}
		if (content == "") {
			alert("내용이 누락되었습니다.");
			window.document.insertForm.content.focus();
			return;
		}
		if (writer == "") {
			alert("글쓴이가 누락되었습니다.");
			window.document.insertForm.writer.focus();
			return;
		}
		
		window.document.insertForm.submit();
	}
</script>

<%@ include file="/common/include/footer.jsp" %>