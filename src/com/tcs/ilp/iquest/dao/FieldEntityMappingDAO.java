package com.tcs.ilp.iquest.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import com.tcs.ilp.iquest.bean.EntityMapping;
import com.tcs.ilp.iquest.bean.FieldEntityMapping;
import com.tcs.ilp.iquest.util.DbTransaction;

public class FieldEntityMappingDAO {
	Connection con=null;
	PreparedStatement ps=null;
	 static Logger log = Logger.getLogger(FieldEntityMappingDAO.class.getName());
	
	public FieldEntityMappingDAO()
	{
		super();
		
	}
	
	/*public void addAppend()
	{
		 Layout l1 = new SimpleLayout();
		 Appender a;
		try {
			a = new FileAppender(l1, "D:\\iQuestLog\\log.txt", true);
			 log.addAppender(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public HashMap<Integer, String> getFieldMap()
	{
		HashMap<Integer, String> fieldMap = null;
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		try{
			
			String query = "Select field_id,title from tbl_field";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			fieldMap = new HashMap<Integer, String>();
			while(rs.next())
			{
				fieldMap.put(rs.getInt(1), rs.getString(2));
			}
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getFieldMap"+ex.getMessage());
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
				System.out.println("SQLException in closing resources in getFieldMap" +e.getMessage());
				e.printStackTrace();
			}
		}
		return fieldMap;
		
		
	}
	
	public HashMap<Integer, String> getEntityMap()
	{
		HashMap<Integer, String> entityMap = null;
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		try{
			
			String query = "Select entity_id,title from tbl_entity";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			entityMap = new HashMap<Integer, String>();
			while(rs.next())
			{
				entityMap.put(rs.getInt(1), rs.getString(2));
			}
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getEntityMap"+ex.getMessage());
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
				System.out.println("SQLException in closing resources in getEntityMap" +e.getMessage());
				e.printStackTrace();
			}
		}
		return entityMap;
	}
	
	public HashMap<Integer, String> getFieldTypes()
	{
		HashMap<Integer, String> fieldTypeMap = null;
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		try{
			
			String query = "Select field_type_id,field_type from tbl_field_type";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			fieldTypeMap = new HashMap<Integer, String>();
			while(rs.next())
			{
				fieldTypeMap.put(rs.getInt(1), rs.getString(2));
			}
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getFieldTypes"+ex.getMessage());
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
				System.out.println("SQLException in closing resources in getFieldTypes" +e.getMessage());
				e.printStackTrace();
			}
		}
		return fieldTypeMap;
	}
	
	public int mapData(FieldEntityMapping fieldEntMapping)
	{
		con=DbTransaction.getConnection();
		int recAdded = 0 ;
		ResultSet rs = null;
		ResultSet rs1 = null;
		try{
			
			String query = "select * from tbl_field_entity_mapping where field_id = ? and entity_id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, fieldEntMapping.getFieldId());
			ps.setInt(2, fieldEntMapping.getEntityId());
			rs1 = ps.executeQuery();
			if(!rs1.next())
			{
				query = "SELECT MAX(mapping_id) from tbl_field_entity_mapping";
				String query1 = "SET IDENTITY_INSERT tbl_field_entity_mapping ON;INSERT into tbl_field_entity_mapping" +
							" (mapping_id, field_id, entity_id, mapping_type, field_type, is_identity, is_unique, description) values (?,?,?,?,?,?,?,?);" +
							" SET IDENTITY_INSERT tbl_entity OFF";
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();
				int mappingId = 0;
				while(rs.next())
				{
					mappingId =  rs.getInt(1) +1;
					ps = con.prepareStatement(query1);
					ps.setInt(1, mappingId);
					ps.setInt(2, fieldEntMapping.getFieldId());
					ps.setInt(3, fieldEntMapping.getEntityId());
					ps.setString(4,fieldEntMapping.getMappingType());
					ps.setInt(5, fieldEntMapping.getFieldType());
					ps.setInt(6, fieldEntMapping.getIsIdentity());
					ps.setInt(7,fieldEntMapping.getIsUnique());
					ps.setString(8,fieldEntMapping.getDescription());
					recAdded = ps.executeUpdate();
				}
			}
			else 
				recAdded = 2;
			
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in fieldEntMapping"+ex.getMessage());
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
				if(rs1!=null)
					rs1.close();
				
			}
			catch (SQLException e) {
				System.out.println("SQLException in closing resources in fieldEntMapping" +e.getMessage());
				e.printStackTrace();
			}
		}
		return recAdded;
	}

	public ArrayList<EntityMapping> getFieldMap(int entityId)
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		ArrayList<EntityMapping> fieldList = null;
		try
		{
			String query = "select c.title,b.field_type,a.mapping_type,a.is_identity,a.is_unique,a.description" +
					" from tbl_field_entity_mapping a , tbl_field_type b , tbl_field c " +
					" where a.field_type = b.field_type_id and c.field_id = a.field_id and a.entity_id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, entityId);
			rs = ps.executeQuery();
			fieldList = new ArrayList<EntityMapping>();
			while(rs.next())
			{
				EntityMapping ent = new EntityMapping();
				ent.setTitle(rs.getString(1));
				ent.setFieldType(rs.getString(2));
				ent.setMappingType(rs.getString(3));
				if(rs.getInt(4) == 1)
					ent.setIsIdentity("true");
				else
					ent.setIsIdentity("false");
				if(rs.getInt(5) == 1)
					ent.setIsUnique("true");
				else
					ent.setIsUnique("false");
				ent.setDescription(rs.getString(6));
				fieldList.add(ent);
				
			}
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getFieldMap"+ex.getMessage());
			ex.printStackTrace();
		
		}finally
		{

			try
			{
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
				
			}
			catch (SQLException e) {
				System.out.println("SQLException in closing resources in getFieldMap" +e.getMessage());
				e.printStackTrace();
			}
		}
		return fieldList;
	}
	public HashMap<String,ArrayList<EntityMapping>> getFieldMapping()
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		HashMap<String,ArrayList<EntityMapping>> hm  = new HashMap<String,ArrayList<EntityMapping>>();
		ArrayList<EntityMapping> mapList = new ArrayList<EntityMapping>();
		int entity = 0;
		
		try
		{
			/*String query = "SELECT e.title,f.title, M.mapping_type,T.field_type,m.is_identity,m.is_unique,e.entity_id,t.is_entity FROM tbl_entity E " +
							"JOIN tbl_field_entity_mapping M ON M.entity_id = E.entity_id JOIN" +
							" tbl_field F ON m.field_id = f.field_id JOIN tbl_field_type T ON T.field_type_id = m.field_type where e.entity_id = " +
							"(select TOP 1 entity_id from tbl_entity where usage = (select min(usage) from tbl_entity)) and t.field_type not in(select title from tbl_entity)";*/
			/*String query = "SELECT e.title,f.title, M.mapping_type,T.field_type,m.is_identity,m.is_unique,e.entity_id,t.is_entity FROM IQUEST.tbl_entity E " +
			"JOIN IQUEST.tbl_field_entity_mapping M ON M.entity_id = E.entity_id JOIN" +
			" IQUEST.tbl_field F ON m.field_id = f.field_id JOIN IQUEST.tbl_field_type T ON T.field_type_id = m.field_type where e.entity_id = " +
			"(select  entity_id from IQUEST.tbl_entity where usage = (select min(usage) from IQUEST.tbl_entity)fetch first 1 rows only) and t.field_type not in(select title from IQUEST.tbl_entity)";*/

			String query = "SELECT e.title,f.title, M.mapping_type,T.field_type,m.is_identity,m.is_unique,e.entity_id,t.is_entity FROM tbl_entity E " +
					"JOIN tbl_field_entity_mapping M ON M.entity_id = E.entity_id JOIN" +
					" tbl_field F ON m.field_id = f.field_id JOIN tbl_field_type T ON T.field_type_id = m.field_type where e.entity_id = " +
					"(select  entity_id from tbl_entity where usage = (select min(usage) from tbl_entity)fetch first 1 rows only) and t.field_type not in(select title from tbl_entity)";


		
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next())
			{
				 
				EntityMapping ent = new EntityMapping();
				ent.setTitle(rs.getString(2));
				ent.setFieldType(rs.getString(4));
				ent.setMappingType(rs.getString(3));
				if(rs.getInt(5) == 1)
					ent.setIsIdentity("true");
				else
					ent.setIsIdentity("false");
				if(rs.getInt(6) == 1)
					ent.setIsUnique("true");
				else
					ent.setIsUnique("false");
				mapList.add(ent);
				entity = rs.getInt(7) ;
				if(rs.getInt(8) == 1)
					ent.setIsEntity("true");
				else
					ent.setIsEntity("false");
			
				hm.put(rs.getString(1), mapList);
			}
			/*addAppend();
			log.debug("updating usage of"+ entity);*/
			query = "update tbl_entity set usage = (usage+1) where entity_id = ?";
			
			try{
				ps = con.prepareStatement(query);
				ps.setInt(1,entity);
				ps.executeUpdate();
				
				
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getFieldMapping"+ex.getMessage());
			ex.printStackTrace();
		
		}finally
		{

			try
			{
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
				
			}
			catch (SQLException e) {
				System.out.println("SQLException in closing resources in getFieldMapping" +e.getMessage());
				e.printStackTrace();
			}
		}
		return hm;
	}
	public HashMap<String,ArrayList<EntityMapping>> getUniDirFieldMapping()
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		HashMap<String,ArrayList<EntityMapping>> hm  = new HashMap<String,ArrayList<EntityMapping>>();
		ArrayList<EntityMapping> mapList = new ArrayList<EntityMapping>();
		int entity = 0;
		
		try
		{
			String query = "SELECT e.title,f.title, M.mapping_type,T.field_type,m.is_identity,m.is_unique,e.entity_id,t.is_entity FROM tbl_entity E " +
							"JOIN tbl_field_entity_mapping M ON M.entity_id = E.entity_id JOIN" +
							" tbl_field F ON m.field_id = f.field_id JOIN tbl_field_type T ON T.field_type_id = m.field_type where e.entity_id = " +
							"(select TOP 1 entity_id from tbl_entity where usage = (select min(usage) from tbl_entity))";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next())
			{
				 
				EntityMapping ent = new EntityMapping();
				ent.setTitle(rs.getString(2));
				ent.setFieldType(rs.getString(4));
				ent.setMappingType(rs.getString(3));
				if(rs.getInt(5) == 1)
					ent.setIsIdentity("true");
				else
					ent.setIsIdentity("false");
				if(rs.getInt(6) == 1)
					ent.setIsUnique("true");
				else
					ent.setIsUnique("false");
				mapList.add(ent);
				entity = rs.getInt(7) ;
				if(rs.getInt(8) == 1)
					ent.setIsEntity("true");
				else
					ent.setIsEntity("false");
				hm.put(rs.getString(1), mapList);
			}
			/*addAppend();
			log.debug("updating usage of"+ entity);*/
			query = "update tbl_entity set usage = (usage+1) where entity_id = ?";
			
			try{
				ps = con.prepareStatement(query);
				ps.setInt(1,entity);
				ps.executeUpdate();
				
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getUniDirFieldMapping"+ex.getMessage());
			ex.printStackTrace();
		
		}finally
		{

			try
			{
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
				
			}
			catch (SQLException e) {
				System.out.println("SQLException in closing resources in getUniDirFieldMapping" +e.getMessage());
				e.printStackTrace();
			}
		}
		return hm;
	}
	public HashMap<String,ArrayList<EntityMapping>> getFieldMapping(String title)
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		HashMap<String,ArrayList<EntityMapping>> hm  = new HashMap<String,ArrayList<EntityMapping>>();
		ArrayList<EntityMapping> mapList = new ArrayList<EntityMapping>();
		int entity = 0;
		
		try
		{
			String query = "SELECT e.title,f.title, M.mapping_type,T.field_type,m.is_identity,m.is_unique,e.entity_id,t.is_entity FROM tbl_entity E " +
							"JOIN tbl_field_entity_mapping M ON M.entity_id = E.entity_id JOIN" +
							" tbl_field F ON m.field_id = f.field_id JOIN tbl_field_type T ON T.field_type_id = m.field_type where e.entity_id = " +
							" (select entity_id from tbl_entity where title =?) and t.field_type not in(select title from tbl_entity)";
			ps = con.prepareStatement(query);
			ps.setString(1,title);
			rs = ps.executeQuery();
			while(rs.next())
			{
				 
				EntityMapping ent = new EntityMapping();
				ent.setTitle(rs.getString(2));
				ent.setFieldType(rs.getString(4));
				ent.setMappingType(rs.getString(3));
				if(rs.getInt(5) == 1)
					ent.setIsIdentity("true");
				else
					ent.setIsIdentity("false");
				if(rs.getInt(6) == 1)
					ent.setIsUnique("true");
				else
					ent.setIsUnique("false");
				mapList.add(ent);
				entity = rs.getInt(7) ;
				if(rs.getInt(8) == 1)
					ent.setIsEntity("true");
				else
					ent.setIsEntity("false");
				hm.put(rs.getString(1), mapList);
			}
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getFieldMapping"+ex.getMessage());
			ex.printStackTrace();
		
		}finally
		{

			try
			{
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
				
			}
			catch (SQLException e) {
				System.out.println("SQLException in closing resources in getFieldMapping" +e.getMessage());
				e.printStackTrace();
			}
		}
		return hm;
	}
	
	public HashMap<String,ArrayList<EntityMapping>> getBiDirFieldMapping(String title)
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		HashMap<String,ArrayList<EntityMapping>> hm  = new HashMap<String,ArrayList<EntityMapping>>();
		ArrayList<EntityMapping> mapList = new ArrayList<EntityMapping>();
		int entity = 0;
		
		try
		{
			String query = "SELECT e.title,f.title, M.mapping_type,T.field_type,m.is_identity,m.is_unique,e.entity_id,t.is_entity FROM tbl_entity E " +
							"JOIN tbl_field_entity_mapping M ON M.entity_id = E.entity_id JOIN" +
							" tbl_field F ON m.field_id = f.field_id JOIN tbl_field_type T ON T.field_type_id = m.field_type where e.entity_id = " +
							" (select entity_id from tbl_entity where title =?)";
			ps = con.prepareStatement(query);
			ps.setString(1,title);
			rs = ps.executeQuery();
			while(rs.next())
			{
				 
				EntityMapping ent = new EntityMapping();
				ent.setTitle(rs.getString(2));
				ent.setFieldType(rs.getString(4));
				ent.setMappingType(rs.getString(3));
				if(rs.getInt(5) == 1)
					ent.setIsIdentity("true");
				else
					ent.setIsIdentity("false");
				if(rs.getInt(6) == 1)
					ent.setIsUnique("true");
				else
					ent.setIsUnique("false");
				mapList.add(ent);
				entity = rs.getInt(7) ;
				if(rs.getInt(8) == 1)
					ent.setIsEntity("true");
				else
					ent.setIsEntity("false");
				hm.put(rs.getString(1), mapList);
			}
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getBiDirFieldMapping"+ex.getMessage());
			ex.printStackTrace();
		
		}finally
		{

			try
			{
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
				
			}
			catch (SQLException e) {
				System.out.println("SQLException in closing resources in getBiDirFieldMapping" +e.getMessage());
				e.printStackTrace();
			}
		}
		return hm;
	}
	public HashMap<String,ArrayList<EntityMapping>> getInheritanceMapping()
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		HashMap<String,ArrayList<EntityMapping>> hm  = new HashMap<String,ArrayList<EntityMapping>>();
		ArrayList<EntityMapping> mapList = new ArrayList<EntityMapping>();
		int entity = 0;
		
		try
		{
			String query = "SELECT e.title,f.title, M.mapping_type,T.field_type,m.is_identity,m.is_unique,e.entity_id,e.usage FROM tbl_entity E " +
							"JOIN tbl_field_entity_mapping M ON M.entity_id = E.entity_id JOIN" +
							" tbl_field F ON m.field_id = f.field_id JOIN tbl_field_type T ON T.field_type_id = m.field_type " +
							"where e.entity_id  in (select parent_id from tbl_entity_parent_child_mapping) " +
							"and t.field_type not in(select title from tbl_entity) order by e.usage";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next())
			{
				if(entity == 0 || entity == rs.getInt(7))
				{
					 
					EntityMapping ent = new EntityMapping();
					ent.setTitle(rs.getString(2));
					ent.setFieldType(rs.getString(4));
					ent.setMappingType(rs.getString(3));
					if(rs.getInt(5) == 1)
						ent.setIsIdentity("true");
					else
						ent.setIsIdentity("false");
					if(rs.getInt(6) == 1)
						ent.setIsUnique("true");
					else
						ent.setIsUnique("false");
					mapList.add(ent);
					entity = rs.getInt(7) ;
				
					hm.put(rs.getString(1), mapList);
				}
				else
					break;
			}
			/*addAppend();
			log.debug("updating usage of"+ entity);*/
			query = "update tbl_entity set usage = (usage+1) where entity_id = ?";
			
			try{
				ps = con.prepareStatement(query);
				ps.setInt(1,entity);
				ps.executeUpdate();
				
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getInheritanceMapping"+ex.getMessage());
			ex.printStackTrace();
		
		}finally
		{

			try
			{
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
				
			}
			catch (SQLException e) {
				System.out.println("SQLException in closing resources in getInheritanceMapping" +e.getMessage());
				e.printStackTrace();
			}
		}
		return hm;
	}
	
	public HashMap<String,ArrayList<EntityMapping>> getParentChildMapping(String title)
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		HashMap<String,ArrayList<EntityMapping>> hm  = new HashMap<String,ArrayList<EntityMapping>>();
		ArrayList<EntityMapping> mapList = new ArrayList<EntityMapping>();
		int entity = 0;
		
		try
		{
			String query = "SELECT e.title,f.title, M.mapping_type,T.field_type,m.is_identity,m.is_unique,e.entity_id,e.usage FROM tbl_entity E " +
							"JOIN tbl_field_entity_mapping M ON M.entity_id = E.entity_id JOIN " +
							"tbl_field F ON m.field_id = f.field_id JOIN tbl_field_type T ON T.field_type_id = m.field_type " +
							"where e.entity_id  = (select child_id from tbl_entity_parent_child_mapping where parent_id = " +
							"(select entity_id from tbl_entity where title = ?)) and t.field_type not in(select title from tbl_entity)";
			ps = con.prepareStatement(query);
			ps.setString(1,title);
			rs = ps.executeQuery();
			while(rs.next())
			{ 
					EntityMapping ent = new EntityMapping();
					ent.setTitle(rs.getString(2));
					ent.setFieldType(rs.getString(4));
					ent.setMappingType(rs.getString(3));
					if(rs.getInt(5) == 1)
						ent.setIsIdentity("true");
					else
						ent.setIsIdentity("false");
					if(rs.getInt(6) == 1)
						ent.setIsUnique("true");
					else
						ent.setIsUnique("false");
					mapList.add(ent);
					entity = rs.getInt(7) ;
				
					hm.put(rs.getString(1), mapList);
				
			}
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getParentChildMapping"+ex.getMessage());
			ex.printStackTrace();
		
		}finally
		{

			try
			{
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
				
			}
			catch (SQLException e) {
				System.out.println("SQLException in closing resources in getParentChildMapping" +e.getMessage());
				e.printStackTrace();
			}
		}
		return hm;
	} 
	public HashMap<String,ArrayList<EntityMapping>> getFieldMapping(int entityId)
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		HashMap<String,ArrayList<EntityMapping>> hm  = new HashMap<String,ArrayList<EntityMapping>>();
		ArrayList<EntityMapping> mapList = new ArrayList<EntityMapping>();
		int entity = 0;
		
		try
		{
			String query = "SELECT e.title,f.title, M.mapping_type,T.field_type,m.is_identity,m.is_unique,e.entity_id,t.is_entity FROM tbl_entity E " +
							"JOIN tbl_field_entity_mapping M ON M.entity_id = E.entity_id JOIN" +
							" tbl_field F ON m.field_id = f.field_id JOIN tbl_field_type T ON T.field_type_id = m.field_type where e.entity_id = ?" +
							" and t.field_type not in(select title from tbl_entity)";
			ps = con.prepareStatement(query);
			ps.setInt(1, entityId);
			rs = ps.executeQuery();
			while(rs.next())
			{
				 
				EntityMapping ent = new EntityMapping();
				ent.setTitle(rs.getString(2));
				ent.setFieldType(rs.getString(4));
				ent.setMappingType(rs.getString(3));
				if(rs.getInt(5) == 1)
					ent.setIsIdentity("true");
				else
					ent.setIsIdentity("false");
				if(rs.getInt(6) == 1)
					ent.setIsUnique("true");
				else
					ent.setIsUnique("false");
				mapList.add(ent);
				entity = rs.getInt(7) ;
				if(rs.getInt(8) == 1)
					ent.setIsEntity("true");
				else
					ent.setIsEntity("false");
			
				hm.put(rs.getString(1), mapList);
			}
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getFieldMapping"+ex.getMessage());
			ex.printStackTrace();
		
		}finally
		{

			try
			{
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
				
			}
			catch (SQLException e) {
				System.out.println("SQLException in closing resources in getFieldMapping" +e.getMessage());
				e.printStackTrace();
			}
		}
		return hm;
	}
	public HashMap<String,ArrayList<EntityMapping>> getUniDirFieldMapping(int entityId)
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		HashMap<String,ArrayList<EntityMapping>> hm  = new HashMap<String,ArrayList<EntityMapping>>();
		ArrayList<EntityMapping> mapList = new ArrayList<EntityMapping>();
		int entity = 0;
		
		try
		{
			String query = "SELECT e.title,f.title, M.mapping_type,T.field_type,m.is_identity,m.is_unique,e.entity_id,t.is_entity FROM tbl_entity E " +
							"JOIN tbl_field_entity_mapping M ON M.entity_id = E.entity_id JOIN" +
							" tbl_field F ON m.field_id = f.field_id JOIN tbl_field_type T ON T.field_type_id = m.field_type where e.entity_id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, entityId);
			rs = ps.executeQuery();
			while(rs.next())
			{
				 
				EntityMapping ent = new EntityMapping();
				ent.setTitle(rs.getString(2));
				ent.setFieldType(rs.getString(4));
				ent.setMappingType(rs.getString(3));
				if(rs.getInt(5) == 1)
					ent.setIsIdentity("true");
				else
					ent.setIsIdentity("false");
				if(rs.getInt(6) == 1)
					ent.setIsUnique("true");
				else
					ent.setIsUnique("false");
				mapList.add(ent);
				entity = rs.getInt(7) ;
				if(rs.getInt(8) == 1)
					ent.setIsEntity("true");
				else
					ent.setIsEntity("false");
				hm.put(rs.getString(1), mapList);
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getUniDirFieldMapping"+ex.getMessage());
			ex.printStackTrace();
		
		}finally
		{

			try
			{
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
				
			}
			catch (SQLException e) {
				System.out.println("SQLException in closing resources in getUniDirFieldMapping" +e.getMessage());
				e.printStackTrace();
			}
		}
		return hm;
	}
	public HashMap<String,ArrayList<EntityMapping>> getInheritanceMapping(int entityId)
	{
		con=DbTransaction.getConnection();
		ResultSet rs = null;
		HashMap<String,ArrayList<EntityMapping>> hm  = new HashMap<String,ArrayList<EntityMapping>>();
		ArrayList<EntityMapping> mapList = new ArrayList<EntityMapping>();
		int entity = 0;
		
		try
		{
			String query = "SELECT e.title,f.title, M.mapping_type,T.field_type,m.is_identity,m.is_unique,e.entity_id,e.usage FROM tbl_entity E " +
							"JOIN tbl_field_entity_mapping M ON M.entity_id = E.entity_id JOIN" +
							" tbl_field F ON m.field_id = f.field_id JOIN tbl_field_type T ON T.field_type_id = m.field_type " +
							"where e.entity_id  in (select parent_id from tbl_entity_parent_child_mapping where parent_id = ?) " +
							"and t.field_type not in(select title from tbl_entity)";
			ps = con.prepareStatement(query);
			ps.setInt(1, entityId);
			rs = ps.executeQuery();
			while(rs.next())
			{
				if(entity == 0 || entity == rs.getInt(7))
				{
					 
					EntityMapping ent = new EntityMapping();
					ent.setTitle(rs.getString(2));
					ent.setFieldType(rs.getString(4));
					ent.setMappingType(rs.getString(3));
					if(rs.getInt(5) == 1)
						ent.setIsIdentity("true");
					else
						ent.setIsIdentity("false");
					if(rs.getInt(6) == 1)
						ent.setIsUnique("true");
					else
						ent.setIsUnique("false");
					mapList.add(ent);
					entity = rs.getInt(7) ;
				
					hm.put(rs.getString(1), mapList);
				}
				else
					break;
			}			
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException in getInheritanceMapping"+ex.getMessage());
			ex.printStackTrace();
		
		}finally
		{

			try
			{
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
				
			}
			catch (SQLException e) {
				System.out.println("SQLException in closing resources in getInheritanceMapping" +e.getMessage());
				e.printStackTrace();
			}
		}
		return hm;
	}
}
