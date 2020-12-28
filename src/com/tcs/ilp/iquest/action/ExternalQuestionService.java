package com.tcs.ilp.iquest.action;

import java.io.InputStream;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tcs.ilp.iquest.bean.Question;
import com.tcs.ilp.iquest.service.DynamicQuestionService;
import com.tcs.ilp.iquest.util.Constants;
import com.tcs.qgt.bean.QuestionGenerateBean;

@Path("/downloadQuestions")
public class ExternalQuestionService {

private String empId;
	
	private int topicId;
	
	private int score;
	
	private InputStream file;

	@POST
    @Produces(MediaType.APPLICATION_JSON)
	public String[] generateQuestion(@FormParam("empId") String empId,
            @FormParam("topicId") String topicId) throws Exception {
	 	
		DynamicQuestionService dynamicService=new DynamicQuestionService();
		QuestionGenerateBean qgb = new QuestionGenerateBean();
		
		Question ques=new Question();
//		 int noOfQuestions=1;
//		 int difficultylevel=3;
		//the no of question and level will be fetch from user: Edited by gowtham
		int noOfQuestions = qgb.getNoOfQuestions();
		int difficultylevel = qgb.getLevel();
		/*
		 * System.out.println("inside external question service");
		 * System.out.println(noOfQuestions); System.out.println(difficultylevel);
		 */
		
		 ques.setEmpId(empId);
		 ques.setNoOfQuestions(noOfQuestions);
		
		 
		 String conceptList = null;
		 
		 switch(topicId){
		 	case "1" :
		 		conceptList = Constants.ARRAY;	 		
		 		break;
		 	default:
		 		break;
		 
		 }
		 
		 ques.setDifficultyLevel(difficultylevel);
			/* System.out.println("external q service "+qgb.getEntityid()); */
			/*
			 * String[] artifacts =
			 * dynamicService.generateQuestion(conceptList,ques.getEmpId(),ques.
			 * getNoOfQuestions(),ques.getEntity(),ques.getDifficultyLevel(),null);
			 */
		 String[] artifacts = dynamicService.generateQuestion(conceptList,ques.getEmpId(),ques.getNoOfQuestions(),qgb.getEntityid(),ques.getDifficultyLevel(),null);
		
			if(artifacts!=null){
				 return artifacts;
			
			
		}
		
		return null;
	
	}



	public String getEmpId() {
		return empId;
	}



	public void setEmpId(String empId) {
		this.empId = empId;
	}



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	public InputStream getFile() {
		return file;
	}



	public void setFile(InputStream file) {
		this.file = file;
	}



	public int getTopicId() {
		return topicId;
	}



	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

}
