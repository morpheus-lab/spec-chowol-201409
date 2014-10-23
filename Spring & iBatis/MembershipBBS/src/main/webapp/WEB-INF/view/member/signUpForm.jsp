<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입 신청서</title>
<script type="text/javascript">
	
	function checkForm() {
		if (document.signUpForm.name.value == "") {
			alert("이름은 필수");
			document.signUpForm.name.focus();
			return false;
		}
		if (document.signUpForm.gender.value == "") {
			alert("성별 선택은 필수");
			document.signUpForm.gender[2].focus();
			return false;
		}
		if (document.signUpForm.email.value == "") {
			alert("이메일은 필수");
			document.signUpForm.email.focus();
			return false;
		}
		if (document.signUpForm.id.value == "") {
			alert("아이디는 필수");
			document.signUpForm.id.focus();
			return false;
		}
		if (document.signUpForm.pw.value == "") {
			alert("비밀번호는 필수");
			document.signUpForm.pw.focus();
			return false;
		}
		if (document.signUpForm.pwConfirm.value == "") {
			alert("비밀번호 확인은 필수");
			document.signUpForm.pwConfirm.focus();
			return false;
		}
		if (document.signUpForm.pw.value != document.signUpForm.pwConfirm.value) {
			alert("비밀번호와 비밀번호 확인이 일치하지 않음");
			document.signUpForm.pwConfirm.focus();
			return false;
		}
		var hasTelNum = false;
		var hasCelNum = false;
		if (document.signUpForm.telAreaCode.value != "" &&
				document.signUpForm.tel1.value != "" &&
				document.signUpForm.tel2.value != "") {
			hasTelNum = true;
		}
		if (document.signUpForm.cellAreaCode.value != "" &&
				document.signUpForm.cell1.value != "" &&
				document.signUpForm.cell2.value != "") {
			hasCelNum = true;
		}
		if (!hasTelNum && !hasCelNum) {
			alert("전화번호/휴대전화 둘 중 하나는 필수");
			document.signUpForm.cellAreaCode.focus();
			return false;
		}
		
		return true;
	}
	
</script>
</head>
<body>

<form name="signUpForm" action="/signup" method="post" onsubmit="return checkForm()">

	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<input type="radio" name="gender" value="M" />남
				<input type="radio" name="gender" value="F" />여
				<input type="radio" name="gender" value="U" />밝히지 않음
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw" /></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" name="pwConfirm" /></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
				<select name="telAreaCode">
					<option value="">선택</option>
					<option value="02">02</option><!-- 서울 -->
					<option value="031">031</option><!-- 경기 -->
					<option value="032">032</option><!-- 인천 -->
					<option value="033">033</option><!-- 강원 -->
					<option value="041">041</option><!-- 충남 -->
					<option value="042">042</option><!-- 대전 -->
					<option value="043">043</option><!-- 충북 -->
					<option value="044">044</option><!-- 세종 -->
					<option value="051">051</option><!-- 부산 -->
					<option value="052">052</option><!-- 울산 -->
					<option value="053">053</option><!-- 대구 -->
					<option value="054">054</option><!-- 경북 -->
					<option value="055">055</option><!-- 경남 -->
					<option value="061">061</option><!-- 전남 -->
					<option value="062">062</option><!-- 광주 -->
					<option value="063">063</option><!-- 전북 -->
					<option value="064">064</option><!-- 제주 -->
				</select>
				-
				<input type="text" name="tel1" size="4" maxlength="4" />
				-
				<input type="text" name="tel2" size="4" maxlength="4" />
			</td>
		</tr>
		<tr>
			<td>휴대전화</td>
			<td>
				<select name="cellAreaCode">
					<option value="">선택</option>
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
				</select>
				-
				<input type="text" name="cell1" size="4" maxlength="4" />
				-
				<input type="text" name="cell2" size="4" maxlength="4" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="가입신청" />
				<input type="reset" value="입력초기화" />
				<input type="button" value="신청취소" />
			</td>
		</tr>
	</table>

</form>

</body>
</html>