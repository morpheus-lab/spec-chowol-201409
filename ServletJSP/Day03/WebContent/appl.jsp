<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
1. 서버 정보: <%=application.getServerInfo() %> <br/>
2. 서블릿 API 버전 정보: <%=application.getMajorVersion()+"."+application.getMinorVersion() %> <br/>
로그 기록 남김<br/>
<%
application.log("appl.jsp 실행");
%>

3. JSP API Ver.: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>
</body>
</html>