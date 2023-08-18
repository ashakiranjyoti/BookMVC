package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DAOImplementor implements DAOprovider {
	ResultSet rs;
	PreparedStatement pst;
	Connection con;
	CallableStatement cst;
	Book e1;

	@Override
	public int insertdata(Book b) throws ClassNotFoundException, SQLException
	{
		con=DBConnect.connectDB();
		pst=con.prepareStatement("insert into Book_info values(?,?,?,?)");
		pst.setInt(1, b.getId());
		pst.setString(2, b.getName());
		pst.setString(3, b.getAuthor());
		pst.setFloat(4, b.getPrice());
		return(pst.executeUpdate());
	}
	
	
	@Override
	public int deletedata(int id) throws ClassNotFoundException, SQLException
	{
		con=DBConnect.connectDB();
		pst=con.prepareStatement("delete from Book_info where ID=?");
		pst.setInt(1, id);
		return(pst.executeUpdate());
	}
	
	@Override
	public int updatedata(int id, float price) throws ClassNotFoundException, SQLException
	{
		con=DBConnect.connectDB();
		pst=con.prepareStatement("update Book_info set price=?"+"where ID=?");
		pst.setFloat(1, price);
		pst.setInt(2, id);
		return (pst.executeUpdate());
	}
	
	@Override
	public Book searchdata(Book b) throws ClassNotFoundException, SQLException {
		con=DBConnect.connectDB();
		pst=con.prepareStatement("select * from Book_info where ID=?");
		pst.setInt(1, b.getId());
		rs=pst.executeQuery();
		while(rs.next())
		{
			b.setId(rs.getInt(1));
			b.setName(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPrice(rs.getFloat(4));
		}
		return b;	
	}
	
	@Override
	public List<Book> showAll() throws ClassNotFoundException, SQLException
	{
		con=DBConnect.connectDB();
		List<Book> l=new ArrayList<Book>();
		Statement s=con.createStatement();
		rs=s.executeQuery("select*from Book_info");
		while(rs.next())
		{
			e1=new Book();
			e1.setId(rs.getInt(1));
			e1.setName(rs.getString(2));
			e1.setAuthor(rs.getString(3));
			e1.setPrice(rs.getFloat(4));
		}
		return l;	
	}


	@Override
	public List<Book> searchAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
