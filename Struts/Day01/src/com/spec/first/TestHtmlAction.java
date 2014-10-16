package com.spec.first;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TestHtmlAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		if (isCancelled(request)) {
			System.out.println("사용자가 취소 버튼 누름");
		} else {
			System.out.println("사용자가 전송 버튼 누름");
		}
		
		TestForm testForm = (TestForm) form;
		
		System.out.println("stringField1: " + testForm.getStringField1());
		System.out.println("stringField2: " + testForm.getStringField2());
		System.out.println("stringField3: " + testForm.getStringField3());
		System.out.println("stringField4: " + testForm.getStringField4());
		
		for (int i = 0; i < testForm.getStringArrayField().length; i++) {
			System.out.println("stringArrayField[" + i + "]: " +
					testForm.getStringArrayField()[i]);
		}
		
		System.out.println("boardField.subject: " + testForm.getBoardField().getSubject());
		
		return mapping.findForward("view");
	}
	
	
	
}
