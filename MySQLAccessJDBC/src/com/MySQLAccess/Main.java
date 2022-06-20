/**
 * 
 */
package com.MySQLAccess;

/**
 * @author A631954
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MySQLAccess dao= new MySQLAccess();
		try {
			dao.getDatabaseInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
