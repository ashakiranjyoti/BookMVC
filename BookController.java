package controller;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Book;
import model.DAOImplementor;
//import model.Employee;
import view.BookView;
public class BookController implements ActionListener 
{
	BookView b;
	public BookController(BookView b)
	{
		this.b=b;
	}
@Override
	public void actionPerformed(ActionEvent e)
	{
		DAOImplementor di=new DAOImplementor();
		Book book=new Book();
		if(e.getSource()==b.b1)
		{
			book.setId(Integer.parseInt(b.tf1.getText()));
			book.setName(b.tf2.getText());
			book.setAuthor(b.tf3.getText());
			book.setPrice(Float.parseFloat(b.tf4.getText()));
			int z;
			try
			{
				z=di.insertdata(book);
				if(z>0)
				{
					JOptionPane.showMessageDialog(b.f, "Data inserted");
				}
			}
			catch(ClassNotFoundException e1) {
				System.out.println(e1);
			}
			catch(SQLException e1) {
				System.out.println(e1);
			}
			b.tf1.setText(" "); b.tf2.setText(" ");
			b.tf3.setText(" "); b.tf4.setText(" ");
		}
		if(e.getSource()==b.b2) 
		{
			int id=Integer.parseInt(b.tf1.getText());
			int z;
			try
			{
				z=di.deletedata(id);
				if(z>0)
				{
					JOptionPane.showMessageDialog(b.f, "Data Deleted");
				}
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			b.tf1.setText(" ");
		}
		if(e.getSource()==b.b3)
		{
			int id=(Integer.parseInt(b.tf1.getText()));
			float sal=(Float.parseFloat(b.tf4.getText()));
			try
			{
				int z=di.updatedata(id, sal);
				if(z>0)
				{
					JOptionPane.showMessageDialog(b.f, "Data Updated");
				}
			}
			catch(ClassNotFoundException e1)
			{
				System.out.println(e1);
			}
			catch(SQLException e1)
			{
				//System.out.println(e1);
				e1.printStackTrace();
			}
		}
		if(e.getSource()==b.b4)
		{
			book.setId(Integer.parseInt(b.tf1.getText()));
			{
				try
				{
					book=di.searchdata(book);
					b.tf1.setText(Integer.toString(book.getId()));
					b.tf2.setText(book.getName());
					b.tf3.setText(book.getAuthor());
					b.tf4.setText(Float.toString(book.getPrice()));	
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}
		}
			if(e.getSource()==b.b5)
			{
				List<Book> l=new ArrayList<Book>();
				try
				{
					l=di.showAll();
					for(Book e1:l)
					{
						b.ta.append(e1.toString()+"\n");
					}
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				
			}
		}
}





