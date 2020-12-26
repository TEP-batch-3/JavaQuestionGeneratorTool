package com.tcs.ilp.iquest.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public abstract class QuestionGenerator {
	//public abstract  Map<String, String> createTemplate(String concept, String source,  int noOfQuestions,int difficultyLevel,String empId);
	public  abstract int createQuestion(String concept,String source,int noOfQuestions,int questionNo,int entityId,int difficultyLevel) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public  abstract Map<String, String> createQuestion(String concept,String source,int noOfQuestions,int questionNo,int entityId,int difficultyLevel, String empId, String flag) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void createFile(String source,StringBuilder question,String entity,int count,int questions,int questionNo,String concept,int difficultyLevel)
	{
		String quest=question.toString();
//		/System.out.println(quest);
		String fileName=entity+concept+"Difficulty Level"+difficultyLevel+"_"+count+".txt";
		//File desktop = new File(System.getProperty("user.home") + File.separator + "Desktop");
	//	String empId = "123";
		File path = new File(source);
		
			
		//File file1 = new File(desktop,"Questions");
		if(!path.exists() )
			path.mkdirs();
	/*	else if(questions==questionNo)
		{
			try {
				FileUtils .cleanDirectory(path);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}*/
		File file = new File(path,fileName);
	      // creates the file
		try
		{
	      file.createNewFile();
	      // creates a FileWriter Object
	      FileWriter writer = new FileWriter(file); 
	      // Writes the content to the file
	      writer.write(quest); 
	      writer.flush();
	      writer.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void createFile(String source,StringBuilder question,String entity,String concept, int loop)
	{
		String quest=question.toString();
//		/System.out.println(quest);
		String fileName=entity+concept+loop+".txt";
		//File desktop = new File(System.getProperty("user.home") + File.separator + "Desktop");
	//	String empId = "123";
		File path = new File(source);
		
			
		//File file1 = new File(desktop,"Questions");
		if(!path.exists() )
			path.mkdirs();
	/*	else if(questions==questionNo)
		{
			try {
				FileUtils .cleanDirectory(path);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}*/
		File file = new File(path,fileName);
	      // creates the file
		try
		{
	      file.createNewFile();
	      // creates a FileWriter Object
	      FileWriter writer = new FileWriter(file); 
	      // Writes the content to the file
	      writer.write(quest); 
	      writer.flush();
	      writer.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	
	

	public abstract Map<String, String> createQuestion(String concept, String source, int difficultyLevel, String empId,
			int noOfQuestionsToGenerate) ;

}
