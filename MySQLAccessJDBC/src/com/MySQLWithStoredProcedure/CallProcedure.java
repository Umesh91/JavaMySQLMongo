/**
 * 
 */
package com.MySQLWithStoredProcedure;

import java.sql.CallableStatement;
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
public class CallProcedure 
{

	/**
	 * @param args
	 */
	private Connection connect = null;
    private CallableStatement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public void executeProcedure() throws Exception
    {
    	try {
			// TODO Auto-generated method stub
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Shree@#919");
			statement = connect.prepareCall("{call create_supplier(?, ?)}");
			statement.setInt(1, 1511);
			statement.setString(2, "Silver-Gracia");
			statement.setString(3, "silgracia@gmail.com");
			statement.execute();
			statement.close();
			System.out.println("Stored procedure called successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void viewCompanyInfoProcedure() throws Exception
    {
    	String viewQuery="CREATE PROCEDURE get_company()";
    	viewQuery +="BEGIN ";
    	viewQuery +="SELECT * FROM company.info;";
    	viewQuery +="END";
    	statement.execute(viewQuery);
    	resultSet=statement.getResultSet();
    	while(resultSet.next())
    	{
    		int id=resultSet.getInt("id");
    		String name=resultSet.getString("name");
    		int noofbranches=resultSet.getInt("noofbranches");
    		String website=resultSet.getString("website");
    		System.out.println("id"+id);
    		System.out.println("name"+name);
    		System.out.println("noofbranches"+noofbranches);
    		System.out.println("website"+website);
    		System.out.println("Stored procedure exceuted successfully");
    	}
    }
	public static void main(String[] args) 
	{
		CallProcedure c=new CallProcedure();
		try {
			c.executeProcedure();
			c.viewCompanyInfoProcedure();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
