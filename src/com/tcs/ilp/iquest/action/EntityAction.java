package com.tcs.ilp.iquest.action;


import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import com.tcs.ilp.iquest.bean.Entity;
import com.tcs.ilp.iquest.service.EntityService;
import com.tcs.ilp.iquest.service.FieldService;

public class EntityAction extends ActionSupport implements ModelDriven<Entity>,SessionAware{

	 Entity ent= new Entity();
	ArrayList<String> entityList = new ArrayList<String>();
	private SessionMap<String,Object> sessionMap;  
	public ArrayList<String> getEntityList() {
		return entityList;
	}

	public void setEntityList(ArrayList<String> entityList) {
		this.entityList = entityList;
	}

	@Override
	@VisitorFieldValidator(appendPrefix=false)
	public Entity getModel() {
		// TODO Auto-generated method stub
		return ent;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
		sessionMap=(SessionMap)arg0;  
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	
		EntityService entityServ = new EntityService();
		int count = entityServ.addEntity(ent.getTitle());
		if(count==1)
		{
			
			return SUCCESS;
		}
		else if(count==2)
		{
			return "CONSTRAINT";
		}
		else
			return ERROR;
		
	}
	
	@SkipValidation
	public String getEntities() throws Exception {
		EntityService entityServ = new EntityService();
		sessionMap.put("entityList", entityServ.getEntities());
		//setEntityList(entityServ.getEntities());
		return SUCCESS;
	}

}
