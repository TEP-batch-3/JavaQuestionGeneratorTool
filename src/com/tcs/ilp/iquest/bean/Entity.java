package com.tcs.ilp.iquest.bean;


import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;


public class Entity {
	
private int entityId;

private String title;

public Entity()
{
	
}

public Entity(int entityId, String title) {
	super();
	this.entityId = entityId;
	this.title = title;
}

public int getEntityId() {
	return entityId;
}

public void setEntityId(int entityId) {
	this.entityId = entityId;
}

@RequiredStringValidator(type = ValidatorType.FIELD,message = "The Entity Name is required")
@RegexFieldValidator( type = ValidatorType.FIELD, message="The Entity Name should be in initCaps with no special characters and numerics",regex="[A-Z][a-z A-Z]+$")
public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}


}
