<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
String memberId = (String) session.getAttribute("member.id");
String memberName = (String) session.getAttribute("member.name");
%>
<a href="<%= request.getContextPath() %>/member/mypage">마이페이지</a><br/>
<%
if (memberId == null) {	// 로그인 하지 않은 상태
%>
	<a href="<%= request.getContextPath() %>/signup">회원가입</a><br/>
	<a href="<%= request.getContextPath() %>/login">로그인</a>
<%
} else {	// 이미 로그인 한 상태
%>
	<a href="<%= request.getContextPath() %>/logout">로그아웃</a>
<%
}
%>
</body>
</html>