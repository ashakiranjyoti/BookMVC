package model;
import java.sql.*;
import java.util.List;
public interface DAOprovider {
	
	String DBDRIVER="con.mysql.cj.jdbc.Driver";
	String DBURL="jdbc:mysql://localhost:3306/AK";
	String DBUSER="root";
	String DBPASS="TIGER";
	
	int insertdata(Book b)
	throws ClassNotFoundException, SQLException;
	int deletedata(int id) throws ClassNotFoundException, SQLException;
	int updatedata(int id, float Price)throws ClassNotFoundException, SQLException;
	
	Book searchdata(Book b) throws ClassNotFoundException, SQLException;
	public List<Book> showAll()throws ClassNotFoundException, SQLException;
	List<Book> searchAll() throws ClassNotFoundException, SQLException;

}
