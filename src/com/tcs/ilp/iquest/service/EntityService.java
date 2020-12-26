package com.tcs.ilp.iquest.service;

import java.util.ArrayList;

import com.tcs.ilp.iquest.dao.EntityDAO;


public class EntityService {
	
	public int addEntity(String entity)
	{
		EntityDAO entityDAO = new EntityDAO();
		return entityDAO.addEntity(entity);
		
	}
	
	public ArrayList<String> getEntities()
	{
		EntityDAO entityDAO = new EntityDAO();
		return entityDAO.getEntities();
	}
}
