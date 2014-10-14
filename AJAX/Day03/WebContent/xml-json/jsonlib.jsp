<%@page import="org.json.JSONWriter"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
JSONObject jsonObj = new JSONObject();

jsonObj.put("location", "Vali");
jsonObj.put("boardsSold", 141);
jsonObj.put("bootsSold", 14);
jsonObj.put("bindingsSold", 10);

%>
<%= jsonObj.toString() %>