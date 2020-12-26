package com.tcs.ilp.iquest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.iquest.bean.Concept;
import com.tcs.ilp.iquest.bean.Entity;

import com.tcs.ilp.iquest.bean.Fields;
import com.tcs.ilp.iquest.util.DbTransaction;


public class IQuestDAO 
{
	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	Connection con=null;
	
	public IQuestDAO() {
		super();		
	}
	public ArrayList<Concept> getConceptDetail()
	{
		ArrayList<Concept> conceptsList=new ArrayList<Concept>();
		Connection con=DbTransaction.getConnection();
		String query="select * from tbl_concept";
		try
		{
		ps=con.prepareStatement(query);	
		rs1=ps.executeQuery();
		while(rs1.next())
		{
			Concept concept=new Concept(rs1.getInt("concept_id"), rs1.getString("title"));
			conceptsList.add(concept);
		}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
				if(rs1!=null)
					rs1.close();
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return conceptsList;
	}
	
	public ArrayList<Entity> getEntityList()
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		ArrayList<Entity> entityList = new ArrayList<Entity>();
		try
		{
			String query1 = "select * from tbl_entity";
			ps = con.prepareStatement(query1);
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
	public int getConceptDetail(String concept)
	{
		Connection con=DbTransaction.getConnection();
		String query="select concept_id from tbl_concept where title = ?";
		int conceptId = 0;
		try
		{
		ps=con.prepareStatement(query);	
		ps.setString(1,concept);
		rs1=ps.executeQuery();
		while(rs1.next())
		{
			conceptId = rs1.getInt(1);
		}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
				if(rs1!=null)
					rs1.close();
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return conceptId;
	}
	public void audit(int empId,String concept,int questions)
	{
		int conceptId = getConceptDetail(concept);
		Connection con=DbTransaction.getConnection();
		String query = "INSERT INTO tbl_trainee_audit(trainee_id,date_time,concept_id,scenario_id,question_count) values(?,GETDATE(),?,?,?)";
		try
		{
			ps=con.prepareStatement(query);	
			ps.setInt(1,empId);
			ps.setInt(2,conceptId);
			ps.setInt(3,6);
			ps.setInt(4,questions);
			ps.executeUpdate();
			
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
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
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public void auditDST(int empId,String concept,int questions)
	{
		int conceptId = getConceptDetail(concept);
		Connection con=DbTransaction.getConnection();
		String query = "INSERT INTO tbl_trainee_audit_dst(trainee_id,date_time,concept_id,scenario_id,question_count) values(?,GETDATE(),?,?,?)";
		try
		{
			ps=con.prepareStatement(query);	
			ps.setInt(1,empId);
			ps.setInt(2,conceptId);
			ps.setInt(3,6);
			ps.setInt(4,questions);
			ps.executeUpdate();
			
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
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
				System.out.println(e.getMessage());
			}
		}
		
	}
}
