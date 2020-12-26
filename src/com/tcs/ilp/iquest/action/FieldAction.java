package com.tcs.ilp.iquest.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import com.tcs.ilp.iquest.bean.Fields;
import com.tcs.ilp.iquest.service.FieldService;

public class FieldAction extends ActionSupport implements ModelDriven<Fields>,SessionAware{

	Fields field = new Fields();
	ArrayList<String> fieldList = new ArrayList<String>();
	private SessionMap<String,Object> sessionMap;  
	public ArrayList<String> getFieldList() {
		return fieldList;
	}

	public void setFieldList(ArrayList<String> fieldList) {
		this.fieldList = fieldList;
	}

	@Override
	@VisitorFieldValidator(appendPrefix=false)

	public Fields getModel() {
		// TODO Auto-generated method stub
		return field;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		FieldService fieldService = new FieldService();
		if(fieldService.addField(field.getTitle()) == 1)
		{
			return SUCCESS;
		}
		if(fieldService.addField(field.getTitle())==2)
		{
			return "CONSTRAINT";
		}
		else
			return ERROR;
	}
	
	@SkipValidation
	public String getFields() throws Exception {
		
		FieldService fieldService = new FieldService();
		sessionMap.put("fieldList", fieldService.getFields());
		//setFieldList(fieldService.getFields());
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		sessionMap=(SessionMap)arg0;  
		
	}
}
