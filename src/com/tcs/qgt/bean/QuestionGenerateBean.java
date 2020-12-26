package com.tcs.qgt.bean;

public class QuestionGenerateBean {

	private static String entity;
	private static int entityid;
	private static int level;
	private static String operation;
	private static int noOfQuestions;
	private static int publicTestCase;
	private static int privateTestCase;
	
	public  String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		QuestionGenerateBean.entity = entity;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		QuestionGenerateBean.level = level;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public int getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	public int getPublicTestCase() {
		return publicTestCase;
	}

	public void setPublicTestCase(int publicTestCase) {
		this.publicTestCase = publicTestCase;
	}

	public int getPrivateTestCase() {
		return privateTestCase;
	}

	public void setPrivateTestCase(int privateTestCase) {
		this.privateTestCase = privateTestCase;
	}

	public int getEntityid() {
		return entityid;
	}

	public void setEntityid(int entityid) {
		this.entityid = entityid;
	}
	
}
