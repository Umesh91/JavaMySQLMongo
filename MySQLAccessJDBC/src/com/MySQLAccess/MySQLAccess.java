/**
 * 
 */
package com.MySQLAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author A631954
 *
 */
public class MySQLAccess 
{
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    //method for getting database 
    public void getDatabaseInfo() throws Exception
    {
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Shree@#919");
                           

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            //insert data into the table
            insertExecute();
            deleteExecute();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from mydb.emp");
            
            writeResultSet(resultSet);
            getSelectedAttributes();
            //while(resultSet.next())  
            	//System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2)+"  "+resultSet.getString(3));  
    	}
    	catch(Exception ex) 
    	{
    		throw ex;
    	}
    	finally
    	{
    		close();
    	}
    }
    
    private void insertExecute()
    {
    	try {
			preparedStatement=connect.prepareStatement("insert into mydb.emp values(?,?,?)");
			preparedStatement.setInt(1, 1670);
			preparedStatement.setString(2, "Jessika");
			preparedStatement.setString(3, "+17-567-76869");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void deleteExecute()
    {
    	try {
			preparedStatement=connect.prepareStatement("delete from mydb.emp where emp.id=? ;");
			preparedStatement.setInt(1, 1600);
			preparedStatement.executeUpdate();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    private void getSelectedAttributes()
    {
    	try {
			preparedStatement=connect.prepareStatement("SELECT name,contact FROM mydb.emp");
			resultSet=preparedStatement.executeQuery();
			writeSelectedResultSet(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void writeSelectedResultSet(ResultSet set)
    {
    	try {
			while(set.next())
			{
				String empName=set.getString("name");
				String empContact=set.getString("contact");
				System.out.println("Employee Name \t"+empName);
				System.out.println("Employee Contact \t"+empContact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				String empContact=set.getString("contact");
				System.out.println("Employee ID \t" +empId);
				System.out.println("Employee Name \t"+empName);
				System.out.println("Employee Contact \t"+empContact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    private void close()
    {
    	try
    	{
    		if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
    	}catch(Exception e)
    	{
    		
    	}
    }

}
