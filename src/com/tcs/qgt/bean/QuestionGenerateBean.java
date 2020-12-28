package com.tcs.qgt.bean;

import java.util.List;

public class QuestionGenerateBean {

	private static String entity;
	private static int entityid;
	private static int level;
	private static List<String> operation;
	private static int noOfQuestions;
	private static int publicTestCase;
	private static int privateTestCase;
	private static int level1checkcount;
	private static int level2checkcount;
	
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


	public int getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(int noOfQuestions) {
		QuestionGenerateBean.noOfQuestions = noOfQuestions;
	}

	public int getPublicTestCase() {
		return publicTestCase;
	}

	public void setPublicTestCase(int publicTestCase) {
		QuestionGenerateBean.publicTestCase = publicTestCase;
	}

	public int getPrivateTestCase() {
		return privateTestCase;
	}

	public void setPrivateTestCase(int privateTestCase) {
		QuestionGenerateBean.privateTestCase = privateTestCase;
	}

	public int getEntityid() {
		return entityid;
	}

	public void setEntityid(int entityid) {
		QuestionGenerateBean.entityid = entityid;
	}

	public List<String> getOperation() {
		return operation;
	}

	public void setOperation(List<String> operation) {
		QuestionGenerateBean.operation = operation;
	}

	public int getLevel1checkcount() {
		return level1checkcount;
	}

	public void setLevel1checkcount(int level1checkcount) {
		QuestionGenerateBean.level1checkcount = level1checkcount;
	}

	public int getLevel2checkcount() {
		return level2checkcount;
	}

	public void setLevel2checkcount(int level2checkcount) {
		QuestionGenerateBean.level2checkcount = level2checkcount;
	}
	
}
