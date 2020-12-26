package com.tcs.ilp.iquest.bean;

import java.util.ArrayList;
import java.util.HashMap;

public class FieldEntityMapping {
	
	private int mappingId;
	private HashMap fieldMap;
	private int fieldId;
	private HashMap entityMap;
	private int entityId;
	private String mappingType;
	private HashMap fieldTypeMap;
	private int fieldType;
	private int isIdentity;
	private int isUnique;
	private String description;
	private ArrayList<EntityMapping> fieldList;
	public ArrayList<EntityMapping> getFieldList() {
		return fieldList;
	}
	public void setFieldList(ArrayList<EntityMapping> fieldList) {
		this.fieldList = fieldList;
	}
	public int getMappingId() {
		return mappingId;
	}
	public void setMappingId(int mappingId) {
		this.mappingId = mappingId;
	}
	public HashMap getFieldMap() {
		return fieldMap;
	}
	public void setFieldMap(HashMap fieldMap) {
		this.fieldMap = fieldMap;
	}
	public int getFieldId() {
		return fieldId;
	}
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}
	public HashMap getEntityMap() {
		return entityMap;
	}
	public void setEntityMap(HashMap entityMap) {
		this.entityMap = entityMap;
	}
	public int getEntityId() {
		return entityId;
	}
	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}
	public String getMappingType() {
		return mappingType;
	}
	public void setMappingType(String mappingType) {
		this.mappingType = mappingType;
	}
	public HashMap getFieldTypeMap() {
		return fieldTypeMap;
	}
	public void setFieldTypeMap(HashMap fieldTypeMap) {
		this.fieldTypeMap = fieldTypeMap;
	}
	public int getFieldType() {
		return fieldType;
	}
	public void setFieldType(int fieldType) {
		this.fieldType = fieldType;
	}
	public int getIsIdentity() {
		return isIdentity;
	}
	public void setIsIdentity(int isIdentity) {
		this.isIdentity = isIdentity;
	}
	public int getIsUnique() {
		return isUnique;
	}
	public void setIsUnique(int isUnique) {
		this.isUnique = isUnique;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "FieldEntityMapping [mappingId=" + mappingId + ", fieldMap="
				+ fieldMap + ", fieldId=" + fieldId + ", entityMap="
				+ entityMap + ", entityId=" + entityId + ", mappingType="
				+ mappingType + ", fieldTypeMap=" + fieldTypeMap
				+ ", fieldType=" + fieldType + ", isIdentity=" + isIdentity
				+ ", isUnique=" + isUnique + ", description=" + description
				+ "]";
	}
	

}
