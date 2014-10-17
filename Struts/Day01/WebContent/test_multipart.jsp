<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/include/header.jsp" %>

<html:form action="/test_multipart.do" enctype="multipart/form-data">

	<table>
		<tr>
			<td>첨부파일1</td>
			<td><html:file property="formFileField" /></td>
		</tr>
		<tr>
			<td>첨부파일2</td>
			<td><html:file property="formFileField" /></td>
		</tr>
		<tr>
			<td>체크박스</td>
			<td>
				<html:checkbox property="stringField1" value="true">stringField1</html:checkbox>
				<html:checkbox property="stringField2" value="yes">stringField2</html:checkbox>
				<html:checkbox property="stringField3" value="on">stringField3</html:checkbox>
				<html:checkbox property="stringField4">stringField4</html:checkbox>
			</td>
		</tr>
		<tr>
			<td>멀티박스</td>
			<td>
				<html:multibox property="stringArrayField" value="movie" />Movie
				<html:multibox property="stringArrayField" value="soccer" />Soccer
				<html:multibox property="stringArrayField" value="fishing" />Fishing
				<html:multibox property="stringArrayField" value="pingpong" />Pingpong
				<html:multibox property="stringArrayField" value="basketball" />Basketball
			</td>
		</tr>
		<tr>
			<td>라디오</td>
			<td>
				<html:radio property="stringField5" value="true">stringField5(true)</html:radio>
				<html:radio property="stringField5" value="false">stringField5(false)</html:radio>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<html:reset value="초기화" />
				<html:submit value="전송하기" />
			</td>
		</tr>
	</table>

</html:form>

<%@ include file="/common/include/footer.jsp" %>























