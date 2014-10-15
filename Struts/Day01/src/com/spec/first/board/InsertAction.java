package com.spec.first.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class InsertAction extends DispatchAction {
	
	public ActionForward insertForm(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("insertForm 호출됨");
		return null;
	}
	
	public ActionForward insert(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("insert 호출됨");
		
		BoardForm boardForm = (BoardForm) form;
		
		System.out.println("bno = " + boardForm.getBno());
		
		return null;
	}
	
}
