package com.tcs.ilp.iquest.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.tcs.ilp.iquest.bean.Entity;
import com.tcs.ilp.iquest.bean.EntityMapping;
import com.tcs.ilp.iquest.dao.EntityDAO;
import com.tcs.ilp.iquest.dao.FieldEntityMappingDAO;

public class ArrayListQuestionGenerator extends QuestionGenerator {
	/*
	 * public Map<String, String> createTemplate(String concept, String source,
	 * int noOfQuestions,int difficultyLevel,String empId ) { Map<String,
	 * String> artifacts = new HashMap<String, String>(); int questionNo=0; if
	 * (noOfQuestions != 0) { FieldEntityMappingDAO mappingDAO = new
	 * FieldEntityMappingDAO();
	 * 
	 * HashMap<String, ArrayList<EntityMapping>> fieldMap = null; fieldMap =
	 * mappingDAO.getFieldMapping(); if (fieldMap != null && fieldMap.size() >
	 * 0) { ArrayList<EntityMapping> mapList = null; HashMap<String, String>
	 * idMap = new HashMap<String, String>(); HashMap<String, String> nonIdMap =
	 * new HashMap<String, String>(); ArrayList<String> questionList = new
	 * ArrayList<String>(); HashMap<String, String> fieldValue = new
	 * HashMap<String, String>(); String className = ""; for (Entry<String,
	 * ArrayList<EntityMapping>> entry : fieldMap.entrySet()) { className =
	 * entry.getKey(); mapList = entry.getValue();
	 * 
	 * StringBuilder question =new StringBuilder(); questionNo++;
	 * question.append("Create a class " + className +
	 * " with below attributes:"); question.append(System.lineSeparator());
	 * question.append(System.lineSeparator()); for (EntityMapping fields :
	 * mapList) { question.append(fields.getFieldType() + " - " +
	 * fields.getTitle()); question.append(System.lineSeparator());
	 * question.append(System.lineSeparator()); } question.append(
	 * "Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required."
	 * );
	 * 
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator()); question.
	 * append("Public class Solution is already created with main method.");
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator()); question.append(
	 * "Code inside main method should not be altered else your solution might be scored as zero."
	 * ); question.append(System.lineSeparator());
	 * question.append(System.lineSeparator()); question.
	 * append("You may copy the code from main method in eclipse to verify your implementation."
	 * ); question.append(System.lineSeparator());
	 * question.append(System.lineSeparator());
	 * question.append("Implement two static methods -" + " and " +
	 * "in Solution class.");
	 * 
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator());
	 * question.append("These methods should be called from the main method.");
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator());
	 * question.append("Consider below sample input and output:");
	 * 
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator());
	 * question.append("Sample Input:");
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator());
	 * question.append("Sample Output:");
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator());
	 * question.append("Sample Test Case  (Score 10):");
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator()); question.append("Input");
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator()); question.append("Output");
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator());
	 * question.append("Sample Test Case  (Score 25):");
	 * 
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator()); question.append("Input");
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator()); question.append("Output");
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator());
	 * 
	 * question.append("Sample Test Case  (Score 30):");
	 * 
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator()); question.append("Input");
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator()); question.append("Output");
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator());
	 * 
	 * question.append("Sample Test Case  (Score 35):");
	 * 
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator()); question.append("Input");
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator()); question.append("Output");
	 * question.append(System.lineSeparator());
	 * question.append(System.lineSeparator());
	 * 
	 * question.append("SOLUTION:"); artifacts.put("QUESTION_"+empId,
	 * question.toString());
	 * createFile(source,question,className,questionNo,noOfQuestions,questionNo,
	 * concept,difficultyLevel); } }} return artifacts; }
	 */
	public Map<String, String> createTemplate(String concept, String source, int noOfQuestions, String empId,HashMap<String, ArrayList<EntityMapping>> fieldMap, ArrayList<EntityMapping> mapList,String methodName1, String methodDetails1, String methodName2, String methodDetails2,int loop) {
		Map<String, String> artifacts = new HashMap<String, String>();
		int questionNo = 0;
		if (noOfQuestions != 0) {
			FieldEntityMappingDAO mappingDAO = new FieldEntityMappingDAO();

			if (fieldMap != null && fieldMap.size() > 0) {
				// ArrayList<EntityMapping> mapList = null;
				HashMap<String, String> idMap = new HashMap<String, String>();
				HashMap<String, String> nonIdMap = new HashMap<String, String>();
				ArrayList<String> questionList = new ArrayList<String>();
				HashMap<String, String> fieldValue = new HashMap<String, String>();
				String className = "";
				for (Entry<String, ArrayList<EntityMapping>> entry : fieldMap.entrySet()) {
					className = entry.getKey();
					// mapList = entry.getValue();

					StringBuilder question = new StringBuilder();
					questionNo++;
					question.append("Create a class " + className + " with below attributes:");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					for (EntityMapping fields : mapList) {
						question.append(fields.getFieldType() + " - " + fields.getTitle());
						question.append(System.lineSeparator());
						question.append(System.lineSeparator());
					}
					question.append(
							"Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.");

					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("Public class Solution is already created with main method.");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append(
							"Code inside main method should not be altered else your solution might be scored as zero.");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("You may copy the code from main method in eclipse to verify your implementation.");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					
					//------------------------------------------ CHANGED BY SAYAN : START -------------------------------------------
					question.append("Implement two static methods - " + methodName1 + " and " + methodName2 + " in Solution class.");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append(methodName1);
					question.append(System.lineSeparator());
					question.append(methodDetails1);
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append(methodName2);
					question.append(System.lineSeparator());
					question.append(methodDetails2);
					//------------------------------------------ CHANGED BY SAYAN : END   -------------------------------------------

					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("These methods should be called from the main method.");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("Consider below sample input and output:");

					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("Sample Input:");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("Sample Output:");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("Sample Test Case  (Score 10):");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("Input");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("Output");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("Sample Test Case  (Score 25):");

					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("Input");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("Output");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());

					question.append("Sample Test Case  (Score 30):");

					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("Input");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("Output");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());

					question.append("Sample Test Case  (Score 35):");

					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("Input");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());
					question.append("Output");
					question.append(System.lineSeparator());
					question.append(System.lineSeparator());

					question.append("SOLUTION:");
					artifacts.put("QUESTION_" + empId, question.toString());
					// createFile(source,question,className,questionNo,noOfQuestions,questionNo,concept,difficultyLevel);
					
					//COMMENTED BY SAYAN FOR TESTING
					createFile(source, question, className, concept,loop);
				}
			}
		}
		return artifacts;
	}

	@Override
	//COMMENTED BY SAYAN FOR TESTING
	public Map<String, String> createQuestion(String concept, String source, int difficultyLevel, String empId,
			int noOfQuestionsToGenerate) {		
		Map<String, String> artifacts = new HashMap<String, String>();
	//	noOfQuestionsToGenerate = 50; // This will come from UI. Value should be > 0
	/*
	 * System.out.println(concept); System.out.println(source);
	 * System.out.println(difficultyLevel); System.out.println(empId);
	 * System.out.println(noOfQuestionsToGenerate);
	 */		int noOfQuestionsGenerated = 0;
		int totalPossibleQuestions = 0;
		ArrayList<String> questionList = new ArrayList<String>();

		EntityDAO entityDAO = new EntityDAO();
		ArrayList<Entity> entityList = entityDAO.getEntityList();
		System.out.println("Entity List Size : " + entityList.size());

		// get number of concepts for the entity from db
		// ArrayList<String> conceptList = new ArrayList<String>();
		concept = "Array"; // concept list for entity should be fetched from DB

		for (Entity entity : entityList) {
			if (concept.equalsIgnoreCase("Array")) {
				int totalNoOfPossibleMethods = 0;

				//if (noOfQuestionsGenerated < noOfQuestionsToGenerate) {   		//COMMENTED BY SAYAN : FIRST WE NEED TO CHECK IF N QUESTIONS CAN BE GENERATED
					FieldEntityMappingDAO mappingDAO = new FieldEntityMappingDAO();
					HashMap<String, ArrayList<EntityMapping>> fieldMap = null;
					int entityId = entity.getEntityId();
					fieldMap = mappingDAO.getFieldMapping(entityId);
					/* System.out.println(fieldMap); */
					if (fieldMap != null && fieldMap.size() > 0) {
						// count++;
						System.out.println("---------------------------" + entityId
								+ "-----------------------------------------------");
						System.out.println("Entity Name : " + entity.getTitle());
						ArrayList<EntityMapping> mapList = null;
						HashMap<String, String> idMap = new HashMap<String, String>();
						HashMap<String, String> nonIdMap = new HashMap<String, String>();

						HashMap<String, String> fieldValue = new HashMap<String, String>();
						String className = "";
						for (Entry<String, ArrayList<EntityMapping>> entry : fieldMap.entrySet()) {
							className = entry.getKey();
							mapList = entry.getValue();
						}

						// check all possible unique methods that can be
						// generated based on entity field mappings for this
						// entity
						for (int k = 0; k < mapList.size(); k++) {
							if ((mapList.get(k).getIsIdentity().equals("true"))
									&& (mapList.get(k).getMappingType().trim().equals("Regular"))) {
								// search by id field : one method
								idMap.put(mapList.get(k).getTitle(), mapList.get(k).getFieldType());
								totalNoOfPossibleMethods++;
							}
							if ((mapList.get(k).getIsIdentity().equals("false"))
									&& (mapList.get(k).getMappingType().trim().equals("Regular"))) {
								// search by non-id fields : n methods
								nonIdMap.put(mapList.get(k).getTitle(), mapList.get(k).getFieldType());
								totalNoOfPossibleMethods++;
							}
						}
						for (Entry<String, String> entry : idMap.entrySet()) {
							// replace method for id fields
							fieldValue.put(entry.getKey(), entry.getValue());
							totalNoOfPossibleMethods++;
						}
						for (int n = 0; n < mapList.size(); n++) {
							if (mapList.get(n).getMappingType().trim().equals("Regular")) {
								// sort method for all fields
								fieldValue.put(mapList.get(n).getTitle(), mapList.get(n).getFieldType());
								totalNoOfPossibleMethods++;
							}
						}

						// one method per entity : for odd position
						totalNoOfPossibleMethods++;

						// one method per entity : for even position
						totalNoOfPossibleMethods++;

						System.out
								.println("Total possible unique methods for this entity : " + totalNoOfPossibleMethods);

						int totalCombinations = 0;
						// calculating total no. of possible different
						// combinations for the above no. of unique methods for
						// this entity
						for (int i = 1; i <= totalNoOfPossibleMethods; i++)
							for (int j = i + 1; j <= totalNoOfPossibleMethods; j++) {
								totalCombinations++;
								// NOTE : THIS SAME INNER LOOP IS THE
								// PLACEHOLDER FOR IMPLEMENTING QUESTION
								// GENERATION LOGIC (template + methods +
								// solution + test cases)
								// generate question and add to questionList
								// increment generatedQuestions counter
								//artifacts = createTemplate(concept, source, noOfQuestionsToGenerate, empId, fieldMap,
								//		mapList);

							}
						totalPossibleQuestions = totalPossibleQuestions + totalCombinations;

						System.out.println(
								"Total unique questions that can be generated for this Entity : " + totalCombinations);
						System.out.println(
								"-----------------------------------------------------------------------------\n\n");
					} else {
						// entity doesn't have any field mapping. ignore this
						// entity
						System.out.println("========" + " Entity Id : " + entityId + ", Name : " + entity.getTitle()
								+ " - Does not have any fields " + "========\n");
					}
				//BELOW BLOCK IS COMMENTED BY SAYAN
				/*} else {
					return artifacts;
				}
				*/
			}
		}
		System.out.println("TOTAL POSSIBLE QUESTIONS FOR ALL ENTITIES : " + totalPossibleQuestions);
		
		//---------------------------------------------- ADDED BY SAYAN : START ----------------------------------------- 
		// CHECKING IF N QUESTIONS CAN BE GENERATED
		if(totalPossibleQuestions < noOfQuestionsToGenerate) {
			// N QUESTIONS CAN NOT BE GENERATED - ** return value can be changed to more meaningful type
			System.out.println("NOT possible to generate : " + noOfQuestionsToGenerate + " questions");
			System.out.println("Max no. of questions that can be generated = " + totalPossibleQuestions);
			
			return null;	
		}
		
		else {	// N QUESTIONS CAN BE GENERATED - CONTINUE WITH QUESTION GENERATION NOW
			
			for(Entity entity : entityList) {	
				if(concept.equalsIgnoreCase("Array")) {	
							//check all possible methods that can be generated based on entity fields 
							//and make two array lists one having method names and other having method details
							ArrayList<String> methodNameList = new ArrayList<String>();
							ArrayList<String> methodDetailsList = new ArrayList<String>();
							int totalNoOfPossibleMethods = 0;
							String method = null;
							
							if(noOfQuestionsGenerated < noOfQuestionsToGenerate) 
							{				
								FieldEntityMappingDAO mappingDAO = new FieldEntityMappingDAO();
								HashMap<String,ArrayList<EntityMapping>> fieldMap = null;
								int entityId = entity.getEntityId();
								fieldMap = mappingDAO.getFieldMapping(entityId);
								
								if(fieldMap != null && fieldMap.size() > 0)
								{
									//System.out.println(entity.getTitle());
									ArrayList<EntityMapping> mapList = null;
									HashMap<String,String> idMap = new HashMap<String,String>();
									HashMap<String,String> nonIdMap = new HashMap<String,String>();
									//ArrayList<String> questionList = new ArrayList<String>();
									HashMap<String,String> fieldValue= new HashMap<String,String>();
									String className = "";
									for (Entry<String, ArrayList<EntityMapping>> entry : fieldMap.entrySet()) {
										className = entry.getKey();
										mapList = entry.getValue();	   
									}
									
									//generate search method on identity or non-identity field
									for(int k=0; k < mapList.size() ;k++)
									{
										if((mapList.get(k).getIsIdentity().equals("true")) && (mapList.get(k).getMappingType().trim().equals("Regular")))
										{
											method = "search"+className+"By"+mapList.get(k).getTitle();
											idMap.put(mapList.get(k).getTitle(), mapList.get(k).getFieldType());
											questionList.add(method);
											methodNameList.add(method);
											methodDetailsList.add("Create a static method "+method+" in the "+className+"Demo class. " + 
													"This method will take array of "+className+" objects and "+mapList.get(k).getTitle()+" as input and returns the position of the "+
													className + " object having the " + mapList.get(k).getTitle()+" if found or -1 if not found.");
											totalNoOfPossibleMethods++;
										}
										if((mapList.get(k).getIsIdentity().equals("false")) && (mapList.get(k).getMappingType().trim().equals("Regular")))
										{
											method = "search"+className+"By"+mapList.get(k).getTitle();
											nonIdMap.put(mapList.get(k).getTitle(), mapList.get(k).getFieldType());
											questionList.add(method);
											methodNameList.add(method);
											methodDetailsList.add("Create a static method "+method+" in the "+className+"Demo class. " + 
													"This method will take array of "+className+" objects and "+mapList.get(k).getTitle()+" as input and returns new array of "+
													className+" objects for all values found with the given "+mapList.get(k).getTitle()+" else return null if not found.");
											totalNoOfPossibleMethods++;
										}
									}
									for (Entry<String, String> entry : idMap.entrySet()) {
											//questionList.add("replace"+entry.getKey()+"By"+entry.getKey()); 
											method = "replace"+className+"By"+entry.getKey();
											questionList.add(method); 
											
											fieldValue.put(entry.getKey(),entry.getValue());
											methodNameList.add(method);
											methodDetailsList.add("Create a static method "+method+" in the "+className+"Demo class. This method will take array of " + 
																className+" objects, one more "+className+" object and one " + entry.getKey() + " value as input. " + 
																"It will replace the "+className+" object having the input "+entry.getKey() + 
																" if found in the array and return true. Else return false");
											totalNoOfPossibleMethods++;	
									}				
									for(int n=0; n<mapList.size() ;n++)
									{
										if(mapList.get(n).getMappingType().trim().equals("Regular"))
										{
											method = "sort"+className+"By"+mapList.get(n).getTitle();
											questionList.add(method);
											fieldValue.put(mapList.get(n).getTitle(),mapList.get(n).getFieldType());
											methodNameList.add(method);
											methodDetailsList.add("Create a static method " + method + " in the " + className + "Demo class. " + 
															"This method will take array of " + className + " objects and sort the array based on " + 
															mapList.get(n).getTitle() + " attribute. The method will return the sorted array.");
											totalNoOfPossibleMethods++;	
										}
									}

									//one method for odd position
									method = "getOddPosition"+className;
									questionList.add(method);
									methodNameList.add(method);					 
									methodDetailsList.add("Create a static method "+method+" in the "+className+"Demo class.This method will take array of "+ 
														className+" objects. This method returns an array with all elements in odd position.");
									totalNoOfPossibleMethods++;	
									
									//one method for even position
									method = "getEvenPosition"+className;
									questionList.add(method);
									methodNameList.add(method);
									methodDetailsList.add("Create a static method "+method+" in the "+className+"Demo class.This method will take array of " + 
														className+" objects. This method returns an array with all elements in even position.");
									totalNoOfPossibleMethods++;	

									//System.out.println(totalNoOfPossibleMethods);
									int loop = 0;
									//generate the method combinations
									if(totalNoOfPossibleMethods>1) {
										for(int i=0; i<=(methodNameList.size()-1); i++)
											for(int j=i+1; j<=(methodNameList.size()-1); j++) {
												if(noOfQuestionsGenerated < noOfQuestionsToGenerate) {
													//genTemplate()
													//make call to gen methods --> generateMethods()
													System.out.println("------------ " + (noOfQuestionsGenerated+1) + " ------------");
													System.out.println(methodNameList.get(i));
													System.out.println(methodDetailsList.get(i));
													System.out.println();
													System.out.println(methodNameList.get(j));
													System.out.println(methodDetailsList.get(j));
													System.out.println("----------------------------\n");
													//SIGNATURE OF THE BELOW METHOD IS CHANGED BY SAYAN	
													//artifacts = createTemplate(concept, source, noOfQuestionsToGenerate, empId, fieldMap,mapList);
													System.out.println("========================== CREATING TEMPLATE ============================");
													loop++;
													artifacts = createTemplate(concept, source, noOfQuestionsToGenerate, empId, fieldMap, mapList, 
															methodNameList.get(i), methodDetailsList.get(i), methodNameList.get(j), methodDetailsList.get(j), loop);
													noOfQuestionsGenerated++;
												}
										}
									}
							}
								
							}
				}
			}
		}
		//---------------------------------------------- ADDED BY SAYAN : END ----------------------------------------- 
		
		return artifacts;		
	}

	@Override
	public Map<String, String> createQuestion(String concept, String source, int noOfQuestions, int questionNo,
			int entityId, int difficultyLevel, String empId, String flag) {
		try {
			StringBuilder question = null;
			RandomGenerator generator = new RandomGenerator();
			ArrayList<String> intVal = null;
			ArrayList<String> strVal = null;
			ArrayList<String> douVal = null;
			intVal = new ArrayList<String>();
			strVal = new ArrayList<String>();
			douVal = new ArrayList<String>();
			StringBuilder sourceFile = null;
			StringBuilder mainSB = new StringBuilder();
			/* Code for testcases start */
			ArrayList<String> intVal1 = new ArrayList<String>();
			;
			ArrayList<String> strVal1 = new ArrayList<String>();
			;
			ArrayList<String> douVal1 = new ArrayList<String>();
			;
			ArrayList<String> intVal2 = new ArrayList<String>();
			;
			ArrayList<String> strVal2 = new ArrayList<String>();
			;
			ArrayList<String> douVal2 = new ArrayList<String>();
			;
			StringBuilder testSB1 = new StringBuilder();
			StringBuilder testSB2 = new StringBuilder();
			/* Code for testcases end */
			StringBuilder mainSBCopy = new StringBuilder();
			/* Code for testcases start */
			StringBuilder testSB1Copy = new StringBuilder();
			StringBuilder testSB2Copy = new StringBuilder();
			Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
			Calendar cal = Calendar.getInstance();
			cal.setTime(today);

			int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
			int dayFlag = 0;

			if (dayOfMonth % 5 == 0) {
				dayFlag = 3;
			} else if (dayOfMonth % 5 == 4) {
				dayFlag = 2;
			} else {
				dayFlag = (dayOfMonth % 5) + 1;
			}

			/* Code for testcases end */
			StringBuilder constructorSB = new StringBuilder();
			StringBuilder firstQuestionFileSB = new StringBuilder();
			sourceFile = new StringBuilder();
			StringBuilder firstQuestionSB = new StringBuilder();
			OutputFileGenerator outputGenerator = new OutputFileGenerator();
			StringBuilder testSB1WithoutLogic = new StringBuilder();
			StringBuilder testSB2WithoutLogic = new StringBuilder();
			StringBuilder testSB1Output = new StringBuilder();
			StringBuilder testSB2Output = new StringBuilder();
			Map<String, String> artifacts = new HashMap<String, String>();

			if (noOfQuestions != 0) {
				FieldEntityMappingDAO mappingDAO = new FieldEntityMappingDAO();
				HashMap<String, ArrayList<EntityMapping>> fieldMap = null;
				if (entityId > 0)
					fieldMap = mappingDAO.getFieldMapping(entityId);
				else
					fieldMap = mappingDAO.getFieldMapping();
				if (fieldMap != null && fieldMap.size() > 0) {
					ArrayList<EntityMapping> mapList = null;
					HashMap<String, String> idMap = new HashMap<String, String>();
					HashMap<String, String> nonIdMap = new HashMap<String, String>();
					ArrayList<String> questionList = new ArrayList<String>();
					HashMap<String, String> fieldValue = new HashMap<String, String>();
					String className = "";
					for (Entry<String, ArrayList<EntityMapping>> entry : fieldMap.entrySet()) {
						className = entry.getKey();
						mapList = entry.getValue();
					}
					for (int i = 0; i < mapList.size(); i++) {
						if ((mapList.get(i).getIsIdentity().equals("true"))
								&& (mapList.get(i).getMappingType().trim().equals("Regular"))) {
							idMap.put(mapList.get(i).getTitle(), mapList.get(i).getFieldType());
							if (difficultyLevel == 1)
								questionList.add("search" + className + "By" + mapList.get(i).getTitle());
						}
						if ((mapList.get(i).getIsIdentity().equals("false"))
								&& (mapList.get(i).getMappingType().trim().equals("Regular")) && difficultyLevel == 3) {
							nonIdMap.put(mapList.get(i).getTitle(), mapList.get(i).getFieldType());
							questionList.add("search" + className + "By" + mapList.get(i).getTitle());
						}
					}
					for (Entry<String, String> entry : idMap.entrySet()) {
						if (difficultyLevel == 2)
							questionList.add("replace" + entry.getKey() + "By" + entry.getKey());

						fieldValue.put(entry.getKey(), entry.getValue());

					}
					for (int j = 0; j < mapList.size(); j++) {
						if (mapList.get(j).getMappingType().trim().equals("Regular") && difficultyLevel == 2) {
							questionList.add("sort" + className + "By" + mapList.get(j).getTitle());
							fieldValue.put(mapList.get(j).getTitle(), mapList.get(j).getFieldType());
						}
					}
					if (difficultyLevel == 3) {
						questionList.add("getOddPosition" + className);
						questionList.add("getEvenPosition" + className);
					}

					ArrayList randList = new ArrayList();
					int loopCount = 1;
					while (noOfQuestions > 0 && randList.size() < questionList.size()) {
						Random randomGenerator = new Random();

						for (int j = 0; j < questionList.size(); j++) {
							if (noOfQuestions > 0) {

								int randomInt = 0;
								if (entityId > 0)
									randomInt = j;
								else
									randomInt = randomGenerator.nextInt(questionList.size());
								if (randList.contains(randomInt))
									continue;
								else
									randList.add(randomInt);
								question = new StringBuilder();
								String method = (String) questionList.get(randomInt);
								String field = method.substring(method.indexOf("By") + 2);

								if (difficultyLevel == 3 && (method.contains("Odd") || method.contains("Even"))) {
									// question.append("Concept - "+concept+"
									// Difficulty Level 3");
								} else if (difficultyLevel == 1 && method.contains("search")
										&& idMap.containsKey(field)) {
									// question.append("Concept - "+concept+"
									// Difficulty Level 1");
								} else if (difficultyLevel == 3 && method.contains("search")
										&& !idMap.containsKey(field)) {
									// question.append("Concept - "+concept+"
									// Difficulty Level 3");
								} else if (difficultyLevel == 2
										&& (method.contains("replace") || method.contains("sort"))) {
									// question.append("Concept - "+concept+"
									// Difficulty Level 2");
								} else
									continue;

								if (concept.equals("Array")) {
									mainSB = new StringBuilder();
									/* Code for testcases start */
									testSB1 = new StringBuilder();
									testSB2 = new StringBuilder();
									/* Code for testcases end */
									sourceFile.append("package com;");
									sourceFile.append(System.lineSeparator());
									sourceFile.append("public class " + className + " {");
									sourceFile.append(System.lineSeparator());

									if (mainSB.length() > 2) {
										mainSB.setLength(0);
									}
									/* Code for testcases start */
									if (testSB1.length() > 2) {
										testSB1.setLength(0);
									}

									if (testSB2.length() > 2) {
										testSB2.setLength(0);
									}
									/* Code for testcases end */
									constructorSB.append("public " + className + "(");
									mainSB.append("package com;");
									mainSB.append(System.lineSeparator());
									mainSB.append("public class " + className + "Demo {");
									mainSB.append(System.lineSeparator());
									mainSB.append("public static void main(String args[]){");
									mainSB.append(System.lineSeparator());

									/* Code for testcases start */
									testSB1.append("package com;");
									testSB1.append(System.lineSeparator());
									testSB1.append("public class TestCase1{");
									testSB1.append(System.lineSeparator());
									testSB1.append("public static void main(String args[]){");
									testSB1.append(System.lineSeparator());
									testSB1.append(className + "Demo " + className.toLowerCase() + "Demo= new "
											+ className + "Demo();");
									testSB1.append(System.lineSeparator());
									testSB2.append("package com;");
									testSB2.append(System.lineSeparator());
									testSB2.append("public class TestCase2{");
									testSB2.append(System.lineSeparator());
									testSB2.append("public static void main(String args[]){");
									testSB2.append(System.lineSeparator());
									testSB2.append(className + "Demo " + className.toLowerCase() + "Demo= new "
											+ className + "Demo();");
									testSB2.append(System.lineSeparator());
									/* Code for testcases end */

									intVal.removeAll(intVal);
									strVal.removeAll(strVal);
									douVal.removeAll(douVal);

									intVal1.removeAll(intVal1);
									strVal1.removeAll(strVal1);
									douVal1.removeAll(douVal1);

									intVal2.removeAll(intVal2);
									strVal2.removeAll(strVal2);
									douVal2.removeAll(douVal2);

									for (int i = 0; i < 5; i++) {

										mainSB.append(className + " " + className.toLowerCase() + (i + 1) + "= new "
												+ className + "(");

										for (EntityMapping field1 : mapList) {
											if (i == 0) {
												sourceFile.append("private " + field1.getFieldType() + " "
														+ field1.getTitle() + "; \n");
												sourceFile.append(System.lineSeparator());
												constructorSB
														.append(field1.getFieldType() + " " + field1.getTitle() + " ,");

											}
											if (field1.getFieldType().equals("int")) {
												String val = generator.generateIntValue().toString();
												mainSB.append(Integer.parseInt(val) + ",");

												if (field1.getTitle().equalsIgnoreCase(field)) {

													intVal.add(val);
												}
											} else if (field1.getFieldType().equals("double")) {
												String val = generator.generateDoubleValue().toString();
												mainSB.append(Double.parseDouble(val) + ",");

												if (field1.getTitle().equalsIgnoreCase(field)) {

													douVal.add(val);
												}
											} else if (field1.getFieldType().equals("String")) {
												String val = generator.generateStringValue().toString();
												mainSB.append("\"" + val + "\"" + ",");

												if (field1.getTitle().equalsIgnoreCase(field)) {

													strVal.add(val);
												}

											}
										}

										mainSB.setLength(mainSB.length() - 1);
										mainSB.append(");");
										mainSB.append(System.lineSeparator());

									}
									// Code for testcases start
									List<Object> params1 = new ArrayList<Object>();
									List<Object> params2 = new ArrayList<Object>();

									for (int i = 0; i < 5; i++) {

										testSB1.append(className + " " + className.toLowerCase() + (i + 1) + "= new "
												+ className + "(");
										testSB2.append(className + " " + className.toLowerCase() + (i + 1) + "= new "
												+ className + "(");

										for (EntityMapping field1 : mapList) {
											if (i != dayFlag) {
												if (field1.getFieldType().equals("int")) {
													String val1 = generator.generateIntValue().toString();
													String val2 = generator.generateIntValue().toString();
													testSB1.append(Integer.parseInt(val1) + ",");
													testSB2.append(Integer.parseInt(val2) + ",");

													if (field1.getTitle().equalsIgnoreCase(field)) {

														intVal1.add(val1);
														intVal2.add(val2);

													}
													if (i == 0 && !field1.getIsIdentity().equals("true")) {
														params1.add(Integer.parseInt(val1));
														params2.add(Integer.parseInt(val2));
													}
												} else if (field1.getFieldType().equals("double")) {
													String val1 = generator.generateDoubleValue().toString();
													String val2 = generator.generateDoubleValue().toString();
													testSB1.append(Double.parseDouble(val1) + ",");
													testSB2.append(Double.parseDouble(val2) + ",");
													if (field1.getTitle().equalsIgnoreCase(field)) {

														douVal1.add(val1);
														douVal2.add(val2);

													}
													if (i == 0 && !field1.getIsIdentity().equals("true")) {
														params1.add(Double.parseDouble(val1));
														params2.add(Double.parseDouble(val2));
													}

												} else if (field1.getFieldType().equals("String")) {
													String val1 = generator.generateStringValue().toString();
													String val2 = generator.generateStringValue().toString();
													testSB1.append("\"" + val1 + "\"" + ",");
													testSB2.append("\"" + val2 + "\"" + ",");

													if (field1.getTitle().equalsIgnoreCase(field)) {

														strVal1.add(val1);
														strVal2.add(val2);

													}
													if (i == 0 && !field1.getIsIdentity().equals("true")) {
														params1.add(val1);
														params2.add(val2);
													}
												}

											} else {

												if (field1.getFieldType().equals("int")
														&& field1.getIsIdentity().equals("true")) {

													String val1 = generator.generateIntValue().toString();
													String val2 = generator.generateIntValue().toString();
													testSB1.append(Integer.parseInt(val1) + ",");
													testSB2.append(Integer.parseInt(val2) + ",");

													if (field1.getTitle().equalsIgnoreCase(field)) {

														intVal1.add(val1);
														intVal2.add(val2);

													}

												} else if (field1.getFieldType().equals("double")
														&& field1.getIsIdentity().equals("true")) {

													String val1 = generator.generateDoubleValue().toString();
													String val2 = generator.generateDoubleValue().toString();
													testSB1.append(Double.parseDouble(val1) + ",");
													testSB2.append(Double.parseDouble(val2) + ",");
													if (field1.getTitle().equalsIgnoreCase(field)) {

														douVal1.add(val1);
														douVal2.add(val2);

													}
												} else if (field1.getFieldType().equals("String")
														&& field1.getIsIdentity().equals("true")) {
													String val1 = generator.generateStringValue().toString();
													String val2 = generator.generateStringValue().toString();
													testSB1.append("\"" + val1 + "\"" + ",");
													testSB2.append("\"" + val2 + "\"" + ",");

													if (field1.getTitle().equalsIgnoreCase(field)) {

														strVal1.add(val1);
														strVal2.add(val2);

													}

												}

											}
										}

										if (i == dayFlag) {

											for (Object param : params1) {

												if (param instanceof Integer || param instanceof Double) {
													testSB1.append(param + ",");
												} else if (param instanceof String) {
													testSB1.append("\"" + param + "\"" + ",");
												}
											}

											for (Object param : params2) {
												if (param instanceof Integer || param instanceof Double) {
													testSB2.append(param + ",");
												} else if (param instanceof String) {
													testSB2.append("\"" + param + "\"" + ",");
												}
											}
										}
										testSB1.setLength(testSB1.length() - 1);
										testSB1.append(");");
										testSB1.append(System.lineSeparator());

										testSB2.setLength(testSB2.length() - 1);
										testSB2.append(");");
										testSB2.append(System.lineSeparator());
									}
									/* Code for testcases end */
									mainSBCopy.setLength(0);
									mainSBCopy.append(mainSB.toString());

									/* Code for testcases start */
									testSB1Copy.setLength(0);
									testSB1Copy.append(testSB1.toString());
									testSB2Copy.setLength(0);
									testSB2Copy.append(testSB2.toString());
									/* Code for testcases end */

									constructorSB.setLength(constructorSB.length() - 1);
									constructorSB.append(") " + " {");
									constructorSB.append(System.lineSeparator());
									constructorSB.append("super();");
									constructorSB.append(System.lineSeparator());
									for (EntityMapping field1 : mapList) {

										// For Generating Getter
										sourceFile.append(System.lineSeparator());
										sourceFile.append("public " + field1.getFieldType() + " get"
												+ field1.getTitle().substring(0, 1).toUpperCase()
												+ field1.getTitle().substring(1) + "() {");
										sourceFile.append(System.lineSeparator());
										sourceFile.append(" return " + field1.getTitle() + "; \n");
										sourceFile.append("}");

										// For Generating Setter
										sourceFile.append(System.lineSeparator());
										sourceFile.append(
												"public void" + " set" + field1.getTitle().substring(0, 1).toUpperCase()
														+ field1.getTitle().substring(1) + "(" + field1.getFieldType()
														+ " " + field1.getTitle() + ")" + "{");
										sourceFile.append(System.lineSeparator());
										sourceFile.append(
												" this." + field1.getTitle() + "=" + field1.getTitle() + "; \n");
										sourceFile.append("}");
										sourceFile.append(System.lineSeparator());
										// For Generating Constructor
										constructorSB.append(
												" this." + field1.getTitle() + "=" + field1.getTitle() + "; \n");
										constructorSB.append(System.lineSeparator());

									}
									constructorSB.append("}");

									sourceFile.append(constructorSB.toString());
									sourceFile.append(System.lineSeparator());
									sourceFile.append(System.lineSeparator());

								}
								question.append("Create package com");
								question.append(System.lineSeparator());
								question.append("Create a class " + className + " with below attributes:");
								question.append(System.lineSeparator());
								question.append(System.lineSeparator());
								for (EntityMapping fields : mapList) {
									question.append(fields.getFieldType() + " - " + fields.getTitle());
									question.append(System.lineSeparator());
									question.append(System.lineSeparator());
								}
								question.append(
										"Make all the attributes private.Create corresponding getters and setters.");
								question.append(System.lineSeparator());
								question.append(System.lineSeparator());
								question.append(
										"Create a constructor which takes all parameters in the above sequence. The constructor should set the value of attributes to parameter values inside the constructor.");
								question.append(System.lineSeparator());
								question.append(System.lineSeparator());
								question.append("Create a class " + className + "Demo with main method");
								question.append(System.lineSeparator());
								question.append(System.lineSeparator());

								if (method.contains("Odd") && difficultyLevel == 3) {
									if (concept.equals("Array")) {
										question.append("Create a static method " + method + " in the " + className
												+ "Demo class.This method will take array of " + className
												+ " objects. This method returns an array with all elements in odd position.");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("public static " + className + "[] " + method + "("
												+ className + "[] objArray){");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("int count=0;");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("int index=0;");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("for(int i=0;i<objArray.length;i++){");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("if (i%2!=0){");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("count++;}");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("}");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("if(count==0){");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("return null;}");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB
												.append(className + "[] resultArray=new " + className + "[count];");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("for(int i=0;i<objArray.length;i++){");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("if (i%2!=0){");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("resultArray[index]=objArray[i];");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("index++;}");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("}");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("return resultArray;");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("}");
										mainSB.append(System.lineSeparator());
										mainSB.append(System.lineSeparator());
										mainSB.append(className + "[] objArray= {" + className.toLowerCase() + "1,"
												+ className.toLowerCase() + "2," + className.toLowerCase() + "3,"
												+ className.toLowerCase() + "4," + className.toLowerCase() + "5};");
										mainSB.append(System.lineSeparator());
										mainSB.append(System.lineSeparator());
										mainSB.append(className + "[] objResultArray1= " + method + "(objArray);");
										mainSB.append(System.lineSeparator());
										mainSB.append("if(objResultArray1==null){");
										mainSB.append(System.lineSeparator());
										mainSB.append(
												"System.out.println(\"Output after first operation is null. \");");
										mainSB.append(System.lineSeparator());
										mainSB.append("}else{");
										mainSB.append(System.lineSeparator());
										mainSB.append("System.out.println(\"Displaying contents of result array: \");");
										mainSB.append(System.lineSeparator());
										mainSB.append(System.lineSeparator());
										mainSB.append("for(" + className + " " + className.toLowerCase()
												+ ":objResultArray1){");
										mainSB.append(System.lineSeparator());
										mainSB.append("System.out.println(");

										/* Code for testcases start */
										testSB1.append(System.lineSeparator());
										testSB1.append(System.lineSeparator());
										testSB1.append(className + "[] objArray= {" + className.toLowerCase() + "1,"
												+ className.toLowerCase() + "2," + className.toLowerCase() + "3,"
												+ className.toLowerCase() + "4," + className.toLowerCase() + "5};");
										testSB1.append(System.lineSeparator());
										testSB1.append(System.lineSeparator());
										testSB1.append(className + "[] objResultArray1= " + className.toLowerCase()
												+ "Demo." + method + "(objArray);");
										testSB1.append(System.lineSeparator());
										testSB1.append("if(objResultArray1==null){");
										testSB1.append(System.lineSeparator());
										testSB1.append(
												"System.out.println(\"Output after first operation is null. \");");
										testSB1.append(System.lineSeparator());
										testSB1.append("}else{");
										testSB1.append(System.lineSeparator());
										testSB1.append(
												"System.out.println(\"Displaying contents of result array: \");");
										testSB1.append(System.lineSeparator());
										testSB1.append(System.lineSeparator());
										testSB1.append("for(" + className + " " + className.toLowerCase()
												+ ":objResultArray1){");
										testSB1.append(System.lineSeparator());
										testSB1.append("System.out.println(");

										testSB2.append(System.lineSeparator());
										testSB2.append(System.lineSeparator());
										testSB2.append(className + "[] objArray= {" + className.toLowerCase() + "1,"
												+ className.toLowerCase() + "2," + className.toLowerCase() + "3,"
												+ className.toLowerCase() + "4," + className.toLowerCase() + "5};");
										testSB2.append(System.lineSeparator());
										testSB2.append(System.lineSeparator());
										testSB2.append(className + "[] objResultArray1= " + className.toLowerCase()
												+ "Demo." + method + "(objArray);");
										testSB2.append(System.lineSeparator());
										testSB2.append("if(objResultArray1==null){");
										testSB2.append(System.lineSeparator());
										testSB2.append(
												"System.out.println(\"Output after first operation is null. \");");
										testSB2.append(System.lineSeparator());
										testSB2.append("}else{");
										testSB2.append(System.lineSeparator());
										testSB2.append(
												"System.out.println(\"Displaying contents of result array: \");");
										testSB2.append(System.lineSeparator());
										testSB2.append(System.lineSeparator());
										testSB2.append("for(" + className + " " + className.toLowerCase()
												+ ":objResultArray1){");
										testSB2.append(System.lineSeparator());
										testSB2.append("System.out.println(");
										/* Code for testcases end */

										int chk = 0;
										for (EntityMapping field1 : mapList) {
											if (chk == 0) {
												mainSB.append(className.toLowerCase() + ".get"
														+ field1.getTitle().substring(0, 1).toUpperCase()
														+ field1.getTitle().substring(1) + "()+\" \"");
												/* Code for testcases start */
												testSB1.append(className.toLowerCase() + ".get"
														+ field1.getTitle().substring(0, 1).toUpperCase()
														+ field1.getTitle().substring(1) + "()+\" \"");
												testSB2.append(className.toLowerCase() + ".get"
														+ field1.getTitle().substring(0, 1).toUpperCase()
														+ field1.getTitle().substring(1) + "()+\" \"");
												/* Code for testcases end */
											} else {
												mainSB.append(" + " + className.toLowerCase() + ".get"
														+ field1.getTitle().substring(0, 1).toUpperCase()
														+ field1.getTitle().substring(1) + "()+\" \"");
												/* Code for testcases start */
												testSB1.append(" + " + className.toLowerCase() + ".get"
														+ field1.getTitle().substring(0, 1).toUpperCase()
														+ field1.getTitle().substring(1) + "()+\" \"");
												testSB2.append(" + " + className.toLowerCase() + ".get"
														+ field1.getTitle().substring(0, 1).toUpperCase()
														+ field1.getTitle().substring(1) + "()+\" \"");
												/* Code for testcases end */
											}
											chk++;
										}

										mainSB.append(");");
										mainSB.append(System.lineSeparator());
										mainSB.append("}");
										mainSB.append(System.lineSeparator());
										mainSB.append("}");
										mainSB.append(System.lineSeparator());

										/* Code for testcases start */
										testSB1.append(");");
										testSB1.append(System.lineSeparator());
										testSB1.append("}");
										testSB1.append(System.lineSeparator());
										testSB1.append("}");
										testSB1.append(System.lineSeparator());

										testSB2.append(");");
										testSB2.append(System.lineSeparator());
										testSB2.append("}");
										testSB2.append(System.lineSeparator());
										testSB2.append("}");
										testSB2.append(System.lineSeparator());
										/* Code for testcases end */

									} else

										question.append("Create a static method " + method + " in the " + className
												+ "Demo class.This method will take Array List of " + className
												+ " objects. This method returns an Array List with all elements in odd position.");

								}
								if (method.contains("Even") && difficultyLevel == 3) {
									if (concept.equals("Array")) {
										question.append("Create a static method " + method + " in the " + className
												+ "Demo class.This method will take array of " + className
												+ " objects. This method returns an array with all elements in even position.");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("public static " + className + "[] " + method + "("
												+ className + "[] objArray){");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("int count=0;");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("int index=0;");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("for(int i=0;i<objArray.length;i++){");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("if (i%2==0){");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("count++;}");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("}");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("if(count==0){");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("return null;}");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB
												.append(className + "[] resultArray=new " + className + "[count];");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("for(int i=0;i<objArray.length;i++){");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("if (i%2==0){");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("resultArray[index]=objArray[i];");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("index++;}");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("}");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("return resultArray;");
										firstQuestionSB.append(System.lineSeparator());
										firstQuestionSB.append("}");
										mainSB.append(System.lineSeparator());
										mainSB.append(System.lineSeparator());
										mainSB.append(className + "[] objArray= {" + className.toLowerCase() + "1,"
												+ className.toLowerCase() + "2," + className.toLowerCase() + "3,"
												+ className.toLowerCase() + "4," + className.toLowerCase() + "5};");
										mainSB.append(System.lineSeparator());
										mainSB.append(System.lineSeparator());
										mainSB.append(className + "[] objResultArray1= " + method + "(objArray);");
										mainSB.append(System.lineSeparator());
										mainSB.append("if(objResultArray1==null){");
										mainSB.append(System.lineSeparator());
										mainSB.append(
												"System.out.println(\"Output after first operation is null. \");");
										mainSB.append(System.lineSeparator());
										mainSB.append("}else{");
										mainSB.append(System.lineSeparator());
										mainSB.append("System.out.println(\"Displaying contents of result array: \");");
										mainSB.append(System.lineSeparator());
										mainSB.append(System.lineSeparator());
										mainSB.append("for(" + className + " " + className.toLowerCase()
												+ ":objResultArray1){");
										mainSB.append(System.lineSeparator());
										mainSB.append("System.out.println(");

										/* Code for testcases start */
										testSB1.append(System.lineSeparator());
										testSB1.append(System.lineSeparator());
										testSB1.append(className + "[] objArray= {" + className.toLowerCase() + "1,"
												+ className.toLowerCase() + "2," + className.toLowerCase() + "3,"
												+ className.toLowerCase() + "4," + className.toLowerCase() + "5};");
										testSB1.append(System.lineSeparator());
										testSB1.append(System.lineSeparator());
										testSB1.append(className + "[] objResultArray1= " + className.toLowerCase()
												+ "Demo." + method + "(objArray);");
										testSB1.append(System.lineSeparator());
										testSB1.append("if(objResultArray1==null){");
										testSB1.append(System.lineSeparator());
										testSB1.append(
												"System.out.println(\"Output after first operation is null. \");");
										testSB1.append(System.lineSeparator());
										testSB1.append("}else{");
										testSB1.append(System.lineSeparator());
										testSB1.append(
												"System.out.println(\"Displaying contents of result array: \");");
										testSB1.append(System.lineSeparator());
										testSB1.append(System.lineSeparator());
										testSB1.append("for(" + className + " " + className.toLowerCase()
												+ ":objResultArray1){");
										testSB1.append(System.lineSeparator());
										testSB1.append("System.out.println(");

										testSB2.append(System.lineSeparator());
										testSB2.append(System.lineSeparator());
										testSB2.append(className + "[] objArray= {" + className.toLowerCase() + "1,"
												+ className.toLowerCase() + "2," + className.toLowerCase() + "3,"
												+ className.toLowerCase() + "4," + className.toLowerCase() + "5};");
										testSB2.append(System.lineSeparator());
										testSB2.append(System.lineSeparator());
										testSB2.append(className + "[] objResultArray1= " + className.toLowerCase()
												+ "Demo." + method + "(objArray);");
										testSB2.append(System.lineSeparator());
										testSB2.append("if(objResultArray1==null){");
										testSB2.append(System.lineSeparator());
										testSB2.append(
												"System.out.println(\"Output after first operation is null. \");");
										testSB2.append(System.lineSeparator());
										testSB2.append("}else{");
										testSB2.append(System.lineSeparator());
										testSB2.append(
												"System.out.println(\"Displaying contents of result array: \");");
										testSB2.append(System.lineSeparator());
										testSB2.append(System.lineSeparator());
										testSB2.append("for(" + className + " " + className.toLowerCase()
												+ ":objResultArray1){");
										testSB2.append(System.lineSeparator());
										testSB2.append("System.out.println(");
										/* Code for testcases end */

										int chk = 0;
										for (EntityMapping field1 : mapList) {
											if (chk == 0) {
												mainSB.append(className.toLowerCase() + ".get"
														+ field1.getTitle().substring(0, 1).toUpperCase()
														+ field1.getTitle().substring(1) + "()+\" \"");
												/* Code for testcases start */
												testSB1.append(className.toLowerCase() + ".get"
														+ field1.getTitle().substring(0, 1).toUpperCase()
														+ field1.getTitle().substring(1) + "()+\" \"");
												testSB2.append(className.toLowerCase() + ".get"
														+ field1.getTitle().substring(0, 1).toUpperCase()
														+ field1.getTitle().substring(1) + "()+\" \"");
												/* Code for testcases end */
											} else {
												mainSB.append(" + " + className.toLowerCase() + ".get"
														+ field1.getTitle().substring(0, 1).toUpperCase()
														+ field1.getTitle().substring(1) + "()+\" \"");
												/* Code for testcases start */
												testSB1.append(" + " + className.toLowerCase() + ".get"
														+ field1.getTitle().substring(0, 1).toUpperCase()
														+ field1.getTitle().substring(1) + "()+\" \"");
												testSB2.append(" + " + className.toLowerCase() + ".get"
														+ field1.getTitle().substring(0, 1).toUpperCase()
														+ field1.getTitle().substring(1) + "()+\" \"");
												/* Code for testcases end */
											}
											chk++;
										}

										mainSB.append(");");
										mainSB.append(System.lineSeparator());
										mainSB.append("}");
										mainSB.append(System.lineSeparator());
										mainSB.append("}");
										mainSB.append(System.lineSeparator());
										/* Code for testcases start */
										testSB1.append(");");
										testSB1.append(System.lineSeparator());
										testSB1.append("}");
										testSB1.append(System.lineSeparator());
										testSB1.append("}");
										testSB1.append(System.lineSeparator());

										testSB2.append(");");
										testSB2.append(System.lineSeparator());
										testSB2.append("}");
										testSB2.append(System.lineSeparator());
										testSB2.append("}");
										testSB2.append(System.lineSeparator());
										/* Code for testcases end */
									} else
										question.append("Create a static method " + method + " in the " + className
												+ "Demo class.This method will take Array List of " + className
												+ " objects. This method returns an Array List  with all elements in even position.");

								} else {
									if (method.contains("search")) {
										method = "search" + className + "By" + field.substring(0, 1).toUpperCase()
												+ field.substring(1);
										question.append("Create the below static method " + method + " in the "
												+ className + "Demo class.");
										question.append(System.lineSeparator());
										question.append(System.lineSeparator());
										if (idMap.containsKey(field) && difficultyLevel == 1) {
											if (concept.equals("Array")) {
												question.append("" + method + "(" + className + "[] objArray)");

												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("public static int " + method + "(" + className
														+ "[] objArray,  " + mapList.get(0).getFieldType() + " "
														+ field.substring(0, 1) + field.substring(1) + "){");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("for(int i=0;i<objArray.length;i++){");
												firstQuestionSB.append(System.lineSeparator());

												if (mapList.get(0).getFieldType().equals("String")) {
													firstQuestionSB.append("if (objArray[i].get"
															+ field.substring(0, 1).toUpperCase() + field.substring(1)
															+ "().equalsIgnoreCase(" + field.substring(0, 1)
															+ field.substring(1) + ")){");
												} else {
													firstQuestionSB.append("if (objArray[i].get"
															+ field.substring(0, 1).toUpperCase() + field.substring(1)
															+ "()==" + field.substring(0, 1) + field.substring(1)
															+ "){");
												}

												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("return i;}");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("}");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("return -1;");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("}");
												mainSB.append(System.lineSeparator());
												mainSB.append(System.lineSeparator());
												mainSB.append(className + "[] objArray= {" + className.toLowerCase()
														+ "1," + className.toLowerCase() + "2,"
														+ className.toLowerCase() + "3," + className.toLowerCase()
														+ "4," + className.toLowerCase() + "5};");
												mainSB.append(System.lineSeparator());
												mainSB.append(System.lineSeparator());
												mainSB.append("int " + className.toLowerCase() + "res= " + method
														+ "(objArray, ");

												if (mapList.get(0).getFieldType().equals("int")) {
													mainSB.append(
															Integer.parseInt(generator.generateIntValue().toString())
																	+ ");");
												} else if (mapList.get(0).getFieldType().equals("double")) {
													mainSB.append(Double.parseDouble(
															generator.generateDoubleValue().toString()) + ");");
												} else if (mapList.get(0).getFieldType().equals("String")) {
													mainSB.append("\"" + generator.generateStringValue().toString()
															+ "\"" + ");");
												}

												mainSB.append(System.lineSeparator());
												mainSB.append("System.out.println(\"Output after first search: \"+"
														+ className.toLowerCase() + "res);");
												mainSB.append(System.lineSeparator());
												mainSB.append(System.lineSeparator());
												mainSB.append("int " + className.toLowerCase() + "res1= " + method
														+ "(objArray, ");

												if (mapList.get(0).getFieldType().equals("int")) {
													mainSB.append(
															intVal.get((int) (Math.random() * ((intVal.size() - 0))))
																	+ ");");
												} else if (mapList.get(0).getFieldType().equals("double")) {
													mainSB.append(
															douVal.get((int) (Math.random() * ((douVal.size() - 0))))
																	+ ");");
												} else if (mapList.get(0).getFieldType().equals("String")) {
													mainSB.append("\""
															+ strVal.get((int) (Math.random() * ((strVal.size() - 0))))
															+ "\"" + ");");
												}

												mainSB.append(System.lineSeparator());
												mainSB.append("System.out.println(\"Output after second search: \"+"
														+ className.toLowerCase() + "res1);");
												mainSB.append(System.lineSeparator());
												/* Code for testcases start */
												testSB1.append(System.lineSeparator());
												testSB1.append(System.lineSeparator());
												testSB1.append(className + "[] objArray= {" + className.toLowerCase()
														+ "1," + className.toLowerCase() + "2,"
														+ className.toLowerCase() + "3," + className.toLowerCase()
														+ "4," + className.toLowerCase() + "5};");
												testSB1.append(System.lineSeparator());
												testSB1.append(System.lineSeparator());
												testSB1.append("int " + className.toLowerCase() + "res= "
														+ className.toLowerCase() + "Demo." + method + "(objArray, ");

												if (mapList.get(0).getFieldType().equals("int")) {
													testSB1.append(
															Integer.parseInt(generator.generateIntValue().toString())
																	+ ");");
												} else if (mapList.get(0).getFieldType().equals("double")) {
													testSB1.append(Double.parseDouble(
															generator.generateDoubleValue().toString()) + ");");
												} else if (mapList.get(0).getFieldType().equals("String")) {
													testSB1.append("\"" + generator.generateStringValue().toString()
															+ "\"" + ");");
												}

												testSB1.append(System.lineSeparator());
												testSB1.append("System.out.println(\"Output after first search: \"+"
														+ className.toLowerCase() + "res);");
												testSB1.append(System.lineSeparator());
												testSB1.append(System.lineSeparator());
												testSB1.append("int " + className.toLowerCase() + "res1= "
														+ className.toLowerCase() + "Demo." + method + "(objArray, ");

												if (mapList.get(0).getFieldType().equals("int")) {
													testSB1.append(
															intVal1.get((int) (Math.random() * ((intVal1.size() - 0))))
																	+ ");");
												} else if (mapList.get(0).getFieldType().equals("double")) {
													testSB1.append(
															douVal1.get((int) (Math.random() * ((douVal1.size() - 0))))
																	+ ");");
												} else if (mapList.get(0).getFieldType().equals("String")) {
													testSB1.append("\""
															+ strVal1
																	.get((int) (Math.random() * ((strVal1.size() - 0))))
															+ "\"" + ");");
												}

												testSB1.append(System.lineSeparator());
												testSB1.append("System.out.println(\"Output after second search: \"+"
														+ className.toLowerCase() + "res1);");
												testSB1.append(System.lineSeparator());

												testSB2.append(System.lineSeparator());
												testSB2.append(System.lineSeparator());
												testSB2.append(className + "[] objArray= {" + className.toLowerCase()
														+ "1," + className.toLowerCase() + "2,"
														+ className.toLowerCase() + "3," + className.toLowerCase()
														+ "4," + className.toLowerCase() + "5};");
												testSB2.append(System.lineSeparator());
												testSB2.append(System.lineSeparator());
												testSB2.append("int " + className.toLowerCase() + "res= "
														+ className.toLowerCase() + "Demo." + method + "(objArray, ");

												if (mapList.get(0).getFieldType().equals("int")) {
													testSB2.append(
															Integer.parseInt(generator.generateIntValue().toString())
																	+ ");");
												} else if (mapList.get(0).getFieldType().equals("double")) {
													testSB2.append(Double.parseDouble(
															generator.generateDoubleValue().toString()) + ");");
												} else if (mapList.get(0).getFieldType().equals("String")) {
													testSB2.append("\"" + generator.generateStringValue().toString()
															+ "\"" + ");");
												}

												testSB2.append(System.lineSeparator());
												testSB2.append("System.out.println(\"Output after first search: \"+"
														+ className.toLowerCase() + "res);");
												testSB2.append(System.lineSeparator());
												testSB2.append(System.lineSeparator());
												testSB2.append("int " + className.toLowerCase() + "res1= "
														+ className.toLowerCase() + "Demo." + method + "(objArray, ");

												if (mapList.get(0).getFieldType().equals("int")) {
													testSB2.append(
															intVal2.get((int) (Math.random() * ((intVal2.size() - 0))))
																	+ ");");
												} else if (mapList.get(0).getFieldType().equals("double")) {
													testSB2.append(
															douVal2.get((int) (Math.random() * ((douVal2.size() - 0))))
																	+ ");");
												} else if (mapList.get(0).getFieldType().equals("String")) {
													testSB2.append("\""
															+ strVal2
																	.get((int) (Math.random() * ((strVal2.size() - 0))))
															+ "\"" + ");");
												}

												testSB2.append(System.lineSeparator());
												testSB2.append("System.out.println(\"Output after second search: \"+"
														+ className.toLowerCase() + "res1);");
												testSB2.append(System.lineSeparator());
												/* Code for testcases end */
											}

											else
												question.append("" + method + "(ArrayList<" + className + "> objList)");
											question.append(System.lineSeparator());
											question.append(System.lineSeparator());

											if (concept.equals("Array"))
												question.append(
														"This method will take array of " + className + " objects and "
																+ field + " as input and returns the position of the "
																+ field + " if found or -1 if not found.");
											else
												question.append("This method will take Array List of " + className
														+ " objects and " + field
														+ " as input and returns the position of the " + field
														+ " if found or -1 if not found.");
										} else if (difficultyLevel == 3) {
											if (concept.equals("Array")) {
												question.append("This method will take array of " + className
														+ " objects and " + field
														+ " as input and returns new array of " + className
														+ " objects for all values found with the given " + field
														+ " else return null if not found.");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("public static " + className + "[] " + method
														+ "(" + className + "[] objArray,  " + nonIdMap.get(field) + " "
														+ field.substring(0, 1) + field.substring(1) + "){");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("int count=0;");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("int index=0;");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("for(int i=0;i<objArray.length;i++){");
												firstQuestionSB.append(System.lineSeparator());

												if (nonIdMap.get(field).equals("String")) {
													firstQuestionSB.append("if (objArray[i].get"
															+ field.substring(0, 1).toUpperCase() + field.substring(1)
															+ "().equalsIgnoreCase(" + field.substring(0, 1)
															+ field.substring(1) + ")){");
												} else {
													firstQuestionSB.append("if (objArray[i].get"
															+ field.substring(0, 1).toUpperCase() + field.substring(1)
															+ "()==" + field.substring(0, 1) + field.substring(1)
															+ "){");
												}

												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("count++;}");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("}");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("if(count==0){");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("return null;}");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append(
														className + "[] resultArray=new " + className + "[count];");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("for(int i=0;i<objArray.length;i++){");
												firstQuestionSB.append(System.lineSeparator());
												if (nonIdMap.get(field).equals("String")) {
													firstQuestionSB.append("if (objArray[i].get"
															+ field.substring(0, 1).toUpperCase() + field.substring(1)
															+ "().equalsIgnoreCase(" + field.substring(0, 1)
															+ field.substring(1) + ")){");
												} else {
													firstQuestionSB.append("if (objArray[i].get"
															+ field.substring(0, 1).toUpperCase() + field.substring(1)
															+ "()==" + field.substring(0, 1) + field.substring(1)
															+ "){");
												}

												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("resultArray[index]=objArray[i];");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("index++;}");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("}");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("return resultArray;");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("}");
												mainSB.append(System.lineSeparator());
												mainSB.append(System.lineSeparator());
												mainSB.append(className + "[] objArray= {" + className.toLowerCase()
														+ "1," + className.toLowerCase() + "2,"
														+ className.toLowerCase() + "3," + className.toLowerCase()
														+ "4," + className.toLowerCase() + "5};");
												mainSB.append(System.lineSeparator());
												mainSB.append(System.lineSeparator());
												mainSB.append(
														className + "[] objResultArray1= " + method + "(objArray, ");// +field.substring(0,1)+field.substring(1)+");");

												if (nonIdMap.get(field).equals("int")) {
													mainSB.append(
															Integer.parseInt(generator.generateIntValue().toString())
																	+ ");");
												} else if (nonIdMap.get(field).equals("double")) {
													mainSB.append(Double.parseDouble(
															generator.generateDoubleValue().toString()) + ");");
												} else if (nonIdMap.get(field).equals("String")) {
													mainSB.append("\"" + generator.generateStringValue().toString()
															+ "\"" + ");");
												}

												mainSB.append(System.lineSeparator());
												mainSB.append("if(objResultArray1==null){");
												mainSB.append(System.lineSeparator());
												mainSB.append(
														"System.out.println(\"Output after first search is null. \");");
												mainSB.append(System.lineSeparator());
												mainSB.append("}else{");
												mainSB.append(System.lineSeparator());
												mainSB.append(
														"System.out.println(\"Displaying contents of result array: \");");
												mainSB.append(System.lineSeparator());
												mainSB.append(System.lineSeparator());
												mainSB.append("for(" + className + " " + className.toLowerCase()
														+ ":objResultArray1){");
												mainSB.append(System.lineSeparator());
												mainSB.append("System.out.println(");

												/* Code for testcases start */
												testSB1.append(System.lineSeparator());
												testSB1.append(System.lineSeparator());
												testSB1.append(className + "[] objArray= {" + className.toLowerCase()
														+ "1," + className.toLowerCase() + "2,"
														+ className.toLowerCase() + "3," + className.toLowerCase()
														+ "4," + className.toLowerCase() + "5};");
												testSB1.append(System.lineSeparator());
												testSB1.append(System.lineSeparator());
												testSB1.append(className + "[] objResultArray1= "
														+ className.toLowerCase() + "Demo." + method + "(objArray, ");// +field.substring(0,1)+field.substring(1)+");");

												if (nonIdMap.get(field).equals("int")) {
													testSB1.append(
															Integer.parseInt(generator.generateIntValue().toString())
																	+ ");");
												} else if (nonIdMap.get(field).equals("double")) {
													testSB1.append(Double.parseDouble(
															generator.generateDoubleValue().toString()) + ");");
												} else if (nonIdMap.get(field).equals("String")) {
													testSB1.append("\"" + generator.generateStringValue().toString()
															+ "\"" + ");");
												}

												testSB1.append(System.lineSeparator());
												testSB1.append("if(objResultArray1==null){");
												testSB1.append(System.lineSeparator());
												testSB1.append(
														"System.out.println(\"Output after first search is null. \");");
												testSB1.append(System.lineSeparator());
												testSB1.append("}else{");
												testSB1.append(System.lineSeparator());
												testSB1.append(
														"System.out.println(\"Displaying contents of result array: \");");
												testSB1.append(System.lineSeparator());
												testSB1.append(System.lineSeparator());
												testSB1.append("for(" + className + " " + className.toLowerCase()
														+ ":objResultArray1){");
												testSB1.append(System.lineSeparator());
												testSB1.append("System.out.println(");

												testSB2.append(System.lineSeparator());
												testSB2.append(System.lineSeparator());
												testSB2.append(className + "[] objArray= {" + className.toLowerCase()
														+ "1," + className.toLowerCase() + "2,"
														+ className.toLowerCase() + "3," + className.toLowerCase()
														+ "4," + className.toLowerCase() + "5};");
												testSB2.append(System.lineSeparator());
												testSB2.append(System.lineSeparator());
												testSB2.append(className + "[] objResultArray1= "
														+ className.toLowerCase() + "Demo." + method + "(objArray, ");// +field.substring(0,1)+field.substring(1)+");");

												if (nonIdMap.get(field).equals("int")) {
													testSB2.append(
															Integer.parseInt(generator.generateIntValue().toString())
																	+ ");");
												} else if (nonIdMap.get(field).equals("double")) {
													testSB2.append(Double.parseDouble(
															generator.generateDoubleValue().toString()) + ");");
												} else if (nonIdMap.get(field).equals("String")) {
													testSB2.append("\"" + generator.generateStringValue().toString()
															+ "\"" + ");");
												}

												testSB2.append(System.lineSeparator());
												testSB2.append("if(objResultArray1==null){");
												testSB2.append(System.lineSeparator());
												testSB2.append(
														"System.out.println(\"Output after first search is null. \");");
												testSB2.append(System.lineSeparator());
												testSB2.append("}else{");
												testSB2.append(System.lineSeparator());
												testSB2.append(
														"System.out.println(\"Displaying contents of result array: \");");
												testSB2.append(System.lineSeparator());
												testSB2.append(System.lineSeparator());
												testSB2.append("for(" + className + " " + className.toLowerCase()
														+ ":objResultArray1){");
												testSB2.append(System.lineSeparator());
												testSB2.append("System.out.println(");
												/* Code for testcases end */
												int chk = 0;
												for (EntityMapping field1 : mapList) {
													if (chk == 0) {
														mainSB.append(className.toLowerCase() + ".get"
																+ field1.getTitle().substring(0, 1).toUpperCase()
																+ field1.getTitle().substring(1) + "()+\" \"");
														/*
														 * Code for testcases
														 * start
														 */
														testSB1.append(className.toLowerCase() + ".get"
																+ field1.getTitle().substring(0, 1).toUpperCase()
																+ field1.getTitle().substring(1) + "()+\" \"");
														testSB2.append(className.toLowerCase() + ".get"
																+ field1.getTitle().substring(0, 1).toUpperCase()
																+ field1.getTitle().substring(1) + "()+\" \"");
														/*
														 * Code for testcases
														 * end
														 */
													} else {
														mainSB.append(" + " + className.toLowerCase() + ".get"
																+ field1.getTitle().substring(0, 1).toUpperCase()
																+ field1.getTitle().substring(1) + "()+\" \"");
														/*
														 * Code for testcases
														 * start
														 */
														testSB1.append(" + " + className.toLowerCase() + ".get"
																+ field1.getTitle().substring(0, 1).toUpperCase()
																+ field1.getTitle().substring(1) + "()+\" \"");
														testSB2.append(" + " + className.toLowerCase() + ".get"
																+ field1.getTitle().substring(0, 1).toUpperCase()
																+ field1.getTitle().substring(1) + "()+\" \"");
														/*
														 * Code for testcases
														 * end
														 */
													}
													chk++;
												}

												mainSB.append(");");
												mainSB.append(System.lineSeparator());
												mainSB.append("}");
												mainSB.append(System.lineSeparator());
												mainSB.append("}");
												mainSB.append(System.lineSeparator());

												mainSB.append(System.lineSeparator());
												mainSB.append(
														className + "[] objResultArray2= " + method + "(objArray, ");// +field.substring(0,1)+field.substring(1)+");");

												if (nonIdMap.get(field).equals("int")) {
													mainSB.append(
															intVal.get((int) (Math.random() * ((intVal.size() - 0))))
																	+ ");");
												} else if (nonIdMap.get(field).equals("double")) {
													mainSB.append(
															douVal.get((int) (Math.random() * ((douVal.size() - 0))))
																	+ ");");
												} else if (nonIdMap.get(field).equals("String")) {
													mainSB.append("\""
															+ strVal.get((int) (Math.random() * ((strVal.size() - 0))))
															+ "\"" + ");");
												}

												mainSB.append(System.lineSeparator());
												mainSB.append("if(objResultArray2==null){");
												mainSB.append(System.lineSeparator());
												mainSB.append(
														"System.out.println(\"Output after first search is null. \");");
												mainSB.append(System.lineSeparator());
												mainSB.append("}else{");
												mainSB.append(System.lineSeparator());
												mainSB.append(
														"System.out.println(\"Displaying contents of result array: \");");
												mainSB.append(System.lineSeparator());
												mainSB.append(System.lineSeparator());
												mainSB.append("for(" + className + " " + className.toLowerCase()
														+ ":objResultArray2){");
												mainSB.append(System.lineSeparator());
												mainSB.append("System.out.println(");

												/* Code for testcases start */
												testSB1.append(");");
												testSB1.append(System.lineSeparator());
												testSB1.append("}");
												testSB1.append(System.lineSeparator());
												testSB1.append("}");
												testSB1.append(System.lineSeparator());

												testSB1.append(System.lineSeparator());
												testSB1.append(className + "[] objResultArray2= "
														+ className.toLowerCase() + "Demo." + method + "(objArray, ");// +field.substring(0,1)+field.substring(1)+");");

												if (nonIdMap.get(field).equals("int")) {
													testSB1.append(intVal1.get(0) + ");");
												} else if (nonIdMap.get(field).equals("double")) {
													testSB1.append(douVal1.get(0) + ");");
												} else if (nonIdMap.get(field).equals("String")) {
													testSB1.append("\"" + strVal1.get(0) + "\"" + ");");
												}

												testSB1.append(System.lineSeparator());
												testSB1.append("if(objResultArray2==null){");
												testSB1.append(System.lineSeparator());
												testSB1.append(
														"System.out.println(\"Output after first search is null. \");");
												testSB1.append(System.lineSeparator());
												testSB1.append("}else{");
												testSB1.append(System.lineSeparator());
												testSB1.append(
														"System.out.println(\"Displaying contents of result array: \");");
												testSB1.append(System.lineSeparator());
												testSB1.append(System.lineSeparator());
												testSB1.append("for(" + className + " " + className.toLowerCase()
														+ ":objResultArray2){");
												testSB1.append(System.lineSeparator());
												testSB1.append("System.out.println(");

												testSB2.append(");");
												testSB2.append(System.lineSeparator());
												testSB2.append("}");
												testSB2.append(System.lineSeparator());
												testSB2.append("}");
												testSB2.append(System.lineSeparator());

												testSB2.append(System.lineSeparator());
												testSB2.append(className + "[] objResultArray2= "
														+ className.toLowerCase() + "Demo." + method + "(objArray, ");// +field.substring(0,1)+field.substring(1)+");");

												if (nonIdMap.get(field).equals("int")) {
													testSB2.append(intVal2.get(0) + ");");
												} else if (nonIdMap.get(field).equals("double")) {
													testSB2.append(douVal2.get(0) + ");");
												} else if (nonIdMap.get(field).equals("String")) {
													testSB2.append("\"" + strVal2.get(0) + "\"" + ");");
												}

												testSB2.append(System.lineSeparator());
												testSB2.append("if(objResultArray2==null){");
												testSB2.append(System.lineSeparator());
												testSB2.append(
														"System.out.println(\"Output after first search is null. \");");
												testSB2.append(System.lineSeparator());
												testSB2.append("}else{");
												testSB2.append(System.lineSeparator());
												testSB2.append(
														"System.out.println(\"Displaying contents of result array: \");");
												testSB2.append(System.lineSeparator());
												testSB2.append(System.lineSeparator());
												testSB2.append("for(" + className + " " + className.toLowerCase()
														+ ":objResultArray2){");
												testSB2.append(System.lineSeparator());
												testSB2.append("System.out.println(");
												/* Code for testcases end */
												chk = 0;
												for (EntityMapping field1 : mapList) {
													if (chk == 0) {
														mainSB.append(className.toLowerCase() + ".get"
																+ field1.getTitle().substring(0, 1).toUpperCase()
																+ field1.getTitle().substring(1) + "()+\" \"");
														/*
														 * Code for testcases
														 * start
														 */
														testSB1.append(className.toLowerCase() + ".get"
																+ field1.getTitle().substring(0, 1).toUpperCase()
																+ field1.getTitle().substring(1) + "()+\" \"");
														testSB2.append(className.toLowerCase() + ".get"
																+ field1.getTitle().substring(0, 1).toUpperCase()
																+ field1.getTitle().substring(1) + "()+\" \"");
														/*
														 * Code for testcases
														 * end
														 */
													} else {
														mainSB.append(" + " + className.toLowerCase() + ".get"
																+ field1.getTitle().substring(0, 1).toUpperCase()
																+ field1.getTitle().substring(1) + "()+\" \"");
														/*
														 * Code for testcases
														 * start
														 */
														testSB1.append(" + " + className.toLowerCase() + ".get"
																+ field1.getTitle().substring(0, 1).toUpperCase()
																+ field1.getTitle().substring(1) + "()+\" \"");
														testSB2.append(" + " + className.toLowerCase() + ".get"
																+ field1.getTitle().substring(0, 1).toUpperCase()
																+ field1.getTitle().substring(1) + "()+\" \"");
														/*
														 * Code for testcases
														 * end
														 */
													}
													chk++;
												}

												mainSB.append(");");
												mainSB.append(System.lineSeparator());
												mainSB.append("}");
												mainSB.append(System.lineSeparator());
												mainSB.append("}");
												mainSB.append(System.lineSeparator());

												/* Code for testcases start */
												testSB1.append(");");
												testSB1.append(System.lineSeparator());
												testSB1.append("}");
												testSB1.append(System.lineSeparator());
												testSB1.append("}");
												testSB1.append(System.lineSeparator());

												testSB2.append(");");
												testSB2.append(System.lineSeparator());
												testSB2.append("}");
												testSB2.append(System.lineSeparator());
												testSB2.append("}");
												testSB2.append(System.lineSeparator());
												/* Code for testcases end */
											} else
												question.append("This method will take Array List of " + className
														+ " objects and " + field
														+ " as input and returns new Array List of " + className
														+ " objects for all values found with the given " + field
														+ " else return null if not found.");
										}
									}
									if (method.contains("replace") && difficultyLevel == 2) {

										method = "replace" + className + "By" + field.substring(0, 1).toUpperCase()
												+ field.substring(1);
										if (concept.equals("Array")) {
											question.append("Create a static method " + method + " in the " + className
													+ "Demo class. This method will take array of " + className
													+ " objects and one " + className + " object as input. Replace the "
													+ className + " object with same " + field
													+ " if found in the array and return true. Else return false");
											mainSB.delete(0, mainSB.length());
											mainSB.append(mainSBCopy.toString());

											/* Code for testcases start */
											testSB1.delete(0, testSB1.length());
											testSB1.append(testSB1Copy.toString());
											testSB2.delete(0, testSB2.length());
											testSB2.append(testSB2Copy.toString());
											/* Code for testcases end */

											if (firstQuestionSB.length() > 2) {
												firstQuestionSB.delete(0, firstQuestionSB.length());
											}

											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("public static boolean " + method + "(" + className
													+ "[] objArray, " + className + " " + className.toLowerCase()
													+ "1){");
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("for(int i=0;i<objArray.length;i++){");
											firstQuestionSB.append(System.lineSeparator());

											if (fieldValue.get(field).equalsIgnoreCase("String")) {
												firstQuestionSB.append("if (objArray[i].get"
														+ field.substring(0, 1).toUpperCase() + field.substring(1)
														+ "().equalsIgnoreCase(" + className.toLowerCase() + "1.get"
														+ field.substring(0, 1).toUpperCase() + field.substring(1)
														+ "())){");
											} else {
												firstQuestionSB.append(
														"if (objArray[i].get" + field.substring(0, 1).toUpperCase()
																+ field.substring(1) + "()==" + className.toLowerCase()
																+ "1.get" + field.substring(0, 1).toUpperCase()
																+ field.substring(1) + "()){");
											}

											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("objArray[i] = " + className.toLowerCase() + "1;");
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("return true;");
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("}");
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("}");
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("return false;");
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("}");
											mainSB.append(System.lineSeparator());
											mainSB.append(System.lineSeparator());
											mainSB.append(className + "[] objArray= {" + className.toLowerCase() + "1,"
													+ className.toLowerCase() + "2," + className.toLowerCase() + "3,"
													+ className.toLowerCase() + "4," + className.toLowerCase() + "5};");
											mainSB.append(System.lineSeparator());
											mainSB.append(className + " " + className.toLowerCase() + "Res1= new "
													+ className + "(");
											/* Code for testcases start */
											testSB1.append(System.lineSeparator());
											testSB1.append(System.lineSeparator());
											testSB1.append(className + "[] objArray= {" + className.toLowerCase() + "1,"
													+ className.toLowerCase() + "2," + className.toLowerCase() + "3,"
													+ className.toLowerCase() + "4," + className.toLowerCase() + "5};");
											testSB1.append(System.lineSeparator());
											testSB1.append(className + " " + className.toLowerCase() + "Res1= new "
													+ className + "(");

											testSB2.append(System.lineSeparator());
											testSB2.append(System.lineSeparator());
											testSB2.append(className + "[] objArray= {" + className.toLowerCase() + "1,"
													+ className.toLowerCase() + "2," + className.toLowerCase() + "3,"
													+ className.toLowerCase() + "4," + className.toLowerCase() + "5};");
											testSB2.append(System.lineSeparator());
											testSB2.append(className + " " + className.toLowerCase() + "Res1= new "
													+ className + "(");
											/* Code for testcases end */
											for (EntityMapping field1 : mapList) {

												if (field1.getFieldType().equals("int")) {
													mainSB.append(
															Integer.parseInt(generator.generateIntValue().toString())
																	+ ",");
													/*
													 * Code for testcases start
													 */
													testSB1.append(
															Integer.parseInt(generator.generateIntValue().toString())
																	+ ",");
													testSB2.append(
															Integer.parseInt(generator.generateIntValue().toString())
																	+ ",");
													/* Code for testcases end */
												} else if (field1.getFieldType().equals("double")) {
													mainSB.append(Double.parseDouble(
															generator.generateDoubleValue().toString()) + ",");
													/*
													 * Code for testcases start
													 */
													testSB1.append(Double.parseDouble(
															generator.generateDoubleValue().toString()) + ",");
													testSB2.append(Double.parseDouble(
															generator.generateDoubleValue().toString()) + ",");
													/* Code for testcases end */
												} else if (field1.getFieldType().equals("String")) {

													mainSB.append("\"" + generator.generateStringValue().toString()
															+ "\"" + ",");
													/*
													 * Code for testcases start
													 */
													testSB1.append("\"" + generator.generateStringValue().toString()
															+ "\"" + ",");
													testSB2.append("\"" + generator.generateStringValue().toString()
															+ "\"" + ",");
													/* Code for testcases end */
												}

											}
											mainSB.setLength(mainSB.length() - 1);
											mainSB.append(");");
											mainSB.append(System.lineSeparator());
											mainSB.append(System.lineSeparator());
											mainSB.append("boolean result= " + method + "(objArray, "
													+ className.toLowerCase() + "Res1);");// +field.substring(0,1)+field.substring(1)+");");
											mainSB.append(System.lineSeparator());
											mainSB.append("System.out.println(\"Output for performing replace on "
													+ className.toLowerCase() + "Res1 is: \"+ result  );          ");
											mainSB.append(System.lineSeparator());
											mainSB.append(System.lineSeparator());
											mainSB.append("System.out.println(\"Displaying contents of array: \");");
											mainSB.append(System.lineSeparator());
											mainSB.append(System.lineSeparator());
											mainSB.append(
													"for(" + className + " " + className.toLowerCase() + ":objArray){");
											mainSB.append(System.lineSeparator());
											mainSB.append("System.out.println(");

											/* Code for testcases start */
											testSB1.setLength(testSB1.length() - 1);
											testSB1.append(");");
											testSB1.append(System.lineSeparator());
											testSB1.append(System.lineSeparator());
											testSB1.append("boolean result= " + className.toLowerCase() + "Demo."
													+ method + "(objArray, " + className.toLowerCase() + "Res1);");
											testSB1.append(System.lineSeparator());
											testSB1.append("System.out.println(\"Output for performing replace on "
													+ className.toLowerCase() + "Res1 is: \"+ result  );          ");
											testSB1.append(System.lineSeparator());
											testSB1.append(System.lineSeparator());
											testSB1.append("System.out.println(\"Displaying contents of array: \");");
											testSB1.append(System.lineSeparator());
											testSB1.append(System.lineSeparator());
											testSB1.append(
													"for(" + className + " " + className.toLowerCase() + ":objArray){");
											testSB1.append(System.lineSeparator());
											testSB1.append("System.out.println(");

											testSB2.setLength(testSB2.length() - 1);
											testSB2.append(");");
											testSB2.append(System.lineSeparator());
											testSB2.append(System.lineSeparator());
											testSB2.append("boolean result= " + className.toLowerCase() + "Demo."
													+ method + "(objArray, " + className.toLowerCase() + "Res1);");
											testSB2.append(System.lineSeparator());
											testSB2.append("System.out.println(\"Output for performing replace on "
													+ className.toLowerCase() + "Res1 is: \"+ result  );          ");
											testSB2.append(System.lineSeparator());
											testSB2.append(System.lineSeparator());
											testSB2.append("System.out.println(\"Displaying contents of array: \");");
											testSB2.append(System.lineSeparator());
											testSB2.append(System.lineSeparator());
											testSB2.append(
													"for(" + className + " " + className.toLowerCase() + ":objArray){");
											testSB2.append(System.lineSeparator());
											testSB2.append("System.out.println(");
											/* Code for testcases end */

											int chk = 0;
											for (EntityMapping field1 : mapList) {
												if (chk == 0) {
													mainSB.append(className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													/*
													 * Code for testcases start
													 */
													testSB1.append(className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													testSB2.append(className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													/* Code for testcases end */
												} else {
													mainSB.append(" + " + className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													/*
													 * Code for testcases start
													 */
													testSB1.append(" + " + className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													testSB2.append(" + " + className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													/* Code for testcases end */
												}
												chk++;
											}

											mainSB.append(");");
											mainSB.append(System.lineSeparator());
											mainSB.append("}");
											mainSB.append(System.lineSeparator());
											mainSB.append("System.out.println();");
											mainSB.append(System.lineSeparator());
											mainSB.append(System.lineSeparator());
											mainSB.append(className + " " + className.toLowerCase() + "Res2= new "
													+ className + "(");

											/* Code for testcases start */

											testSB1.append(");");
											testSB1.append(System.lineSeparator());
											testSB1.append("}");
											testSB1.append(System.lineSeparator());
											testSB1.append("System.out.println();");
											testSB1.append(System.lineSeparator());
											testSB1.append(System.lineSeparator());
											testSB1.append(className + " " + className.toLowerCase() + "Res2= new "
													+ className + "(");

											testSB2.append(");");
											testSB2.append(System.lineSeparator());
											testSB2.append("}");
											testSB2.append(System.lineSeparator());
											testSB2.append("System.out.println();");
											testSB2.append(System.lineSeparator());
											testSB2.append(System.lineSeparator());
											testSB2.append(className + " " + className.toLowerCase() + "Res2= new "
													+ className + "(");
											/* Code for testcases end */
											for (EntityMapping field1 : mapList) {

												if (field1.getFieldType().equals("int")) {
													if (field1.getTitle().equalsIgnoreCase(field)) {
														mainSB.append(intVal.get(
																(int) (Math.random() * ((intVal.size() - 0)))) + ",");
														/*
														 * Code for testcases
														 * start
														 */
														testSB1.append(intVal1.get(
																(int) (Math.random() * ((intVal1.size() - 0)))) + ",");
														testSB2.append(intVal2.get(
																(int) (Math.random() * ((intVal2.size() - 0)))) + ",");
														/*
														 * Code for testcases
														 * end
														 */
													} else {
														mainSB.append(Integer.parseInt(
																generator.generateIntValue().toString()) + ",");
														/*
														 * Code for testcases
														 * start
														 */
														testSB1.append(Integer.parseInt(
																generator.generateIntValue().toString()) + ",");
														testSB2.append(Integer.parseInt(
																generator.generateIntValue().toString()) + ",");
														/*
														 * Code for testcases
														 * end
														 */
													}
												} else if (field1.getFieldType().equals("double")) {
													if (field1.getTitle().equalsIgnoreCase(field)) {
														mainSB.append(douVal.get(
																(int) (Math.random() * ((douVal.size() - 0)))) + ",");

														/*
														 * Code for testcases
														 * start
														 */
														testSB1.append(douVal1.get(
																(int) (Math.random() * ((douVal1.size() - 0)))) + ",");
														testSB2.append(douVal2.get(
																(int) (Math.random() * ((douVal2.size() - 0)))) + ",");
														/*
														 * Code for testcases
														 * end
														 */

													} else {

														mainSB.append(Double.parseDouble(
																generator.generateDoubleValue().toString()) + ",");
														/*
														 * Code for testcases
														 * start
														 */
														testSB1.append(Double.parseDouble(
																generator.generateDoubleValue().toString()) + ",");
														testSB2.append(Double.parseDouble(
																generator.generateDoubleValue().toString()) + ",");
														/*
														 * Code for testcases
														 * end
														 */
													}
												} else if (field1.getFieldType().equals("String")) {
													if (field1.getTitle().equalsIgnoreCase(field)) {
														mainSB.append("\""
																+ strVal.get(
																		(int) (Math.random() * ((strVal.size() - 0))))
																+ "\"" + ",");
														/*
														 * Code for testcases
														 * start
														 */
														testSB1.append("\""
																+ strVal1.get(
																		(int) (Math.random() * ((strVal1.size() - 0))))
																+ "\"" + ",");
														testSB2.append("\""
																+ strVal2.get(
																		(int) (Math.random() * ((strVal2.size() - 0))))
																+ "\"" + ",");
														/*
														 * Code for testcases
														 * end
														 */
													} else {
														mainSB.append("\"" + generator.generateStringValue().toString()
																+ "\"" + ",");
														/*
														 * Code for testcases
														 * start
														 */
														testSB1.append("\"" + generator.generateStringValue().toString()
																+ "\"" + ",");
														testSB2.append("\"" + generator.generateStringValue().toString()
																+ "\"" + ",");
														/*
														 * Code for testcases
														 * end
														 */
													}
												}

											}

											mainSB.setLength(mainSB.length() - 1);
											mainSB.append(");");
											mainSB.append(System.lineSeparator());
											mainSB.append("result= " + method + "(objArray, " + className.toLowerCase()
													+ "Res2);");// +field.substring(0,1)+field.substring(1)+");");
											mainSB.append(System.lineSeparator());
											mainSB.append(System.lineSeparator());
											mainSB.append("System.out.println(\"Output for performing replace on "
													+ className.toLowerCase() + "Res2 is: \"+ result  );          ");
											mainSB.append(System.lineSeparator());
											mainSB.append(System.lineSeparator());
											mainSB.append("System.out.println(\"Displaying contents of array: \");");
											mainSB.append(System.lineSeparator());
											mainSB.append(System.lineSeparator());
											mainSB.append(
													"for(" + className + " " + className.toLowerCase() + ":objArray){");
											mainSB.append(System.lineSeparator());
											mainSB.append("System.out.println(");

											/* Code for testcases start */

											testSB1.setLength(testSB1.length() - 1);
											testSB1.append(");");
											testSB1.append(System.lineSeparator());
											testSB1.append("result= " + className.toLowerCase() + "Demo." + method
													+ "(objArray, " + className.toLowerCase() + "Res2);");
											testSB1.append(System.lineSeparator());
											testSB1.append(System.lineSeparator());
											testSB1.append("System.out.println(\"Output for performing replace on "
													+ className.toLowerCase() + "Res2 is: \"+ result  );          ");
											testSB1.append(System.lineSeparator());
											testSB1.append(System.lineSeparator());
											testSB1.append("System.out.println(\"Displaying contents of array: \");");
											testSB1.append(System.lineSeparator());
											testSB1.append(System.lineSeparator());
											testSB1.append(
													"for(" + className + " " + className.toLowerCase() + ":objArray){");
											testSB1.append(System.lineSeparator());
											testSB1.append("System.out.println(");

											testSB2.setLength(testSB2.length() - 1);
											testSB2.append(");");
											testSB2.append(System.lineSeparator());
											testSB2.append("result= " + className.toLowerCase() + "Demo." + method
													+ "(objArray, " + className.toLowerCase() + "Res2);");
											testSB2.append(System.lineSeparator());
											testSB2.append(System.lineSeparator());
											testSB2.append("System.out.println(\"Output for performing replace on "
													+ className.toLowerCase() + "Res2 is: \"+ result  );          ");
											testSB2.append(System.lineSeparator());
											testSB2.append(System.lineSeparator());
											testSB2.append("System.out.println(\"Displaying contents of array: \");");
											testSB2.append(System.lineSeparator());
											testSB2.append(System.lineSeparator());
											testSB2.append(
													"for(" + className + " " + className.toLowerCase() + ":objArray){");
											testSB2.append(System.lineSeparator());
											testSB2.append("System.out.println(");

											/* Code for testcases end */

											chk = 0;
											for (EntityMapping field1 : mapList) {

												if (chk == 0) {
													mainSB.append(className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													/*
													 * Code for testcases start
													 */
													testSB1.append(className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													testSB2.append(className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													/* Code for testcases end */

												} else {
													mainSB.append(" + " + className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													/*
													 * Code for testcases start
													 */
													testSB1.append(" + " + className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													testSB2.append(" + " + className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													/* Code for testcases end */
												}
												chk++;

											}

											mainSB.append(");");

											mainSB.append(System.lineSeparator());

											mainSB.append("}");
											mainSB.append(System.lineSeparator());

											/* Code for testcases start */
											testSB1.append(");");

											testSB1.append(System.lineSeparator());

											testSB1.append("}");
											testSB1.append(System.lineSeparator());

											testSB2.append(");");

											testSB2.append(System.lineSeparator());

											testSB2.append("}");
											testSB2.append(System.lineSeparator());

											/* Code for testcases end */

										} else
											question.append("Create a static method " + method + " in the " + className
													+ "Demo class. This method will take Array List of " + className
													+ " objects and one " + className + " object as input. Replace the "
													+ className + " object with same " + field
													+ " if found in the Array List and return true. Else return false");

									}
									if (method.contains("sort") && difficultyLevel == 2) {

										method = "sort" + className + "By" + field.substring(0, 1).toUpperCase()
												+ field.substring(1);
										question.append("Create the below static method " + method + " in the "
												+ className + "Demo class.");
										question.append(System.lineSeparator());
										question.append(System.lineSeparator());
										if (concept.equals("Array"))
											question.append("" + method + "(" + className + "[] objArray)");
										else
											question.append("" + method + "(ArrayList<" + className + "> objList)");
										question.append(System.lineSeparator());
										question.append(System.lineSeparator());
										if (concept.equals("Array")) {
											question.append("The method will sort the array based on " + field
													+ " and return the sorted array.");

											mainSB.delete(0, mainSB.length());
											mainSB.append(mainSBCopy.toString());

											/* Code for testcases start */
											testSB1.delete(0, testSB1.length());
											testSB1.append(testSB1Copy.toString());

											testSB2.delete(0, testSB2.length());
											testSB2.append(testSB2Copy.toString());
											/* Code for testcases end */

											if (firstQuestionSB.length() > 2) {
												firstQuestionSB.delete(0, firstQuestionSB.length());
											}

											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("public static " + className + "[] " + method + "("
													+ className + "[] objArray){");
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append(className + " a = null;");
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("for(int i=0;i<objArray.length;i++){");
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("for(int j=i+1;j<objArray.length;j++){");
											firstQuestionSB.append(System.lineSeparator());
											if (fieldValue.get(field).equalsIgnoreCase("String")) {
												firstQuestionSB.append(
														"if (objArray[i].get" + field.substring(0, 1).toUpperCase()
																+ field.substring(1) + "().compareTo(objArray[j].get"
																+ field.substring(0, 1).toUpperCase()
																+ field.substring(1) + "())>0){");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("a =  objArray[i];");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("objArray[i] =  objArray[j];");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("objArray[j] =  a;");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("}");

											} else {

												firstQuestionSB.append("if (objArray[i].get"
														+ field.substring(0, 1).toUpperCase() + field.substring(1)
														+ "() > objArray[j].get" + field.substring(0, 1).toUpperCase()
														+ field.substring(1) + "()){");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("a =  objArray[i];");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("objArray[i] =  objArray[j];");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("objArray[j] =  a;");
												firstQuestionSB.append(System.lineSeparator());
												firstQuestionSB.append("}");
											}

											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("}");
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("}");
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("return objArray;");
											firstQuestionSB.append(System.lineSeparator());
											firstQuestionSB.append("}");

											mainSB.append(System.lineSeparator());

											mainSB.append(System.lineSeparator());
											mainSB.append(className + "[] objArray= {" + className.toLowerCase() + "1,"
													+ className.toLowerCase() + "2," + className.toLowerCase() + "3,"
													+ className.toLowerCase() + "4," + className.toLowerCase() + "5};");
											mainSB.append(System.lineSeparator());
											mainSB.append(System.lineSeparator());

											mainSB.append(className + "[] objArrayRes= " + method + "(objArray);");
											mainSB.append(System.lineSeparator());
											mainSB.append("System.out.println(\"Displaying contents of array: \");");
											mainSB.append(System.lineSeparator());
											mainSB.append(System.lineSeparator());

											mainSB.append(
													"for(" + className + " " + className.toLowerCase() + ":objArray){");
											mainSB.append(System.lineSeparator());

											mainSB.append("System.out.println(");

											/* Code for testcases start */
											testSB1.append(System.lineSeparator());

											testSB1.append(System.lineSeparator());
											testSB1.append(className + "[] objArray= {" + className.toLowerCase() + "1,"
													+ className.toLowerCase() + "2," + className.toLowerCase() + "3,"
													+ className.toLowerCase() + "4," + className.toLowerCase() + "5};");
											testSB1.append(System.lineSeparator());
											testSB1.append(System.lineSeparator());

											testSB1.append(className + "[] objArrayRes= " + className.toLowerCase()
													+ "Demo." + method + "(objArray);");
											testSB1.append(System.lineSeparator());
											testSB1.append("System.out.println(\"Displaying contents of array: \");");
											testSB1.append(System.lineSeparator());
											testSB1.append(System.lineSeparator());

											testSB1.append(
													"for(" + className + " " + className.toLowerCase() + ":objArray){");
											testSB1.append(System.lineSeparator());

											testSB1.append("System.out.println(");

											testSB2.append(System.lineSeparator());

											testSB2.append(System.lineSeparator());
											testSB2.append(className + "[] objArray= {" + className.toLowerCase() + "1,"
													+ className.toLowerCase() + "2," + className.toLowerCase() + "3,"
													+ className.toLowerCase() + "4," + className.toLowerCase() + "5};");
											testSB2.append(System.lineSeparator());
											testSB2.append(System.lineSeparator());

											testSB2.append(className + "[] objArrayRes= " + className.toLowerCase()
													+ "Demo." + method + "(objArray);");
											testSB2.append(System.lineSeparator());
											testSB2.append("System.out.println(\"Displaying contents of array: \");");
											testSB2.append(System.lineSeparator());
											testSB2.append(System.lineSeparator());

											testSB2.append(
													"for(" + className + " " + className.toLowerCase() + ":objArray){");
											testSB2.append(System.lineSeparator());

											testSB2.append("System.out.println(");
											/* Code for testcases end */

											int chk = 0;
											for (EntityMapping field1 : mapList) {

												if (chk == 0) {
													mainSB.append(className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													/*
													 * Code for testcases start
													 */
													testSB1.append(className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													testSB2.append(className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													/* Code for testcases end */

												} else {
													mainSB.append(" + " + className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													/*
													 * Code for testcases start
													 */
													testSB1.append(" + " + className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													testSB2.append(" + " + className.toLowerCase() + ".get"
															+ field1.getTitle().substring(0, 1).toUpperCase()
															+ field1.getTitle().substring(1) + "()+\" \"");
													/* Code for testcases end */

												}
												chk++;

											}

											mainSB.append(");");

											mainSB.append(System.lineSeparator());

											mainSB.append("}");
											mainSB.append(System.lineSeparator());
											/* Code for testcases start */
											testSB1.append(");");

											testSB1.append(System.lineSeparator());

											testSB1.append("}");
											testSB1.append(System.lineSeparator());

											testSB2.append(");");

											testSB2.append(System.lineSeparator());

											testSB2.append("}");
											testSB2.append(System.lineSeparator());
											/* Code for testcases end */

										} else
											question.append("The method will sort the Array List based on " + field
													+ " and return the sorted Array List.");

									}
								}
								question.append(System.lineSeparator());
								question.append(System.lineSeparator());
								if (concept.equals("Array")) {
									question.append(
											"Create an array of 5 " + className + " objects in the main method");
									question.append(System.lineSeparator());
									question.append("Refer below sample main method and test the output:");
									question.append(System.lineSeparator());
									question.append(System.lineSeparator());
									question.append("Call the above static method from the main method");

									mainSB.append("}");

									StringBuilder mainSBWitoutLogic = new StringBuilder();
									mainSBWitoutLogic.append(mainSB.toString());
									mainSBWitoutLogic.append("}");
									mainSB.append(System.lineSeparator());
									mainSB.append(firstQuestionSB.toString());
									mainSB.append(System.lineSeparator());
									mainSB.append("}");
									/* Code for testcases start */
									testSB1.append("}");

									testSB1WithoutLogic.append(testSB1.toString());
									testSB1WithoutLogic.append("}");
									testSB1.append(System.lineSeparator());
									/*
									 * testSB1.append(firstQuestionSB.toString()
									 * );
									 * testSB1.append(System.lineSeparator());
									 */
									testSB1.append("}");

									testSB2.append("}");

									testSB2WithoutLogic.append(testSB2.toString());
									testSB2WithoutLogic.append("}");
									testSB2.append(System.lineSeparator());
									/*
									 * testSB2.append(firstQuestionSB.toString()
									 * );
									 * testSB2.append(System.lineSeparator());
									 */
									testSB2.append("}");
									/* Code for testcases end */
									sourceFile.append("}");
									question.append(System.lineSeparator());
									question.append(System.lineSeparator());
									question.append(System.lineSeparator());
									question.append(mainSBWitoutLogic.toString());
									if (firstQuestionFileSB.length() < 2) {
										firstQuestionFileSB.append(sourceFile.toString());
									}
									firstQuestionFileSB.append(System.lineSeparator());
									firstQuestionFileSB.append(System.lineSeparator());
									question = outputGenerator.compileAndExecuteDynamically(question, className,
											firstQuestionFileSB, mainSB, empId);

									/* Code for testcases start */

									testSB1Output = outputGenerator.compileAndExecuteDynamically(className,
											firstQuestionFileSB, mainSB, testSB1, "TestCase1", empId);
									testSB2Output = outputGenerator.compileAndExecuteDynamically(className,
											firstQuestionFileSB, mainSB, testSB2, "TestCase2", empId);

									artifacts.put("QUESTION_" + empId, question.toString());
									artifacts.put("TESTCASE1_" + empId, testSB1WithoutLogic.toString());
									artifacts.put("TESTCASE1OUTPUT_" + empId, testSB1Output.toString());
									artifacts.put("TESTCASE2_" + empId, testSB2WithoutLogic.toString());
									artifacts.put("TESTCASE2OUTPUT_" + empId, testSB2Output.toString());

									/* Code for testcases end */
								} else {
									question.append(
											"Create an Array List of 5 " + className + " objects in the main method");
									question.append(System.lineSeparator());
									question.append(System.lineSeparator());
									question.append("Call the above static method from the main method");
									question.append(System.lineSeparator());
								}
								createFile(source, question, className, loopCount, noOfQuestions, questionNo, concept,
										difficultyLevel);
								// createFiles(source,question,className,loopCount,noOfQuestions,questionNo,concept,difficultyLevel,testSB1WithoutLogic,testSB2WithoutLogic,
								// testSB1);
								loopCount++;
								noOfQuestions -= 1;
							} else
								break;

						}

					}
				}

				else {
					if (entityId > 0)
						return artifacts;
					else
						return artifacts;
				}
			}

			return artifacts;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int createQuestion(String concept, String source, int noOfQuestions, int questionNo, int entityId,
			int difficultyLevel) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		return 0;
	}
	
	
	
}