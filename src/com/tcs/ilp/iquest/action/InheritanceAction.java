package com.tcs.ilp.iquest.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tcs.ilp.iquest.bean.Entity;
import com.tcs.ilp.iquest.bean.Inheritance;
import com.tcs.ilp.iquest.service.InheritanceService;


public class InheritanceAction extends ActionSupport implements ModelDriven<Entity>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4362383637991537641L;
	
	Entity ent = new Entity();
	ArrayList<Entity> entityList = new ArrayList<Entity>();
	ArrayList<Inheritance> mappingList = new ArrayList<Inheritance>();
	public ArrayList<Inheritance> getMappingList() {
		return mappingList;
	}

	public void setMappingList(ArrayList<Inheritance> mappingList) {
		this.mappingList = mappingList;
	}

	int parentId;
	int childId;
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

	@Override
	public Entity getModel() {
		// TODO Auto-generated method stub
		return ent;
	}
	
	public String getEntities()
	{
		InheritanceService inhServ = new InheritanceService();
		setEntityList(inhServ.getEntityList());
		setMappingList(inhServ.getMappingList());
		return SUCCESS;
	}
	
	public String mapParentChild()
	{
		if(parentId == childId)
		{
			message = "Parent Entity and Child Entity cannot be the same";
		}
		else 
		{
			InheritanceService inhServ = new InheritanceService();
			int count = inhServ.mapParentChild(parentId, childId);
			if(count == 1)
				message = "Mapping is successful";
			else if(count == 2)
			{
				setEntityList(inhServ.getEntityList());
				setMappingList(inhServ.getMappingList());
				addFieldError("childId", "The Child Entity has already been mapped to another Parent Entity");
				//message = "The Child Entity has already been mapped to another Parent Entity";
				return INPUT;
			}
			else if(count == 0)
				message = "Sorry for the inconveninece. Please try again later";
		}
		
		return SUCCESS;
	}

	public ArrayList<Entity> getEntityList() {
		return entityList;
	}

	public void setEntityList(ArrayList<Entity> entityList) {
		this.entityList = entityList;
	}

}
