package com.spec.first;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class TestMultipartAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TestForm testForm = (TestForm) form;
		
		// <html:file> 테스트
//		List<FormFile> formFiles = testForm.getFormFileField();
//		for (int i = 0; i < formFiles.size(); i++) {
//			FormFile formFile = formFiles.get(i);
//			if (formFile == null) {
//				System.out.println("formFiles[" + i + "] IS NULL!");
//				continue;
//			}
//			System.out.println("formFiles[" + i + "].fileName: " +
//					formFile.getFileName());
//			System.out.println("formFiles[" + i + "].contentType: " +
//					formFile.getContentType());
//			System.out.println("formFiles[" + i + "].fileSize: " +
//					formFile.getFileSize() + " B");
//			
//		}
		
		// <html:checkbox>, <html:multibox>, <html:radio> 테스트
		// 체크박스
		System.out.println("=== 체크박스 ===");
		System.out.println("stringField1: " + testForm.getStringField1());
		System.out.println("stringField2: " + testForm.getStringField2());
		System.out.println("stringField3: " + testForm.getStringField3());
		System.out.println("stringField4: " + testForm.getStringField4());
		System.out.println();
		// 멀티박스
		String[] multiboxValues = testForm.getStringArrayField();
		System.out.println("=== 멀티박스 ===");
		for (int i = 0; i < multiboxValues.length; i++) {
			System.out.println("stringArrayField[" + i + "]: " + multiboxValues[i]);
		}
		System.out.println();
		// 라디오
		System.out.println("=== 라디오 ===");
		System.out.println("stringField5: " + testForm.getStringField5());
		
		return null;
	}
	
}

















