<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/include/header.jsp" %>

<h3>게시물 정보</h3>
번호: ${board.bno}<br/>
제목: ${board.subject}<br/>
내용: ${board.content}<br/>
저자: ${board.writer}<br/>
날짜: ${board.writedate}<br/>
조회: ${board.hitcount}<br/>

<h3>첨부파일 정보</h3>
번호: ${board.boardFiles[0].fno}<br/>
원제: ${board.boardFiles[0].originalName}<br/>
저장: ${board.boardFiles[0].savedName}<br/>
타입: ${board.boardFiles[0].contentType}<br/>

<%@ include file="/common/include/footer.jsp" %>