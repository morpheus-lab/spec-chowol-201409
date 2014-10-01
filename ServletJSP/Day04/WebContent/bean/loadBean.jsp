<%@page import="bean.User"%>
<%@page import="java.io.ObjectInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Bean 역직렬화</title>
</head>
<body>

<%

String filename = "C:/applications/bean/admin.bean";
File beanFile = new File(filename);
FileInputStream fin = new FileInputStream(beanFile);
ObjectInputStream oin = new ObjectInputStream(fin);

User user = (User) oin.readObject();

oin.close();
%>

사용자정보<br/>
아이디: <%= user.getId() %><br/>
이름: <%= user.getName() %><br/>
비밀번호: <%= user.getPw() %><br/>
이메일: <%= user.getEmail() %><br/>
등록일: <%= user.getRegDate() %><br/>

</body>
</html>