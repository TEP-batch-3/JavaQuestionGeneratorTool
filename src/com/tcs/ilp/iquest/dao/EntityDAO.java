package com.tcs.ilp.iquest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.tcs.ilp.iquest.bean.Entity;
import com.tcs.ilp.iquest.bean.Inheritance;
import com.tcs.ilp.iquest.util.DbTransaction;
import com.tcs.qgt.bean.QuestionGenerateBean;



public class EntityDAO {
	
	Connection con=null;
	PreparedStatement ps=null;
	
	public EntityDAO() {
		super();		
	}
	
	public int addEntity(String entity)
	{
		con=DbTransaction.getConnection();
		int recAdded = 0 ;
		ResultSet rs = null;
		try
		{
			String query1 = "select count(*) from tbl_entity where upper(title)= ?";
			ps = con.prepareStatement(query1);
			ps.setString(1, entity);
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
				String query2 = "SELECT MAX(entity_id) from tbl_entity";
				String query3 = "SET IDENTITY_INSERT tbl_entity ON;INSERT into tbl_entity(entity_id,title,usage) values (?,?,?);SET IDENTITY_INSERT tbl_entity OFF";
				ps = con.prepareStatement(query2);
				rs = ps.executeQuery();
				int entity_id = 0;
				
				while(rs.next())
				{
					entity_id = rs.getInt(1) +1;
					ps = con.prepareStatement(query3);
					ps.setInt(1, entity_id);
					ps.setString(2, entity);
					ps.setInt(3, 0);
					recAdded = ps.executeUpdate();
					if(recAdded > 0)
					{
						
						addFieldType(entity_id,entity);
						String query4 = "update tbl_entity set usage = 0 where usage is not null";
						ps = con.prepareStatement(query4);
						ps.executeUpdate();
						//System.out.println(recAdded);
						
					}
				}
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in addEntity"+ex.getMessage());
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
				System.out.println("SQLException in closing resources in addEntity" +e.getMessage());
				e.printStackTrace();
			}
		}
		
		return recAdded;
	}
	
	public int addFieldType(int entity_id, String entity)
	{
		Connection con=DbTransaction.getConnection();
		int recAdded = 0 ;
		ResultSet rs = null;
		try{
			
			String query2 = "SELECT MAX(field_type_id) from tbl_field_type";
			String query = "SET IDENTITY_INSERT tbl_field_type ON;INSERT into tbl_field_type(field_type_id, field_type, is_primitive, is_entity, ref_entity_id, default_value) values (?,?,?,?,?,?);SET IDENTITY_INSERT tbl_entity OFF";
			ps = con.prepareStatement(query2);
			rs = ps.executeQuery();
			int field_type_id = 0;
			while(rs.next())
			{
				field_type_id = rs.getInt(1) +1;
				ps = con.prepareStatement(query);
				ps.setInt(1, field_type_id);
				ps.setString(2,entity);
				ps.setInt(3, 0);
				ps.setInt(4, 1);
				ps.setInt(5, entity_id);
				ps.setString(6,null);
				recAdded = ps.executeUpdate();
				
				
			}
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in addFieldType"+ex.getMessage());
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
				
			}
			catch (SQLException e) {
				System.out.println("SQLException in closing resources in addFieldType" +e.getMessage());
				e.printStackTrace();
			}
		}
		return recAdded;
	}
	public ArrayList<String> getEntities()
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		ArrayList<String> entityList = new ArrayList<String>();
		try
		{
			String query1 = "select title from tbl_entity";
			ps = con.prepareStatement(query1);
			rs = ps.executeQuery();
			while(rs.next())
			{
				entityList.add(rs.getString(1));
			}
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getEntities"+ex.getMessage());
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
				System.out.println("SQLException in closing resources in getEntities" +e.getMessage());
				e.printStackTrace();
			}
		}
		return entityList;
		
	}
	public ArrayList<Entity> getEntityList()
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		ArrayList<Entity> entityList = new ArrayList<Entity>();
		QuestionGenerateBean qgb = new QuestionGenerateBean();
		int entity_id = qgb.getEntityid();
		System.out.println("inside entityDAO"+entity_id);
		try
		{
			//entity title will select based on the entity id :edited by Gowtham
			String query1 = "select * from tbl_entity where entity_id = ?";
			ps = con.prepareStatement(query1);
			ps.setInt(1, entity_id);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Entity ent = new Entity();
				ent.setEntityId(rs.getInt(1));
				ent.setTitle(rs.getString(2));
				entityList.add(ent);
			}
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getEntities"+ex.getMessage());
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
				System.out.println("SQLException in closing resources in getEntities" +e.getMessage());
				e.printStackTrace();
			}
		}
		return entityList;
	}
	
	public int mapParentChild(int parentId,int childId)
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		
		try{
			
			String query = "Select * from tbl_entity_parent_child_mapping where child_id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1,childId);
			rs = ps.executeQuery();
			if(!rs.next())
			{
				query = "INSERT into tbl_entity_parent_child_mapping(parent_id,child_id) values (?,?)";
				ps = con.prepareStatement(query);
				ps.setInt(1,parentId);
				ps.setInt(2, childId);
				return ps.executeUpdate();
			}
			else 
				return 2;
			
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in mapParentChild"+ex.getMessage());
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
				System.out.println("SQLException in closing resources in mapParentChild" +e.getMessage());
				e.printStackTrace();
			}
		}
		return 0;
	}
	public ArrayList<Inheritance> getMappingList()
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		ArrayList<Inheritance> mapList = new ArrayList<Inheritance>();
		try
		{
			String query1 = "select a.title, c.title from tbl_entity a ,tbl_entity_parent_child_mapping b ,tbl_entity c where a.entity_id = b.parent_id and c.entity_id = b.child_id";
			ps = con.prepareStatement(query1);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Inheritance inh = new Inheritance();
				inh.setParentEntity(rs.getString(1));
				inh.setChildEntity(rs.getString(2));
				mapList.add(inh);
								
			}
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getMappingList"+ex.getMessage());
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
				System.out.println("SQLException in closing resources in getMappingList" +e.getMessage());
				e.printStackTrace();
			}
		}
		return mapList;
		
	}
}
