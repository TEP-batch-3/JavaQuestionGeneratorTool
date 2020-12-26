package com.tcs.ilp.iquest.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import com.tcs.ilp.iquest.bean.Concept;
import com.tcs.ilp.iquest.bean.Entity;
import com.tcs.ilp.iquest.dao.IQuestDAO;
import com.tcs.ilp.iquest.enums.TaskStatus;
import com.tcs.ilp.iquest.util.Constants;

public class DynamicQuestionService {
	IQuestDAO iquestDAO=null;
	
	private List<String> fileList = new ArrayList<String>();
	//private static final String SOURCE_FOLDER = "D:\\Questions\\123\\files"; // SourceFolder path
	public DynamicQuestionService()
	{
		iquestDAO=new IQuestDAO();
	}
	public String[] generateQuestion(String concept,String empId,int noOfQuestions,int entityId,int difficultyLevel,int[] levels)
	{
	
		/*
		 * System.out.println(concept); System.out.println(empId);
		 * System.out.println(noOfQuestions); System.out.println(entityId);
		 * System.out.println(difficultyLevel); System.out.println(levels);
		 */
		
		String source = "C:\\Questions\\"+empId+"\\files\\src\\com\\";
		
		Map<String, String> artifacts= new HashMap<String, String>();
		
		String[] artifactsJson = new String[5];
	
		int questionNo = noOfQuestions;
		QuestionGenerator quesGen = null;
		try
		{
					try {
							if(new File(source).exists())
								FileUtils .cleanDirectory(new File(source));
							else new File(source).mkdirs();
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		
					 if(concept.contains(Constants.ARRAY))
					{
						//noOfQuestions=2;
						quesGen = new ArrayListQuestionGenerator();
						artifacts=	quesGen.createQuestion(concept,source,difficultyLevel,empId,noOfQuestions);
							//artifacts = quesGen.createQuestion(concept,source,noOfQuestions,1,entityId,difficultyLevel,empId,"IASCERT");

							if(null!=artifacts.get("QUESTION_"+empId) 
									&& null!=artifacts.get("TESTCASE1_"+empId)
									&& null!=artifacts.get("TESTCASE1OUTPUT_"+empId) 
									&& null!=artifacts.get("TESTCASE2_"+empId) 
									&& null!=artifacts.get("TESTCASE2OUTPUT_"+empId)){
									 iquestDAO.auditDST(Integer.parseInt(empId),concept.split("_")[0],questionNo);
									
									 artifactsJson[0]=artifacts.get("QUESTION_"+empId);
									 artifactsJson[1]=artifacts.get("TESTCASE1_"+empId);
									 artifactsJson[2]=artifacts.get("TESTCASE1OUTPUT_"+empId);
									 artifactsJson[3]=artifacts.get("TESTCASE2_"+empId);
									 artifactsJson[4]=artifacts.get("TESTCASE2OUTPUT_"+empId);
									 
									 return artifactsJson;
							}
					}
					
				
			
		}	
		catch(Exception e)
		{
			e.printStackTrace();
			/*System.out.println("Exception in creating the question" + e.getMessage());*/
			return null;
		}
		return artifactsJson;
		
	
	}
	

	public void generateFileList(String source,File node)
	{

	  // add file only
	  if (node.isFile())
	  {
	     fileList.add(generateZipEntry(source,node.toString()));

	  }

	  if (node.isDirectory())
	  {
	     String[] subNote = node.list();
	     for (String filename : subNote)
	     {
	        generateFileList(source,new File(node, filename));
	     }
	  }
	}

	private String generateZipEntry(String source,String file)
	{
	   return file.substring(source.length() + 1, file.length());
	}
	

	
	public ArrayList<Concept> getConcepts()
	{
		return iquestDAO.getConceptDetail();
	}
	public ArrayList<Entity> getEntities()
	{
		return iquestDAO.getEntityList();
	}
}
