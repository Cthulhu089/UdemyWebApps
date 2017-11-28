package com.udemy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentJDBCQuery {
   private String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
   private String DATABASE_URL = "jdbc:mysql://localhost/School?serverTimezone=UTC";
   private String USER = "root";
   private String PASSWORD = "marco089";
   
   public void readDataBase() {
	   Connection connection = null;
	   Statement statement = null;
	   ResultSet resultSet = null;
	   try{
		   Class.forName(JDBC_Driver);
		   
		   connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
		   statement = connection.createStatement();
		   
		   String sqlCommand = "Select * from student";
		   resultSet = statement.executeQuery(sqlCommand);
		   
		   while (resultSet.next()) {
			   int id = resultSet.getInt("id");
			   String name = resultSet.getString("name");
			   int age = resultSet.getInt("age");
			   Student student = new Student(id, name, age);
			   
			   System.out.println(student);
		   }
	   } catch(Exception e){
		   e.printStackTrace();		   
	   } finally {
		   try {
			resultSet.close();
			statement.close();
			connection.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   }
   }
}
