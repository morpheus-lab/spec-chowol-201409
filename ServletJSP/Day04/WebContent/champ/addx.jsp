<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.ConnectionContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

// form에 입력한 정보들을 요청 파라미터로 부터 추출
String name = request.getParameter("name");
String type = request.getParameter("type");
int health  = Integer.parseInt( request.getParameter("health") );
int damage  = Integer.parseInt( request.getParameter("damage") );

// DB에 INSERT
// 쿼리문
String sql = "INSERT INTO champ (no, name, type, health, damage) "
			+"VALUES (seq_champ.NEXTVAL, ?, ?, ?, ?)";
// Connection
Connection conn = ConnectionContext.getConnection();
// PreparedStatement
PreparedStatement pstmt = conn.prepareStatement(sql);
// 쿼리 파라미터 세팅
pstmt.setString(1, name);
pstmt.setString(2, type);
pstmt.setInt(3, health);
pstmt.setInt(4, damage);
// execute
int count = pstmt.executeUpdate();
// 결과 처리
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>챔프 정보 DB 삽입</title>
</head>
<body>
쿼리 실행 결과 <%= count %>개의 레코드가 삽입되었습니다.<br/>
<%
if (count < 1) {
	// insert 실패
	out.println("새로운 챔피언 정보를 삽입하지 못하였습니다.<br/>");
} else {
	// insert 성공
	out.println("새로운 챔피언 정보를 성공적으로 삽입하였습니다.<br/>");
}
%>
<a href="list.jsp">리스트 보기</a>
</body>
</html>

























