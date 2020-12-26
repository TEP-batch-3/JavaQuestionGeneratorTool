package com.tcs.ilp.iquest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.ilp.iquest.util.DbTransaction;

public class AdminDAO {

	
	public  static String getAdminDetails(int empId)
	{
		Connection con=DbTransaction.getConnection();;
		PreparedStatement ps=null;
		
		String name = "";
		String query = "select admin_name from tbl_admin where admin_id = ?";		
		ResultSet rs = null;
		try
		{
			ps = con.prepareStatement(query);
			ps.setInt(1, empId);
			rs = ps.executeQuery();
			while(rs.next())
			{
				name = rs.getString(1);
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getAdminDetails"+ex.getMessage());
			ex.printStackTrace();
		
		}
		finally
		{

			try
			{
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
			}
			catch (SQLException e) {
				System.out.println("SQLException in closing resources in getAdminDetails" +e.getMessage());
				e.printStackTrace();
			}
		}
		
		return name ;
	}
}
