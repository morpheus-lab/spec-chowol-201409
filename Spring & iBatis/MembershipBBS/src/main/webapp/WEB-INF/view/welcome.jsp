<%@page import="com.bitschool.mentorschool.vo.MemberVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원제 답변형 게시판</title>
</head>
<body>

어서오세요~<br/>
<br/>
<br/>

<a href="<%= request.getContextPath() %>/member/mypage">마이페이지</a><br/>

<a href="<%= request.getContextPath() %>/board/">게시판</a><br/>

<c:if test="${ empty member.id }">
	<a href="<%= request.getContextPath() %>/signup">회원가입</a><br/>
	<a href="<%= request.getContextPath() %>/login">로그인</a>
</c:if>
<c:if test="${ not empty member.id }">
	<a href="<%= request.getContextPath() %>/logout">로그아웃</a>
</c:if>
</body>
</html>