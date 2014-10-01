<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

String code = request.getParameter("code");

String viewPageURI = null;

if ("1".equals(code)) {
	viewPageURI = "1.jsp";
} else if ("2".equals(code)) {
	viewPageURI = "2.jsp";
}

%>

<jsp:forward page="<%= viewPageURI %>" />