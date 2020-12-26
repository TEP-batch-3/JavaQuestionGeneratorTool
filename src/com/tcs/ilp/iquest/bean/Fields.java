package com.tcs.ilp.iquest.bean;

import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

public class Fields {
	private int fieldId;
	private String title;
	private int fieldTypeID;
	private String fieldType;
	private boolean isPrimitive;
	private boolean isEntity;
	private int refEntityId;
	private String defaultValue;
	public int getFieldId() {
		return fieldId;
	}
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}
	@RequiredStringValidator(type = ValidatorType.FIELD,message = "The Field Name is required")
	@RegexFieldValidator( type = ValidatorType.FIELD, message="The Entity Name should be in camelcase with no special characters and numerics",regex="[a-z][a-z A-Z]+$")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getFieldTypeID() {
		return fieldTypeID;
	}
	public void setFieldTypeID(int fieldTypeID) {
		this.fieldTypeID = fieldTypeID;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public boolean isPrimitive() {
		return isPrimitive;
	}
	public void setPrimitive(boolean isPrimitive) {
		this.isPrimitive = isPrimitive;
	}
	public boolean isEntity() {
		return isEntity;
	}
	public void setEntity(boolean isEntity) {
		this.isEntity = isEntity;
	}
	public int getRefEntityId() {
		return refEntityId;
	}
	public void setRefEntityId(int refEntityId) {
		this.refEntityId = refEntityId;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public Fields()
	{
	}
}