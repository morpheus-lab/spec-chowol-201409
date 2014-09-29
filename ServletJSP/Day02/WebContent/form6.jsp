<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Multipart 파일 처리</title>
</head>
<body>
<%
// 파일이 저장될 경로
String savePath = "C:\\applications\\upload";
//String savePath = application.getRealPath("/upload");
// 업로드 파일의 최대 크기
int sizeLimited = 5 * 1024 * 1024;

MultipartRequest mr = new MultipartRequest(request, savePath,
		sizeLimited, "utf-8", new DefaultFileRenamePolicy());

File file = mr.getFile("attach");
String fileName = file.getName();
long fileSize = file.length();

if (fileName == null) {
	// 업로드 실패한 경우
%>
	파일 업로드 실패
<%
} else {
	// 업로드 성공한 경우
%>
	파일명: <%= fileName %><br/>
	파일크기: <%= fileSize %> bytes<br/>
	설명: <%= mr.getParameter("desc") %>
<%
}
%>


</body>
</html>