<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<body>
<%!
	public void jspInit() {
		System.out.println("session2.jsp jspInit() 호출됨");
	}

	public void jspDestroy() {
		System.out.println("session2.jsp jspDestroy() 호출됨");
	}
%>
<%
if( session.isNew() ) {
	out.println("NEW <br/>");
} else {
	out.println("OLD <br/>");
	out.println("Session ID: " + session.getId() + "<br/>");
	out.println("Creation Time: " + new Date(session.getCreationTime()) + "<br/>");
	out.println("Last Access Time: " + new Date(session.getLastAccessedTime()) + "<br/>");
	out.println("Max Inactive Interval: " + session.getMaxInactiveInterval() + "<br/>");
	
	session.invalidate();
}
%>
</body>
</html>