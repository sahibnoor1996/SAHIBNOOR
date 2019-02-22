package prabhjot;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import prabhjot.Customer;

public class DBHelper
{
Connection con;
PreparedStatement pStmt;


public  DBHelper()
{
	
try {
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Driver Loaded"); 
}
catch(Exception e)
{
	e.printStackTrace();
}
}

public void createConnection()
{
	try {
		String url="jdbc:mysql://localhost/Enc2019";
		String user="root";		
		String password="";
		
		con=DriverManager.getConnection(url,user,password);
		System.out.println(">> Connection Created");
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}

public int addCustomerInDb(Customer cRef)
{
	int i=0;
	try {
		
		String sql="insert into Customer values(null,?,?,?)";
		
		pStmt=con.prepareStatement(sql);
		pStmt.setString(2, cRef.phone);
		pStmt.setString(3, cRef.email);
		
		i=pStmt.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	return i;
	}

public void closeConnection()
{
	try {
		con.close();
		System.out.println(">> Connection Closed");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}

}


