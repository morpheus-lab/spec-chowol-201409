<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
	String sGold;
	int gold;
	
	public void jspInit() {
		
		System.out.println("jspInit() 호출됨");
		
		ServletConfig myConfig = getServletConfig();
		sGold = myConfig.getInitParameter("시작골드");
		gold = Integer.parseInt(sGold);
	}
	
	public void jspDestroy() {
		
		System.out.println("jspDestroy() 호출됨");
		
		gold = Integer.parseInt(sGold);
	}
%>

시작골드: <%= config.getInitParameter("시작골드") %>

현재 골드: <%= gold %>

<%
	gold = gold + 20;
%>

</body>
</html>