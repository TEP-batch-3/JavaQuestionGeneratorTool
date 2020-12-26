package com.tcs.ilp.iquest.service;

import java.util.ArrayList;

import com.tcs.ilp.iquest.bean.Entity;
import com.tcs.ilp.iquest.bean.Inheritance;
import com.tcs.ilp.iquest.dao.EntityDAO;

public class InheritanceService {
	
	public ArrayList<Entity> getEntityList()
	{
		EntityDAO entDAO = new EntityDAO();
		return entDAO.getEntityList();
		
	}
	
	public int mapParentChild(int parentId,int childId)
	{
		EntityDAO entDAO = new EntityDAO();
		return entDAO.mapParentChild(parentId, childId);
	}
	
	public ArrayList<Inheritance> getMappingList()
	{
		EntityDAO entDAO = new EntityDAO();
		return entDAO.getMappingList();
	}
}
