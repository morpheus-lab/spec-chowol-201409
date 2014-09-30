<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.io.*" %>
<%
try {
	// response 메시지의 헤더에 "Content-Type: image/jpeg" 추가
	response.setContentType("image/jpeg");
	
	// response 메시지의 헤더에 "Content-Transfer-Encoding: binary" 추가
	response.addHeader("Content-Transfer-Encoding", "binary");
	
	String filepath = application.getRealPath("/") + "images\\애쉬.jpg";
	
	// 파일명에 한글이 포함되어 있는 경우를 위해
	//String filename = new String(filepath.getBytes("ISO-8859-1"), "UTF-8");
	//System.out.println(filename);
	
	FileInputStream fis = new FileInputStream(filepath);
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	byte[] buf = new byte[1024];
	for(int i = 0; (i = fis.read(buf)) != -1; ) {
		bos.write(buf, 0, i);
	}
	bos.flush();
} catch(IOException e) {
	response.setContentType("text/html;charset=utf-8");
	out.println("Error: " + e.getMessage());
}
%>
</body>
</html>