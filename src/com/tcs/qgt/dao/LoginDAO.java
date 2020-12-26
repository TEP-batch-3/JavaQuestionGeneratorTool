package com.tcs.qgt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tcs.ilp.iquest.util.DbTransaction;
import com.tcs.qgt.bean.LoginBean;

public class LoginDAO {

	public void getAdminDeatil() {
		Connection con = DbTransaction.getConnection();
		LoginBean lb = new LoginBean();
		
		Statement stmt = null;
		ResultSet rs = null;
		String role = null;
		String dbusername = null;
		String dbpassword =null;
		
		String Username = lb.getUsername();
		String Password = lb.getPassword();
		
		// query to select the user is admin or not
		String query = "select * from users where username = '"+ Username +"' and password = '"+ Password +"'";		
			System.out.println(query);	
		try
		{	
			 stmt = con.createStatement();
			 rs = stmt.executeQuery(query);
			 while(rs.next())
			 {
				dbusername = rs.getString("username");
				dbpassword = rs.getString("password");
				role = rs.getString("role");
				if(dbusername.equals(Username) && dbpassword.equals(Password) && role.equals("user")) 
				{
					role = "user";
					System.out.println(role);
					lb.setRole(role);
				}
//				else if(dbusername.equals(Username) && dbpassword.equals(Password) && role.equals("admin")) 
//				{
//					role = "admin";
//					lb.setRole(role);
//				}
				else 
				{
					role = null;
					lb.setRole(role);
				}
			 }
		}
		catch(Exception e) {
			System.out.println("SQLException in getAdminDetails"+e.getMessage());
			e.printStackTrace();
		}
		finally {
			try
			{
				if(con!=null)
					con.close();
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
			}
			catch (SQLException e) {
				System.out.println("SQLException in closing resources in getAdminDetails" +e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println(Username);
		System.out.println(Password);

	}

		
	}
