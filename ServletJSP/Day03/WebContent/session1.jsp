<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<body>
<%
if( session.isNew() ) {
	out.println("NEW <br/>");
	out.println("Session ID: " + session.getId() + "<br/>");
	out.println("Creation Time: " + new Date(session.getCreationTime()) + "<br/>");
	out.println("Last Access Time: " + new Date(session.getLastAccessedTime()) + "<br/>");
	out.println("Max Inactive Interval: " + session.getMaxInactiveInterval() + "<br/>");
} else {
	out.println("OLD <br/>");
}
%>
</body>
</html>