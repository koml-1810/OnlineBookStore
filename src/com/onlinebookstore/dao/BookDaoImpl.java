package com.onlinebookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookstore.pojo.Book;
import com.onlinebookstore.utility.DBUtility;

public class BookDaoImpl implements BookDao{
	Connection conn=null;
	PreparedStatement ps=null;

	public boolean addBook(Book b) 
	{ 
		
		try 
		{
		conn=DBUtility.getConnect();
		String sql="insert into Book(bookName,prize,authorName,publisher,bookDesc,category,quantity,bookImage,filename)values(?,?,?,?,?,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setString(1, b.getBookName());
		ps.setDouble(2, b.getPrize());
		ps.setString(3, b.getAuthorName());
		ps.setString(4, b.getPublisher());
		ps.setString(5, b.getBookDesc());
		ps.setString(6, b.getCategory());
		ps.setInt(7, b.getQuantity());
		ps.setString(8, b.getBookImage());
		ps.setString(9, b.getFilename());
		int i=ps.executeUpdate();
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	     } 
		catch (Exception e) 
		{
		e.printStackTrace();
	}
		
		return false;
	}

	public boolean updateBook(Book b) 
	{  
	  

		try 
		{
		conn=DBUtility.getConnect();
		String sql="update Book set bookName=?,prize=?,authorName=?,publisher=?,bookDesc=?,category=?,quantity=? where bookId=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, b.getBookName());
		ps.setDouble(2, b.getPrize());
		ps.setString(3, b.getAuthorName());
		ps.setString(4, b.getPublisher());
		ps.setString(5, b.getBookDesc());
		ps.setString(6, b.getCategory());
		ps.setInt(7, b.getQuantity());
		ps.setInt(8, b.getBookId());
			/*
			 * ps.setString(9, b.getBookImage()); ps.setString(10, b.getFilename());
			 */
		int i=ps.executeUpdate();
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	     } 
		catch (Exception e) 
		{
		e.printStackTrace();
	}
	
		return false;
	}

	public boolean deleteBook(int id) 
	{
		try 
		{
		conn=DBUtility.getConnect();
		String sql="delete from Book  where bookId=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1,id);
		int i=ps.executeUpdate();
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	     } 
		catch (Exception e) 
		{
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public List<Book> getAllBooks() 
	{
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from Book";
			List<Book>booklist=new ArrayList<Book>();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Book b=new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setBookName(rs.getString("bookName"));
				b.setPrize(rs.getDouble("prize"));
				b.setAuthorName(rs.getString("authorName"));
				b.setPublisher(rs.getString("publisher"));
			  b.setBookDesc(rs.getString("bookDesc"));
				b.setCategory(rs.getString("category"));
				b.setQuantity(rs.getInt("quantity"));
				b.setBookImage(rs.getString("bookImage"));
				b.setFilename(rs.getString("filename"));
				booklist.add(b);
			}
			return booklist;
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> searchByName(String name) {
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from Book where bookName=?";
			List<Book>booklist=new ArrayList<Book>();
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Book b=new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setBookName(rs.getString("bookName"));
				b.setPrize(rs.getDouble("prize"));
				b.setAuthorName(rs.getString("authorName"));
				b.setPublisher(rs.getString("publisher"));
				b.setBookDesc(rs.getString("bookDesc"));
				b.setCategory(rs.getString("category"));
				b.setQuantity(rs.getInt("quantity"));
				b.setBookImage(rs.getString("bookImage"));
				b.setFilename(rs.getString("filename"));
				booklist.add(b);
			}
			return booklist;
			
		
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> searchByAuthor(String author) {
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from Book where authorName=?";
			List<Book>booklist=new ArrayList<Book>();
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, author);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Book b=new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setBookName(rs.getString("bookName"));
				b.setPrize(rs.getDouble("prize"));
				b.setAuthorName(rs.getString("authorName"));
				b.setPublisher(rs.getString("publisher"));
				b.setBookDesc(rs.getString("bookDesc"));
				b.setCategory(rs.getString("category"));
				b.setQuantity(rs.getInt("quantity"));
				b.setBookImage(rs.getString("bookImage"));
				b.setFilename(rs.getString("filename"));
				booklist.add(b);
			}
			return booklist;
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> searchByPublisher(String publisher) {
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from Book where publisher=?";
			List<Book>booklist=new ArrayList<Book>();
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, publisher);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Book b=new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setBookName(rs.getString("bookName"));
				b.setPrize(rs.getDouble("prize"));
				b.setAuthorName(rs.getString("authorName"));
				b.setPublisher(rs.getString("publisher"));
				b.setBookDesc(rs.getString("bookDesc"));
				b.setCategory(rs.getString("category"));
				b.setQuantity(rs.getInt("quantity"));
				b.setBookImage(rs.getString("bookImage"));
				b.setFilename(rs.getString("filename"));
				booklist.add(b);
			}
			return booklist;
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book searchById(int bookid) {
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from Book where bookId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bookid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Book b=new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setBookName(rs.getString("bookName"));
				b.setPrize(rs.getDouble("prize"));
				b.setAuthorName(rs.getString("authorName"));
				b.setPublisher(rs.getString("publisher"));
				b.setBookDesc(rs.getString("bookDesc"));
				b.setCategory(rs.getString("category"));
				b.setQuantity(rs.getInt("quantity"));
				b.setBookImage(rs.getString("bookImage"));
				b.setFilename(rs.getString("filename"));
				return b;
			}
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getAllCategories() {
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select distinct(category) from Book";
			List<Book>booklist=new ArrayList<Book>();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Book b=new Book();
				
				b.setCategory(rs.getString("category"));
				
				booklist.add(b);
			}
			return booklist;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getAllPublishers() {
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select distinct(publisher) from Book";
			List<Book>booklist=new ArrayList<Book>();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Book b=new Book();
				
				b.setPublisher(rs.getString("publisher"));
				
				booklist.add(b);
			}
			return booklist;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> searchByCategory(String category) {
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from Book where category=?";
			List<Book>booklist=new ArrayList<Book>();
			ps=conn.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Book b=new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setBookName(rs.getString("bookName"));
				b.setPrize(rs.getDouble("prize"));
				b.setAuthorName(rs.getString("authorName"));
				b.setPublisher(rs.getString("publisher"));
				b.setBookDesc(rs.getString("bookDesc"));
				b.setCategory(rs.getString("category"));
				b.setQuantity(rs.getInt("quantity"));
				b.setBookImage(rs.getString("bookImage"));
				b.setFilename(rs.getString("filename"));
				booklist.add(b);
			}
			return booklist;
			
		
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}