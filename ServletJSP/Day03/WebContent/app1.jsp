<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%
try {
	String fn = application.getRealPath("/") + "images\\애쉬.jpg";
	//String filename = new String(fn.getBytes("ISO-8859-1"), "UTF-8");
	String mimeType = application.getMimeType(fn);
	response.setContentType(mimeType);
	response.addHeader("Content-Transfer-Encoding", "binary");
	FileInputStream fis = new FileInputStream(fn);
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	byte[] buf = new byte[1024];
	for(int i=0; (i=fis.read(buf)) != -1; ) {
		bos.write(buf, 0, i);
	}
	bos.flush();
} catch(IOException e) {
	response.setContentType("text/html;charset=utf-8");
	out.println("Error: " + e.getMessage());
}
%>