<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/style/main.css" />
</head>
<body>
	
	<form action="<%= request.getContextPath() %>/board/modify"
		method="post">
		
		<input type="hidden" name="bno" value="${board.bno}" />
		<input type="hidden" name="p_bno" value="${board.p_bno}" />
		
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value="${board.subject}" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="6" cols="30">${board.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정하기" />
					<input type="reset" value="초기화" />
					<input type="button" value="취소" onclick="history.back();" />
				</td>
			</tr>
		</table>
		
	</form>
	
</body>
</html>