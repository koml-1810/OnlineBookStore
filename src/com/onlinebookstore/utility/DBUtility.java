package com.onlinebookstore.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility 
{
public static Connection getConnect()
{
	Connection conn=null;
	try 
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBookStore","root","root");
		
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}

	
	
	
	
	return conn;
	
}
}
