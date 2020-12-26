package com.tcs.ilp.iquest.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.tcs.ilp.iquest.bean.EntityMapping;
import com.tcs.ilp.iquest.bean.FieldEntityMapping;
import com.tcs.ilp.iquest.dao.FieldEntityMappingDAO;

public class FieldEntityMappingService {
	
	public HashMap<Integer, String> getFields()
	{
		FieldEntityMappingDAO fieldEntityMappingDAO = new FieldEntityMappingDAO();
		return fieldEntityMappingDAO.getFieldMap();
	
	}
	
	public HashMap<Integer, String> getEntities()
	{
		FieldEntityMappingDAO fieldEntityMappingDAO = new FieldEntityMappingDAO();
		return fieldEntityMappingDAO.getEntityMap();
	}

	public HashMap<Integer, String> getFieldTypes()
	{
		FieldEntityMappingDAO fieldEntityMappingDAO = new FieldEntityMappingDAO();
		return fieldEntityMappingDAO.getFieldTypes();
	}
	
	public int mapData(FieldEntityMapping fieldEntMapping)
	{
		FieldEntityMappingDAO fieldEntityMappingDAO = new FieldEntityMappingDAO();
		return fieldEntityMappingDAO.mapData(fieldEntMapping);
	}
	
	public ArrayList<EntityMapping> getFieldMap(int entityId)
	{
		FieldEntityMappingDAO fieldEntityMappingDAO = new FieldEntityMappingDAO();
		return fieldEntityMappingDAO.getFieldMap(entityId);
	}
}
