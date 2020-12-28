package com.tcs.qgt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.iquest.util.DbTransaction;
import com.tcs.qgt.bean.QuestionGenerateBean;
import com.tcs.qgt.dao.QuestionGenerateDAO;

/**
 * Servlet implementation class QuestionGenrateServlet
 */
@WebServlet("/QuestionGenrateServlet")
public class QuestionGenrateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionGenrateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter out = response.getWriter();
		QuestionGenerateBean qgb = new QuestionGenerateBean();
		Connection conn = DbTransaction.getConnection();
		Statement stmt =null;
		ResultSet rs = null;
		String query = null;
		
		String[] l1operations;
		String[] l2operations;
		int checkcount1;
		int checkcount2;
		int level ;
		int noq ;
		int ptc ;
		int ptcs;
		System.out.println("Entity : "+request.getParameter("entity"));
		System.out.println("Operation Level : "+request.getParameter("level"));
		System.out.println("No Of Questions : "+request.getParameter("NOQ"));
		System.out.println("Public Test Cases : "+request.getParameter("PTC"));
		System.out.println("Private Test Cases : "+request.getParameter("PTCS"));
		System.out.println("No Of Oprations Selected in level 1 :"+request.getParameter("checkcount1"));
		System.out.println("No Of Oprations Selected in level 2 :"+request.getParameter("checkcount2"));
		
		
		l1operations = request.getParameterValues("level1Operations");
		l2operations = request.getParameterValues("level2Operations");
		
//		System.out.println(l1operations.length);
//		System.out.println(l2operations.length);
		
		level = Integer.parseInt(request.getParameter("level"));
		noq = Integer.parseInt(request.getParameter("NOQ"));
		ptc = Integer.parseInt(request.getParameter("PTC"));
		ptcs = Integer.parseInt(request.getParameter("PTCS"));
		checkcount1 = Integer.parseInt(request.getParameter("checkcount1"));
		checkcount2 =Integer.parseInt(request.getParameter("checkcount2"));
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();

		if(level == 1 && checkcount1 == 0 ) {
			query = "Select * from TBL_OPERATION where level = 1";
    		try{
    			 stmt = conn.createStatement();
    			 rs = stmt.executeQuery(query);
    			 while(rs.next())
					{
    				 String title = new String(rs.getString("title"));
    			        l1.add(title);
					}
    		}catch (SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}	System.out.println("Default Level 1 Operations :");
    		 for(int i= 0; i<l1.size();i++) {
					System.out.println(l1.get(i));	
			}
    		qgb.setOperation(l1); 
		}else if(level == 1 && checkcount1 > 0 ) {
			l1 = Arrays.asList(l1operations);
			System.out.println("User Level 1 Operations :");
			 for(int i= 0; i<l1.size();i++) {
					System.out.println(l1.get(i));	
			}
			 qgb.setOperation(l1);
		}else if(level == 2 && checkcount2 == 0 ) {
			query = "Select * from TBL_OPERATION where level = 2";
    		try{
    			 stmt = conn.createStatement();
    			 rs = stmt.executeQuery(query);
    			 while(rs.next())
					{
    				 String title = new String(rs.getString("title"));
    			        l2.add(title);
					}
    		}catch (SQLException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}System.out.println("Default Level 2 Operations :");
    		for(int i= 0; i<l2.size();i++) {
				System.out.println(l2.get(i));	
			}
    		qgb.setOperation(l2);
		}else if(level == 2 && checkcount2 > 0 ) {
			l2 = Arrays.asList(l2operations);
			System.out.println("User Level 2 Operations :");
			for(int i= 0; i<l2.size();i++) {
				System.out.println(l2.get(i));	
			}
			qgb.setOperation(l2);
		}

		qgb.setEntity(request.getParameter("entity"));
		qgb.setLevel(level);
		qgb.setNoOfQuestions(noq);
		qgb.setPublicTestCase(ptc);
		qgb.setPrivateTestCase(ptcs);
		qgb.setLevel1checkcount(checkcount1);
		qgb.setLevel2checkcount(checkcount2);
		QuestionGenerateDAO.display();
	
		out.println("<script type=\"text/javascript\">"); 
		out.println("location='userHome.jsp';"); out.println("</script>");

	}
	}

