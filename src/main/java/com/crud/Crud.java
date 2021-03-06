package com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pojo.Students;

public class Crud {

	public Connection getConnection()
	{
		 Connection conn =null;
		 String url ="jdbc:mysql://localhost:3306/demo";
		 String user = "root";
		 String pass ="Shidhu@bhadra01";
			
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn =DriverManager.getConnection(url,user,pass);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return conn;

		}
	
	
		public ArrayList<Students> getData()
		{
			ArrayList<Students> ALLStudents =new ArrayList<Students>();
			String Name, Address,Department;
			int id;
			try {
			 Connection conn = getConnection();
			 String sql_query="SELECT * from students";
			 PreparedStatement pst = conn.prepareStatement(sql_query);
			 //System.out.println(pst);
			 
			 ResultSet rs = pst.executeQuery();
			
			 while(rs.next())
			 {
					Students s = new Students();
				 	id = rs.getInt("ID");
				 	Name = rs.getString("Name");
					Address = rs.getString("Address");
					Department = rs.getString("Department");
					
					//System.out.println("ID is "+id+" "+"Name is "+Name);
					
					s.setID(id);
					s.setName(Name);
					s.setAddress(Address);
					s.setDepartment(Department);
					
					
					ALLStudents.add(s);
					
					
			 }
			 
			 for(Students stud: ALLStudents)
			 {
				 System.out.println(stud.toString());
			 }
			 
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("exception occur");
			}
			
			return ALLStudents;
			
		
		}
		
		
		
}
