<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/include/header.jsp" %>

<%-- <html:form>, <html:button>, <html:cancel>, <html:submit> 태그 --%>

<html:form action="test_html.do">
	<html:button property="btn1" value="일반" onclick="btnClick()" /><br/>
	<html:reset value="리셋" />
	<html:cancel value="취소" />
	<html:submit value="전송" />
</html:form>

<script type="text/javascript">
	function btnClick() {
		alert("버튼 클릭");
	}
</script>

<hr/>

<%-- <html:text>, <html:textarea>, <html:password>, <html:hidden> 태그 --%>

<html:form action="test_html.do">
	
	<html:hidden property="stringField1" value="1" />
	
	<table>
		<tr>
			<td>stringField2</td>
			<td><html:text property="stringField2" /></td>
		</tr>
		<tr>
			<td>stringField3</td>
			<td><html:password property="stringField3" /></td>
		</tr>
		<tr>
			<td>stringField4</td>
			<td><html:textarea property="stringField4" rows="5" cols="50" /></td>
		</tr>
		<tr>
			<td>stringArrayField[0]</td>
			<td><html:text property="stringArrayField[0]" /></td>
		</tr>
		<tr>
			<td>stringArrayField[1]</td>
			<td><html:text property="stringArrayField[1]" /></td>
		</tr>
		<tr>
			<td>board.subject</td>
			<td><html:text property="boardField.subject" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<html:submit value="보내기" />
			</td>
		</tr>
	</table>
	
</html:form>













<%@ include file="/common/include/footer.jsp" %>






















