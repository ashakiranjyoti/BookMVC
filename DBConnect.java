package model;
import java.sql.*;
public class DBConnect {
	static Connection con;
	public static Connection connectDB()throws 
	ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AK","root","TIGER");
		return con;
	}

}
