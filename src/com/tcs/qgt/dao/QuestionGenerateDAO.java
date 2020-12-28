package com.tcs.qgt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tcs.ilp.iquest.action.ExternalQuestionService;
import com.tcs.ilp.iquest.util.DbTransaction;
import com.tcs.qgt.bean.LoginBean;
import com.tcs.qgt.bean.QuestionGenerateBean;

public class QuestionGenerateDAO {

	public static void display() {
		QuestionGenerateBean qgb = new QuestionGenerateBean();
		LoginBean lb = new LoginBean();
		ExternalQuestionService eqs = new ExternalQuestionService();
		Connection con = DbTransaction.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		int entityId ;
		String query;
		
		System.out.println(qgb.getEntity());
		System.out.println(qgb.getLevel());
		System.out.println(qgb.getOperation());
		System.out.println(qgb.getNoOfQuestions());
		System.out.println(qgb.getPublicTestCase());
		System.out.println(qgb.getPrivateTestCase());
		System.out.println(qgb.getLevel1checkcount());
		System.out.println(qgb.getLevel2checkcount());
		
		System.out.println(lb.getUsername());
		String empid = lb.getUsername();
		
		query = "select * from tbl_entity where title = '"+ qgb.getEntity()  +"'";
		try {
			stmt = con.createStatement();
			 rs = stmt.executeQuery(query);
			 while(rs.next())
			 {
				 entityId = rs.getInt("entity_id");
				 qgb.setEntityid(entityId);
				 System.out.println("db enity"+entityId);
			 }
			
				 eqs.generateQuestion(empid, "1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
