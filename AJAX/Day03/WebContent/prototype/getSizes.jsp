<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%><%--
경  로: WebContent/prototype
파일명: getSizes.jsp
--%><%
String color = request.getParameter("color");
String responseMessage = null;
if ("azure".equals(color)) {
	responseMessage = "['S', 'M', 'XXXL']";
}
else if ("cardinal".equals(color)) {
	responseMessage = "['M', 'L', 'XL']";
}
else if ("ecru".equals(color)) {
	responseMessage = "['S','M','L','XL','XXL','XXXL']";
}
else if ("hunter".equals(color)) {
	responseMessage = "['S','M','L','XL','XXL']";
}
%><%= responseMessage %>