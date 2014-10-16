package com.spec.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.spec.first.board.Board;

public class TestForm extends ActionForm {

	private String stringField1;
	private String stringField2;
	private String stringField3;
	private String stringField4;
	private String stringField5;

	private String[] stringArrayField = new String[2];
	private Object[] objectArrayField = new Object[2];
	private List listField = new ArrayList();
	private Map mapField = new HashMap();
	private Board boardField = new Board();
	private FormFile[] formFileField = new FormFile[2];

	public String getStringField1() {
		return stringField1;
	}

	public void setStringField1(String stringField1) {
		this.stringField1 = stringField1;
	}

	public String getStringField2() {
		return stringField2;
	}

	public void setStringField2(String stringField2) {
		this.stringField2 = stringField2;
	}

	public String getStringField3() {
		return stringField3;
	}

	public void setStringField3(String stringField3) {
		this.stringField3 = stringField3;
	}

	public String getStringField4() {
		return stringField4;
	}

	public void setStringField4(String stringField4) {
		this.stringField4 = stringField4;
	}

	public String getStringField5() {
		return stringField5;
	}

	public void setStringField5(String stringField5) {
		this.stringField5 = stringField5;
	}

	public String[] getStringArrayField() {
		return stringArrayField;
	}

	public void setStringArrayField(String[] stringArrayField) {
		this.stringArrayField = stringArrayField;
	}

	public Object[] getObjectArrayField() {
		return objectArrayField;
	}

	public void setObjectArrayField(Object[] objectArrayField) {
		this.objectArrayField = objectArrayField;
	}

	public List getListField() {
		return listField;
	}

	public void setListField(List listField) {
		this.listField = listField;
	}

	public Map getMapField() {
		return mapField;
	}

	public void setMapField(Map mapField) {
		this.mapField = mapField;
	}

	public Board getBoardField() {
		return boardField;
	}

	public void setBoardField(Board boardField) {
		this.boardField = boardField;
	}

	public FormFile[] getFormFileField() {
		return formFileField;
	}

	public void setFormFileField(FormFile[] formFileField) {
		this.formFileField = formFileField;
	}

}
