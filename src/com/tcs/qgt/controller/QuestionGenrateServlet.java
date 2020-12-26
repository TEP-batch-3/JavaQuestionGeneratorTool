package com.tcs.qgt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		System.out.println("request.getParameter()");
		System.out.println(request.getParameter("entity"));
		System.out.println(request.getParameter("level"));
		/* System.out.println(request.getParameter("operation")); */
		/* System.out.println(request.getParameter("levels")); */
		System.out.println(request.getParameter("NOQ"));
		System.out.println(request.getParameter("PTC"));
		System.out.println(request.getParameter("PTCS"));
		System.out.println("end");
		
		String[] l1operations = request.getParameterValues("level1Operations");
		String[] l2operations = request.getParameterValues("level2Operations");
		
		
		int level = Integer.parseInt(request.getParameter("level"));
		int noq = Integer.parseInt(request.getParameter("NOQ"));
		int ptc = Integer.parseInt(request.getParameter("PTC"));
		int ptcs = Integer.parseInt(request.getParameter("PTCS"));
		List l1 = null;
		List l2 = null;
		
		if(level == 1  ) {
			 l1 = Arrays.asList(l1operations);
			 for(int i= 0; i<l1.size();i++) {
					System.out.println(l1.get(i));	
			}
		}else if (level == 2) {
			 l2 = Arrays.asList(l2operations);
			 for(int i= 0; i<l2.size();i++) {
					System.out.println(l2.get(i));	
				}
		}
		
		
		
		qgb.setEntity(request.getParameter("entity"));
		qgb.setLevel(level);
		/* qgb.setOperation(request.getParameter("operation")); */
		qgb.setNoOfQuestions(noq);
		qgb.setPublicTestCase(ptc);
		qgb.setPrivateTestCase(ptcs);
		
		QuestionGenerateDAO.display();
		
		out.println("<script type=\"text/javascript\">"); 
		out.println("location='userHome.jsp';"); out.println("</script>");

	}

}
