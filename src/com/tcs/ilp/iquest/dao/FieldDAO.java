package com.tcs.ilp.iquest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.iquest.util.DbTransaction;

public class FieldDAO {

	Connection con=null;
	PreparedStatement ps=null;
	
	public FieldDAO() {
		super();
	}
	
	public int addField(String field)
	{
		con=DbTransaction.getConnection();
		int recAdded = 0 ;
		ResultSet rs = null;
		try
		{

			String query1 = "select count(*) from tbl_field where upper(title)= ?";
			ps = con.prepareStatement(query1);
			ps.setString(1, field);
			rs = ps.executeQuery();
			boolean flag = false;
			while(rs.next())
			{
				if(rs.getInt(1) > 0)
				{
					flag = true;
					recAdded = 2 ;
				}
			}
			if(!flag)
			{
				String query2 = "SELECT MAX(field_id) from tbl_field";
				String query3 = "SET IDENTITY_INSERT tbl_field ON;INSERT into tbl_field(field_id,title) values (?,?);SET IDENTITY_INSERT tbl_field OFF";
				ps = con.prepareStatement(query2);
				rs = ps.executeQuery();
				int field_id = 0;
				
				while(rs.next())
				{
					field_id = rs.getInt(1) +1;
					ps = con.prepareStatement(query3);
					ps.setInt(1, field_id);
					ps.setString(2, field);
					recAdded = ps.executeUpdate();
				}
			}
		
			
			
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in addField"+ex.getMessage());
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
				System.out.println("SQLException in closing resources in addField" +e.getMessage());
				e.printStackTrace();
			}
		}
		
		
		return recAdded;
	}
	
	public ArrayList<String> getFields()
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		ArrayList<String> fieldList = new ArrayList<String>();
		try
		{
			String query1 = "select title from tbl_field ";
			ps = con.prepareStatement(query1);
			rs = ps.executeQuery();
			while(rs.next())
			{
				fieldList.add(rs.getString(1));
			}
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getFields"+ex.getMessage());
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
				System.out.println("SQLException in closing resources in getFields" +e.getMessage());
				e.printStackTrace();
			}
		}
		return fieldList;
		
	}
}
