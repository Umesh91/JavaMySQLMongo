/**
 * 
 */
package com.MYSQLJDBCproject.src;

/**
 * @author A631954
 *
 */
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MySQLJDBC dao=new MySQLJDBC();
		try {
			dao.getDatabaseInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
