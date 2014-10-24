<%@page import="com.bitschool.mentorschool.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 수정</title>
</head>
<body>

<form name="modifyForm" action="<%= request.getContextPath() %>/member/mypage/modify"
	method="post" onsubmit="return checkForm()">

	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${member.name}" /></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<%
					String gender = ((MemberVO) request.getAttribute("member")).getGender();
				%>
				<input type="radio" name="gender" value="M" <%= "M".equals(gender) ? "checked=\"checked\"" : "" %> />남
				<input type="radio" name="gender" value="F" <%= "F".equals(gender) ? "checked=\"checked\"" : "" %> />여
				<input type="radio" name="gender" value="U" <%= "U".equals(gender) ? "checked=\"checked\"" : "" %> />밝히지 않음
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="${member.email}" /></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${member.id}" readonly="readonly" /></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw" value="${member.pw}" /></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" name="pwConfirm" value="${member.pw}" /></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
				<%
				String telAreaCode = ((MemberVO) request.getAttribute("member")).getTelAreaCode();
				%>
				<select name="telAreaCode">
					<option value="" <%= telAreaCode == null || telAreaCode.equals("") ? "selected=\"selected\"" : "" %>>선택</option>
					<option value="02" <%= "02".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>02</option><!-- 서울 -->
					<option value="031" <%= "031".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>031</option><!-- 경기 -->
					<option value="032" <%= "032".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>032</option><!-- 인천 -->
					<option value="033" <%= "033".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>033</option><!-- 강원 -->
					<option value="041" <%= "041".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>041</option><!-- 충남 -->
					<option value="042" <%= "042".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>042</option><!-- 대전 -->
					<option value="043" <%= "043".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>043</option><!-- 충북 -->
					<option value="044" <%= "044".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>044</option><!-- 세종 -->
					<option value="051" <%= "051".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>051</option><!-- 부산 -->
					<option value="052" <%= "052".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>052</option><!-- 울산 -->
					<option value="053" <%= "053".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>053</option><!-- 대구 -->
					<option value="054" <%= "054".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>054</option><!-- 경북 -->
					<option value="055" <%= "055".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>055</option><!-- 경남 -->
					<option value="061" <%= "061".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>061</option><!-- 전남 -->
					<option value="062" <%= "062".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>062</option><!-- 광주 -->
					<option value="063" <%= "063".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>063</option><!-- 전북 -->
					<option value="064" <%= "064".equals(telAreaCode) ? "selected=\"selected\"" : "" %>>064</option><!-- 제주 -->
				</select>
				-
				<input type="text" name="tel1" size="4" maxlength="4" value="${member.tel1}" />
				-
				<input type="text" name="tel2" size="4" maxlength="4" value="${member.tel2}" />
			</td>
		</tr>
		<tr>
			<td>휴대전화</td>
			<td>
				<%
					String cellAreaCode = ((MemberVO) request.getAttribute("member")).getCellAreaCode();
				%>
				<select name="cellAreaCode">
					<option value="" <%= cellAreaCode == null || cellAreaCode.equals("") ? "selected=\"selected\"" : "" %>>선택</option>
					<option value="010" <%= "010".equals(cellAreaCode) ? "selected=\"selected\"" : "" %>>010</option>
					<option value="011" <%= "011".equals(cellAreaCode) ? "selected=\"selected\"" : "" %>>011</option>
					<option value="016" <%= "016".equals(cellAreaCode) ? "selected=\"selected\"" : "" %>>016</option>
					<option value="017" <%= "017".equals(cellAreaCode) ? "selected=\"selected\"" : "" %>>017</option>
					<option value="018" <%= "018".equals(cellAreaCode) ? "selected=\"selected\"" : "" %>>018</option>
					<option value="019" <%= "019".equals(cellAreaCode) ? "selected=\"selected\"" : "" %>>019</option>
				</select>
				-
				<input type="text" name="cell1" size="4" maxlength="4" value="${member.cell1}" />
				-
				<input type="text" name="cell2" size="4" maxlength="4" value="${member.cell2}" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="정보 수정" />
				<input type="reset" value="입력 초기화" />
				<input type="button" value="수정 취소" />
			</td>
		</tr>
	</table>

</form>

</body>
</html>