<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방문자 수 카운터</title>
</head>
<body>
<%
	//String file = "/count.txt";
	//String path = application.getRealPath(file);
	
	String path = "C:\\Users\\bit\\git\\spec-chowol-201409\\ServletJSP\\Day03\\WebContent\\count.txt";
	
	BufferedReader br = null;
	PrintWriter pr = null;
	Integer count = null;
	
	try {
		br = new BufferedReader(new FileReader(path));
		count = Integer.parseInt(br.readLine().trim());
		br.close();
		
		// 새로운 세션이면 카운트 증가
		if(session.isNew()) {
			
			pr = new PrintWriter(new FileWriter(path));
			pr.println(++count);
			pr.close();
		}
		
	} catch(IOException e) {
		out.println("Error: " + e.getMessage());
	}
%>
방문자수: <%= count %>
</body>
</html>