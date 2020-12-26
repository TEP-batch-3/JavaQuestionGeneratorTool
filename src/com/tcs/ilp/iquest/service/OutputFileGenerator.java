package com.tcs.ilp.iquest.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import com.tcs.ilp.iquest.bean.EntityMapping;
import com.tcs.ilp.iquest.util.OutputFilesConstants;

public class OutputFileGenerator {

	public HashMap<StringBuilder, ArrayList<String>> createEntityFile(
			String className, ArrayList<EntityMapping> mapList,
			int difficultyLevel, int[] selFieldsForHighDiff) {
		HashMap<StringBuilder, ArrayList<String>> outputMap = new HashMap<StringBuilder, ArrayList<String>>();
		ArrayList<String> outputValues = new ArrayList<>();
		StringBuilder outputGenerator = null;
		outputGenerator = new StringBuilder();
		outputGenerator.append(System.lineSeparator());
		outputGenerator.append(System.lineSeparator());
		outputGenerator.append("class " + className + " ");
		outputGenerator.append(OutputFilesConstants.CLASSSTARTBRACKET);
		outputGenerator.append(System.lineSeparator());
		outputGenerator.append(System.lineSeparator());
		for (EntityMapping entMap : mapList) {
			outputGenerator.append(entMap.getFieldType() + " "
					+ entMap.getTitle() + OutputFilesConstants.SEMICOLON);
			outputGenerator.append(System.lineSeparator());
		}
		ArrayList<String> diffConstructorStrings = new ArrayList<String>();
		if (difficultyLevel < 3) {
			diffConstructorStrings = generateConstructor(mapList, className);
		} else {
			for (int index = 0; index < selFieldsForHighDiff.length; index++) {
				if (index == 0) {
					mapList.remove(selFieldsForHighDiff[index]);
				} else {
					mapList.remove(selFieldsForHighDiff[index] - 1);
				}
			}
			diffConstructorStrings = generateConstructor(mapList, className);
		}
		// Code for generating multiple number of Constructors

		/* for (String tempString : diffConstructorStrings) { */
		String tempString = diffConstructorStrings.get(diffConstructorStrings
				.size() - 1);
		outputGenerator.append(System.lineSeparator());
		if (difficultyLevel == 1) {
			outputGenerator.append("public " + className + "(){");
		} else {
			outputGenerator.append(tempString + "{");
		}
		outputGenerator.append(System.lineSeparator());
		StringTokenizer stringToken = new StringTokenizer(tempString);
		int stringTokenCounter = 0;
		while (stringToken.hasMoreElements()) {
			if (stringTokenCounter < 1) {
				stringToken.nextElement();
				stringTokenCounter++;
				continue;
			} else {
				String tempPdt = null;
				String fieldTitle = (String) stringToken.nextElement();
				if (fieldTitle.contains("(")) {
					StringTokenizer innerToken = new StringTokenizer(
							fieldTitle, "(");
					while (innerToken.hasMoreElements()) {
						innerToken.nextElement();
						fieldTitle = (String) innerToken.nextElement();
					}
				}
				if (fieldTitle.equals("int") || fieldTitle.equals("double")
						|| fieldTitle.equals("float")
						|| fieldTitle.equals("char")
						|| fieldTitle.equals("boolean")
						|| fieldTitle.equals("String")
						|| fieldTitle.equals("StringBuilder")) {
					if (difficultyLevel == 1) {
						tempPdt = fieldTitle;
					}
					fieldTitle = (String) stringToken.nextElement();
				}

				if (fieldTitle.endsWith(")")) {
					fieldTitle = fieldTitle.replace(")", "");
				}
				if (fieldTitle.endsWith(",")) {
					fieldTitle = fieldTitle.replace(",", "");
				}
				if (difficultyLevel == 1) {
					String tempValue = generateRandomValue(tempPdt);
					outputGenerator.append("this." + fieldTitle + "="
							+ tempValue + ";");
					outputValues.add(tempValue);
				} else {
					outputGenerator.append("this." + fieldTitle + "="
							+ fieldTitle + ";");
				}

				outputGenerator.append(System.lineSeparator());

			}
		}
		outputGenerator.append("}");
		/* } */

		// Code for generating multiple number of Consructors

		// return file;
		outputGenerator.append(System.lineSeparator());
		outputGenerator.append(System.lineSeparator());
		outputGenerator.append("}");
		outputMap.put(outputGenerator, outputValues);
		return outputMap;
	}

	public String generateRandomValue(String tempPdt) {
		// TODO Auto-generated method stub
		RandomGenerator randomGenerator = new RandomGenerator();
		if (tempPdt.contains("int")) {
			return randomGenerator.generateIntValue().toString();
		}
		if (tempPdt.contains("double")) {
			return randomGenerator.generateDoubleValue().toString();
		}
		if (tempPdt.contains("float")) {
			return randomGenerator.generateFloatValue().toString();
		}
		if (tempPdt.contains("char")) {
			return randomGenerator.generateCharValue().toString();
		}
		if (tempPdt.contains("boolean")) {
			return randomGenerator.generateBooleanValue().toString();
		}
		if (tempPdt.contains("String")) {
			return randomGenerator.generateStringValue().toString();
		}
		if (tempPdt.contains("StringBuilder")) {
			return randomGenerator.generateStringBuilderValue().toString();
		}
		return tempPdt;

	}

	public ArrayList<String> generateConstructor(
			ArrayList<EntityMapping> mapList, String className) {
		// TODO Auto-generated method stub
		ArrayList<String> diffConstructorStrings = new ArrayList<String>();
		String[] diffSetsOfVariables = new String[mapList.size()];
		int[] diffIndices;
		int increement = 0;
		for (EntityMapping entMap : mapList) {
			diffSetsOfVariables[increement] = entMap.getFieldType() + " "
					+ entMap.getTitle();
			increement++;
		}
		for (int countGeneration = 1; countGeneration <= mapList.size(); countGeneration++) {
			ConstructorGenerator constructorGenerator = new ConstructorGenerator(
					diffSetsOfVariables.length, countGeneration);
			StringBuffer combination;
			while (constructorGenerator.hasMore()) {
				combination = new StringBuffer();
				diffIndices = constructorGenerator.getNext();
				for (int index = 0; index < diffIndices.length; index++) {
					if (diffIndices.length == 1) {
						combination
								.append(diffSetsOfVariables[diffIndices[index]]);
					} else {
						if (index == diffIndices.length - 1) {
							combination
									.append(diffSetsOfVariables[diffIndices[index]]);
						} else {
							combination
									.append(diffSetsOfVariables[diffIndices[index]]
											+ ", ");
						}
					}

				}
				diffConstructorStrings.add("public " + className + "("
						+ combination.toString() + ")");
				System.out.println("public " + className + "("
						+ combination.toString() + ")");
			}

		}
		return diffConstructorStrings;
	}

	public StringBuilder createEntityDemoFile(String className,
			ArrayList<EntityMapping> mapList, int difficultyLevel,
			ArrayList<String> outputValues, int[] selFieldsForHighDiff) {
		StringBuilder outputGenerator = new StringBuilder();
		ArrayList<String> diffConstructorStrings = generateConstructor(mapList,
				className);
		String sampleConstructor = (String) diffConstructorStrings
				.get(diffConstructorStrings.size() - 1);
		sampleConstructor = sampleConstructor.replace(")", "");
		StringTokenizer strTokenizer = new StringTokenizer(sampleConstructor,
				"(");
		while (strTokenizer.hasMoreElements()) {
			strTokenizer.nextElement();
			sampleConstructor = (String) strTokenizer.nextElement();
		}
		outputGenerator.append(System.lineSeparator());
		outputGenerator.append(System.lineSeparator());
		outputGenerator.append("class " + className + "Demo");
		outputGenerator.append(OutputFilesConstants.CLASSSTARTBRACKET);
		outputGenerator.append(System.lineSeparator());
		outputGenerator.append(System.lineSeparator());
		outputGenerator.append("public static void main(String[] args)");
		outputGenerator.append(System.lineSeparator());
		outputGenerator.append(OutputFilesConstants.CLASSSTARTBRACKET);
		outputGenerator.append(System.lineSeparator());
		ArrayList<String> outputList = new ArrayList<>();
		for (int index = 1; /* index <= mapList.size() */index <= 1/*
																	 * only for
																	 * 1
																	 * constructor
																	 */; index++) {
			String tempSampleConstructor = sampleConstructor;
			outputGenerator.append(className + " " + className.toLowerCase()
					+ index);
			if (difficultyLevel == 1) {
				outputGenerator.append("= new " + className + "();");
			} else {
				outputGenerator.append("= new " + className + "(");
				// code to give dynamic values
				RandomGenerator randomGenerator = new RandomGenerator();
				/*
				 * HashMap<String,ArrayList<Object>> pdtMapping = new
				 * HashMap<String,ArrayList<Object>>(); pdtMapping.put("int",
				 * randomGenerator.generateIntValues(sampleConstructor));
				 * pdtMapping.put("double",
				 * randomGenerator.generateDoubleValues(sampleConstructor));
				 * pdtMapping.put("float",
				 * randomGenerator.generateFloatValues(sampleConstructor));
				 * pdtMapping.put("char",
				 * randomGenerator.generateCharValues(sampleConstructor));
				 * pdtMapping.put("boolean",
				 * randomGenerator.generateBooleanValues(sampleConstructor));
				 * pdtMapping.put("String",
				 * randomGenerator.generateStringValues(sampleConstructor));
				 * pdtMapping.put("StringBuilder",
				 * randomGenerator.generateStringBuilderValues
				 * (sampleConstructor));
				 */// code to give dynamic values
					// replace values in sample constructor
				StringTokenizer stringTokenizer = new StringTokenizer(
						tempSampleConstructor, ",");
				ArrayList<String> varList = new ArrayList<String>();
				while (stringTokenizer.hasMoreElements()) {
					String pdtVar = (String) stringTokenizer.nextElement();
					varList.add(pdtVar);
				}
				for (String temp : varList) {
					if (temp.contains("int")) {
						tempSampleConstructor = tempSampleConstructor.replace(
								temp, randomGenerator.generateIntValue());
					}
					if (temp.contains("double")) {
						tempSampleConstructor = tempSampleConstructor.replace(
								temp, randomGenerator.generateDoubleValue());
					}
					if (temp.contains("float")) {
						tempSampleConstructor = tempSampleConstructor.replace(
								temp, randomGenerator.generateFloatValue());
					}
					if (temp.contains("char")) {
						tempSampleConstructor = tempSampleConstructor.replace(
								temp, randomGenerator.generateCharValue());
					}
					if (temp.contains("boolean")) {
						tempSampleConstructor = tempSampleConstructor.replace(
								temp, randomGenerator.generateBooleanValue());
					}
					if (temp.contains("String")) {
						if (temp.contains("email")) {
							String randomEmail = randomGenerator
									.generateStringValue() + "@tcs.com";
							tempSampleConstructor = tempSampleConstructor
									.replace(temp, randomEmail);
						} else {
							if (temp.contains("dob")) {
								GregorianCalendar gc = new GregorianCalendar();
								int year = RandomGenerator.randBetween(1900,
										2016);
								gc.set(gc.YEAR, year);
								int dayOfYear = RandomGenerator.randBetween(1,
										gc.getActualMaximum(gc.DAY_OF_YEAR));
								gc.set(gc.DAY_OF_YEAR, dayOfYear);
								String dob = gc.get(gc.YEAR) + "-"
										+ (gc.get(gc.MONTH) + 1) + "-"
										+ gc.get(gc.DAY_OF_MONTH);
								tempSampleConstructor = tempSampleConstructor
										.replace(temp, dob);
							} else {
								tempSampleConstructor = tempSampleConstructor
										.replace(temp, randomGenerator
												.generateStringValue());
							}
						}
					}
					if (temp.contains("StringBuilder")) {
						tempSampleConstructor = tempSampleConstructor.replace(
								temp,
								randomGenerator.generateStringBuilderValue());
					}

				}
				outputList.add(tempSampleConstructor);
				outputGenerator.append(tempSampleConstructor + ");");
			}
			outputGenerator.append(System.lineSeparator());
		}
		// return file;
		String outputVarString = sampleConstructor;
		ArrayList<String> outputVar = new ArrayList<>();
		StringTokenizer strVarToken = new StringTokenizer(outputVarString, ",");
		while (strVarToken.hasMoreElements()) {
			String tempVar = (String) strVarToken.nextElement();
			tempVar = tempVar.trim();
			StringTokenizer innerToken = new StringTokenizer(tempVar, " ");
			while (innerToken.hasMoreElements()) {
				innerToken.nextElement();
				tempVar = (String) innerToken.nextElement();
			}
			outputVar.add(tempVar);
		}

		for (int index = 0; /* index < mapList.size() */index < 1 /*
																 * only for 1
																 * constructor
																 */; index++) {
			for (int inLoopIndex = 0; inLoopIndex < outputVar.size(); inLoopIndex++) {
				outputGenerator.append("System.out.println(");
				outputGenerator.append(className.toLowerCase() + (index + 1)
						+ "." + outputVar.get(inLoopIndex).toString() + ");");
				outputGenerator.append(System.lineSeparator());
			}
		}

		outputGenerator.append("}");
		outputGenerator.append(System.lineSeparator());
		outputGenerator.append("}");
		outputGenerator.append(System.lineSeparator());
		outputGenerator.append(System.lineSeparator());
		outputGenerator.append("------------OUTPUT------------");
		outputGenerator.append(System.lineSeparator());
		outputGenerator.append(System.lineSeparator());
		if (difficultyLevel == 1) {
			// write code here
		} else {
			for (String outputString : outputList) {
				StringTokenizer outputTokenizer = new StringTokenizer(
						outputString, ",");
				while (outputTokenizer.hasMoreElements()) {
					outputGenerator.append(outputTokenizer.nextElement());
					outputGenerator.append(System.lineSeparator());
				}
			}
		}
		if (difficultyLevel == 1 && outputValues.size() != 0) {
			for (String tempString : outputValues) {
				outputGenerator.append(tempString);
				outputGenerator.append(System.lineSeparator());
			}
		}
		return outputGenerator;

	}
	
	public StringBuilder compileAndExecuteDynamically(StringBuilder question,String className,StringBuilder sourceFileSB,StringBuilder demoFileSB,  String empId){
		
		try{
			
		
			 File entityFile  = new File("C:/Questions/"+empId+"/files/src/com/"+className+".java");
			  FileWriter writer = new FileWriter(entityFile);
			    writer.write(sourceFileSB.toString());
			    writer.close();
			  File demoFile  = new File("C:/Questions/"+empId+"/files/src/com/"+className+"Demo.java");
			    FileWriter writer2 = new FileWriter(demoFile);
			    writer2.write(demoFileSB.toString());
			    writer2.close();
		  System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.8.0_201");
			    
			    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			   
			    StandardJavaFileManager fileManager =
			        compiler.getStandardFileManager(null, null, null);

			    fileManager.setLocation(StandardLocation.CLASS_OUTPUT,
			                            Arrays.asList(new File("C:/Questions/"+empId+"/files/src/")));
			    
			 // Compile the file
			    compiler.getTask(null,
			               fileManager,
			               null,
			               null,
			               null,
			               fileManager.getJavaFileObjectsFromFiles(Arrays.asList(entityFile,demoFile)))
			            .call();
			    fileManager.close();

			    File f = new File("C:/Questions/"+empId+"/files/src/");
			    URL[] cp = {f.toURI().toURL()};
			    URLClassLoader urlcl = new URLClassLoader(cp);
			    Class clazz = urlcl.loadClass("com."+className+"Demo");

			  Method main = clazz.getDeclaredMethod("main", String[].class);
			    try ( ByteArrayOutputStream out = new ByteArrayOutputStream();
			          PrintStream ps = new PrintStream(out)) {
			        System.setOut(ps);
			        main.invoke(main, new Object[]{new String[0]});
			     
			        question.append(System.lineSeparator());
			        question.append("Output");
					question.append(System.lineSeparator());
					question.append(out.toString());
					
			    }
			    finally {
			        // Reset to the console
			        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			    }

		}
		catch(Exception e){
			e.printStackTrace();
		}
		return question;
		
	}
	
public StringBuilder compileAndExecuteDynamically(String className,StringBuilder sourceFileSB,StringBuilder demoFileSB, StringBuilder testFileSB, String testCaseName, String empId){
		
		StringBuilder output = new StringBuilder();
		try{
			
			
			
			
			 File entityFile  = new File("C:/Questions/"+empId+"/files/src/com/"+className+".java");
			    FileWriter writer = new FileWriter(entityFile);
			    writer.write(sourceFileSB.toString());
			    writer.close();
			    File demoFile  = new File("C:/Questions/"+empId+"/files/src/com/"+className+"Demo.java");
			    FileWriter writer1 = new FileWriter(demoFile);
			    writer1.write(demoFileSB.toString());
			    writer1.close();
			  File testFile  = new File("C:/Questions/"+empId+"/files/src/com/"+testCaseName+".java");
			    FileWriter writer2 = new FileWriter(testFile);
			    writer2.write(testFileSB.toString());
			    writer2.close();
			    System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.8.0_201");
			    
			    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			   
			    StandardJavaFileManager fileManager =
			        compiler.getStandardFileManager(null, null, null);

			    fileManager.setLocation(StandardLocation.CLASS_OUTPUT,
			                            Arrays.asList(new File("C:/Questions/"+empId+"/files/src/")));
			    
			 // Compile the file
			    compiler.getTask(null,
			               fileManager,
			               null,
			               null,
			               null,
			               fileManager.getJavaFileObjectsFromFiles(Arrays.asList(entityFile,demoFile,testFile)))
			            .call();
			    fileManager.close();

			    File f = new File("C:/Questions/"+empId+"/files/src/");
			    URL[] cp = {f.toURI().toURL()};
			    URLClassLoader urlcl = new URLClassLoader(cp);
			    Class clazz = urlcl.loadClass("com."+testCaseName);

			  Method main = clazz.getDeclaredMethod("main", String[].class);
			    try ( ByteArrayOutputStream out = new ByteArrayOutputStream();
			          PrintStream ps = new PrintStream(out)) {
			        System.setOut(ps);
			        main.invoke(main, new Object[]{new String[0]});
			     
			      /*  question.append(System.lineSeparator());
			        question.append("Output");
					question.append(System.lineSeparator());*/
					output.append(out.toString());
					
			    }
			    finally {
			        // Reset to the console
			        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			    }

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return output;
		
	}

}
