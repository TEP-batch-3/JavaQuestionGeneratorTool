package com.tcs.ilp.iquest.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.iquest.dao.AdminDAO;

//import com.tcs.ilp.evaluation.bean.Trainee;
//import com.tcs.ilp.evaluation.dao.EvaluationDAO;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//	doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int currentUser = 0;
		String finalString = request.getParameter("empId");


        int size = finalString.length() / 3;

        String newOne = finalString.substring(finalString.length() - size);
        String newTwo = finalString.substring(finalString.length() - size - size,finalString.length() - size);
        String newThree = finalString.substring(0,finalString.length() - size - size);

        String newFinalString = reverse(newOne) + reverse(newTwo) + reverse(newThree);

        int empId = (int)Math.sqrt(Double.parseDouble(newFinalString));
        
       
        
	HttpSession session = request.getSession();
    session.setAttribute("currUser",empId);
   // System.out.println("currentUser" +currentUser);
    currentUser = Integer.parseInt(empId+"");
    String name = AdminDAO.getAdminDetails(currentUser);
   
    
    if(name.equals(""))
    {
    	//System.out.println("Trainee is :::"+trainee);
    	 session.setAttribute("user",currentUser);
    	request.getRequestDispatcher("studentHome.jsp").forward(request, response);
    }
    else
    {
    	//System.out.println("Error in retrieving assigned trainee for evaluation. Error occurred for login: "+currentUser);
    	session.setAttribute("user",name);
    	request.getRequestDispatcher("adminHome.jsp").forward(request, response);
		
    }
		
	}

	public static String reverse(String text)
    {
        char[] cArray = text.toCharArray();
        String reverse = "";
        for (int i = cArray.length - 1; i > -1; i--)
        {
            reverse += cArray[i];
        }
        return reverse;
    }
}
