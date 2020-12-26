package com.tcs.ilp.iquest.service;


import java.util.ArrayList;

import com.tcs.ilp.iquest.dao.FieldDAO;

public class FieldService {

	public int addField(String field)
	{
		FieldDAO fieldDAO = new FieldDAO();
		return fieldDAO.addField(field);
		
	}
	
	public ArrayList<String> getFields()
	{
		FieldDAO fieldDAO = new FieldDAO();
		return fieldDAO.getFields();
	}
}
