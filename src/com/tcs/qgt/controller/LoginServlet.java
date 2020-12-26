package com.tcs.qgt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.qgt.bean.LoginBean;
import com.tcs.qgt.dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		LoginBean lb = new LoginBean();
		
		// user entered data
		String user = request.getParameter("username");
		String password = request.getParameter("pass");
		
		lb.setUsername(user);
		lb.setPassword(password);
		
		LoginDAO ldao = new LoginDAO();
		ldao.getAdminDeatil();
		
		String Role = lb.getRole();
		System.out.println(Role);
		
		if(Role == null)
		{
			out.println("<script type=\"text/javascript\">"); 
			out.println("alert('Unsuccusfully Logined');");
			out.println("location='login.jsp';"); out.println("</script>");
		}
		else if(Role.equals("user")) {
			out.println("<script type=\"text/javascript\">"); 
		//	out.println("alert('Succusfully Logined');");
			out.println("location='userHome.jsp';"); out.println("</script>");
		}
//		else if(role.equals("admin")) {
//			out.println("<script type=\"text/javascript\">"); 
//		//	out.println("alert('Succusfully Logined');");
//			out.println("location='adminHome.jsp';"); out.println("</script>");
//		}
		 HttpSession session=request.getSession();  
	        session.setAttribute("Role", Role);
	        session.setAttribute("user", user);
	}

}
