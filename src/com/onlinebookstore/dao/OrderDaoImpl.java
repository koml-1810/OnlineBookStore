package com.onlinebookstore.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.onlinebookstore.pojo.Order;
import com.onlinebookstore.utility.DBUtility;

public class OrderDaoImpl implements OrderDao {
	Connection conn=null;
	PreparedStatement ps=null;
	Order o=new Order();
	ResultSet rs;
	int orderId;
	Date d=null;



	/*public int placeOrder() 
	{
		double totalcost=0;
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select sum(b.prize * c.bookQuantity) as totalBill from Book_22263  b,Cart  c where b.bookId=c.bookId and c.emailId=? ";
		ps=conn.prepareStatement(sql);
		ps.setString(1, emailId);
			rs=ps.executeQuery();
		if(rs.next())
			{
				totalcost=rs.getDouble("totalBill");
			}
		d=new Date();
		String today=d.toString();
		String sql1="insert into Order_22263(orderStatus,totalBill,emailId,orderDate)values(?,?,?,?)";
		PreparedStatement psc=conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
		psc.setString(1, "processing");
		psc.setDouble(2, totalcost);
		psc.setString(3, emailId);
		psc.setString(4, today);
		
		rs=psc.getGeneratedKeys();
		if(rs.next())
		{
			orderId=rs.getInt(1);
		}
		
			return orderId;
		
		
	     } 
		catch (Exception e) 
		{
		e.printStackTrace();
	}
		return 0;
	}*/

	@Override
	public List<Order> getAllOrder() {
		try 
		{
			conn=DBUtility.getConnect();
			List<Order>orderList=new ArrayList<Order>();
			String sql="select * from Orders";
		    ps=conn.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    { 
		    	Order o=new Order();
		    	o.setOrderId(rs.getInt("orderId"));
		    	o.setOrderStatus(rs.getString("orderStatus"));
		    	o.setTotalBill(rs.getDouble("totalBill"));
		    	o.setEmailId(rs.getString("emailId"));
		    	orderList.add(o);
		    }
		     return orderList;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String checkOrderStatus(int orderId) {
		String status=null;
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select orderStatus from Orders where orderId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				status=rs.getString("orderStatus");
			}
			return status;
			
		} 
		catch (Exception e)
        {
		
		}
		return null;
	}

	@Override
	public int placeOrder(Order o) 
	{
		try 
		{
			conn=DBUtility.getConnect();
			String sql="insert into Orders(orderStatus,totalBill,emailId,orderDate)values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "processing");
			ps.setDouble(2,o.getTotalBill());
			ps.setString(3, o.getEmailId());
			ps.setString(4, o.getOrderDate());
			int i=ps.executeUpdate();
			if(i>0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
