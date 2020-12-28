package com.onlinebookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.onlinebookstore.pojo.Cart;
import com.onlinebookstore.utility.DBUtility;

public class CartDaoImpl implements CartDao{
	Connection conn=null;
	PreparedStatement ps=null;

	@Override
	public boolean addToCart(Cart c) 
	{

		try 
		{
		conn=DBUtility.getConnect();
		String sql="insert into Cart(bookId,bookQuantity,emailId)values(?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setInt(1,c.getBookId());
		ps.setInt(2, c.getBookQuantity());
		ps.setString(3, c.getEmailId());
		
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
	public List<Cart> showCart(String emailId) {
		try 
		{
		conn=DBUtility.getConnect();
		List<Cart>cartList=new ArrayList<Cart>();
		String sql="select b.bookId,b.bookName,b.prize,c.cartId,c.emailId,c.bookQuantity from Book as b inner join Cart as c on b.bookId=c.bookId and c.emailId=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, emailId);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Cart c=new Cart();
			c.setBookId(rs.getInt("bookId"));
			c.setBookName(rs.getString("bookName"));
			c.setPrize(rs.getDouble("prize"));
			c.setCartId(rs.getInt("cartId"));
			c.setEmailId(rs.getString("emailId"));
			c.setBookQuantity(rs.getInt("bookQuantity"));
			
		cartList.add(c);
			
		}
		return cartList;
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteFromCart(int cartId) {
		try 
		{
		conn=DBUtility.getConnect();
		String sql="delete from Cart  where cartId=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1,cartId);
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
	public boolean clearCart(String emailId) {
		try 
		{
		conn=DBUtility.getConnect();
		String sql="delete from Cart  where emailId=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1,emailId);
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

}
