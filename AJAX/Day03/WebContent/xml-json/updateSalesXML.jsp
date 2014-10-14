<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int boards = (int) (Math.random() * 1001);
int boots = (int) (Math.random() * 501);
int bindings = (int) (Math.random() * 301);
%>
<totals>
	<boards-sold><%= boards %></boards-sold>
	<boots-sold><%= boots %></boots-sold>
	<bindings-sold><%= bindings %></bindings-sold>
</totals>