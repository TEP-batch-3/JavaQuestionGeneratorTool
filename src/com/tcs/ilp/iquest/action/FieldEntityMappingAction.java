package com.tcs.ilp.iquest.action;


import java.util.HashMap;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tcs.ilp.iquest.bean.FieldEntityMapping;
import com.tcs.ilp.iquest.service.FieldEntityMappingService;

public class FieldEntityMappingAction extends ActionSupport implements ModelDriven<FieldEntityMapping>{

	FieldEntityMapping fieldEntMapping = new FieldEntityMapping();
	@Override
	public FieldEntityMapping getModel() {
		// TODO Auto-generated method stub
		return fieldEntMapping;
	}
	
	public String getData() throws Exception {
	
		
		FieldEntityMappingService fieldEntityMappingService = new FieldEntityMappingService();
		HashMap<Integer, String> fieldMap = fieldEntityMappingService.getFields();
		HashMap<Integer, String> entityMap = fieldEntityMappingService.getEntities();
		HashMap<Integer, String> fieldTypeMap = fieldEntityMappingService.getFieldTypes();
		if(fieldMap.size() > 0 && entityMap.size() > 0 && fieldTypeMap.size() > 0)
		{
			
			this.fieldEntMapping.setFieldMap(fieldMap);
			this.fieldEntMapping.setEntityMap(entityMap);
			this.fieldEntMapping.setFieldTypeMap(fieldTypeMap);
			return SUCCESS;
		}
		else return ERROR;
	}
	
	public String mapField() throws Exception {
		
		//System.out.println(fieldEntMapping);
		
		FieldEntityMappingService fieldEntityMappingService = new FieldEntityMappingService();
		if(fieldEntityMappingService.mapData(fieldEntMapping) == 1)
	
			return SUCCESS;
		else if(fieldEntityMappingService.mapData(fieldEntMapping) == 2)
		{
			addFieldError("fieldId", "The field is already mapped to the selected Entity");
			HashMap<Integer, String> fieldMap = fieldEntityMappingService.getFields();
			HashMap<Integer, String> entityMap = fieldEntityMappingService.getEntities();
			HashMap<Integer, String> fieldTypeMap = fieldEntityMappingService.getFieldTypes();
			if(fieldMap.size() > 0 && entityMap.size() > 0 && fieldTypeMap.size() > 0)
			{
				
				this.fieldEntMapping.setFieldMap(fieldMap);
				this.fieldEntMapping.setEntityMap(entityMap);
				this.fieldEntMapping.setFieldTypeMap(fieldTypeMap);
				return INPUT;
			}
			else return ERROR;
				
		}
		
			else return ERROR;
		
	}
	
	public String getEntity() throws Exception {
		
		FieldEntityMappingService fieldEntityMappingService = new FieldEntityMappingService();
		HashMap<Integer, String> entityMap = fieldEntityMappingService.getEntities();
		if(entityMap.size() > 0 )
		{
				
			this.fieldEntMapping.setEntityMap(entityMap);
			
			return SUCCESS;
		}
		else return ERROR;
	}
	public String getFields() throws Exception
	{
		FieldEntityMappingService fieldEntityMappingService = new FieldEntityMappingService();
		fieldEntMapping.setFieldList(fieldEntityMappingService.getFieldMap(fieldEntMapping.getEntityId()));
		if(fieldEntMapping.getFieldList() != null && fieldEntMapping.getFieldList().size() > 0)
		{
			
			return SUCCESS;
		}
		else return ERROR;
	}
 
}
