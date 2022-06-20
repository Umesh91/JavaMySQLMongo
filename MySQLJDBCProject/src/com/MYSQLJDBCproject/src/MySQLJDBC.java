/**
 * 
 */
package com.MYSQLJDBCproject.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Umesh
 *
 */
public class MySQLJDBC 
{
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    //Custom method to get the database info
    public void getDatabaseInfo() throws Exception
    {
    	
    	try 
    	{
    		//instructs the JVM that for mysql database we are loading the drivers
    		//in short we are communicating with MySQL databases.
    		//driver registration
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connect with Database.
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","Shree@#919");
			// Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            //execute the INSERT query
            //insertExecute();
            //updateExecute();
            deleteExecute();
            //Display the resultset
            resultSet=statement.executeQuery("select * from db1.saturdaytable");
            writeResultSet(resultSet);
		} 
    	catch (ClassNotFoundException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    private void insertExecute()
    {
    	try {
			preparedStatement=connect.prepareStatement("insert into db1.saturdaytable values(?,?,?)");
			preparedStatement.setInt(1, 1781);
			preparedStatement.setString(2, "Jay");
			preparedStatement.setDouble(3, 654765758);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void updateExecute()
    {
    	try {
			preparedStatement=connect.prepareStatement("UPDATE db1.saturdaytable SET saturdaytable.name=? where saturdaytable.id=? ;");
			preparedStatement.setString(2, "Sushant");
			preparedStatement.executeUpdate();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    private void deleteExecute()
    {
    	try {
			preparedStatement=connect.prepareStatement("delete from db1.saturdaytable where saturdaytable.id=? ;");
			preparedStatement.setInt(1, 1688);
			preparedStatement.executeUpdate();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    private void writeResultSet(ResultSet set)
    {
    	try {
			while(set.next())
			{
				int empId=set.getInt("id");
				String empName=set.getString("name");
				double empContact=set.getDouble("contact");
				System.out.println("Employee ID \t" +empId);
				System.out.println("Employee Name \t"+empName);
				System.out.println("Employee Contact \t"+empContact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
