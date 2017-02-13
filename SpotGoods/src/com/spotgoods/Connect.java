package com.spotgoods;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Class To handle a Connection and Configuration to a Database
 */
public class Connect {
	Connection connection;
	String driverName = "com.mysql.jdbc.Driver";
	String serverName = "Shadowsocks";
	String userName = "root";
	String password = "ican";
	String url = "jdbc:mysql://150.95.136.191:3306/Shadowsocks";
	/*
	 * Creates a connection and Stores it in Connection object
	 */
	public boolean doConnection()
	{
		
			try{
				
				Class.forName(driverName);
				System.out.print("url:"+url+"---userName:"+userName+"---password:"+password);
		connection = DriverManager.getConnection(url,userName,password);
			}
			catch(ClassNotFoundException e)
			{
				
				e.printStackTrace();
				System.out.println("aaaa"+e.toString()+e.getMessage());	
				return false;
			}
			catch(SQLException e)
			{
				System.out.println("abc "+e.getMessage());
				return false;
			}
				return true;
	}
	/*
	 * Closes The current Connection to the Databases
	 */
	public boolean closeConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public Connection getConnect()
	{
		return connection;
	}
}