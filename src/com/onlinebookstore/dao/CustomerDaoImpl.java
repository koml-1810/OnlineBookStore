package com.onlinebookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookstore.pojo.Book;
import com.onlinebookstore.pojo.Customer;
import com.onlinebookstore.utility.DBUtility;

public class CustomerDaoImpl implements CustomerDao{
	Connection conn=null;
	PreparedStatement ps=null;


	public boolean addCustomer(Customer c) {
		try 
		{
		conn=DBUtility.getConnect();
		String sql="insert into Customer(customerName,mobNo,address,emailId,password)values(?,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setString(1, c.getCustomerName());
		ps.setString(2, c.getMobNo());
		ps.setString(3, c.getAddress());
		ps.setString(4, c.getEmailID());
		ps.setString(5, c.getPassword());
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

	public boolean updCusomer(Customer c) 
	{
		try 
		{
		conn=DBUtility.getConnect();
		String sql="update Customer set customerName=?,mobNo=?,address=?,emailId=?,password=? where customerId=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, c.getCustomerName());
		ps.setString(2, c.getMobNo());
		ps.setString(3, c.getAddress());
		ps.setString(4, c.getEmailID());
		ps.setString(5, c.getPassword());
		ps.setInt(6, c.getCustomerId());
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

	public boolean deleteCustomer(int id) {
		try 
		{
		conn=DBUtility.getConnect();
		String sql="delete from Customer where customerId=?";
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
	public List<Customer> getAllCustomers() {
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from Customer";
			List<Customer>customerlist=new ArrayList<Customer>();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer c=new Customer();
				c.setCustomerId(rs.getInt("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setMobNo(rs.getString("mobNo"));
				c.setAddress(rs.getString("address"));
				c.setEmailID(rs.getString("emailId"));
				c.setPassword(rs.getString("password"));
				
				customerlist.add(c);
			}
			return customerlist;
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

	@Override
	public Customer searchById(int customerId) {
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from Customer where customerId=?";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer c=new Customer();
				c.setCustomerId(rs.getInt("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setMobNo(rs.getString("mobNo"));
				c.setAddress(rs.getString("address"));
				c.setEmailID(rs.getString("emailId"));
				c.setPassword(rs.getString("password"));
				
				return c;
			}
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@Override
	public Customer searchByEmailId(String email) {
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from Customer where emailId=?";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer c=new Customer();
				c.setCustomerId(rs.getInt("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setMobNo(rs.getString("mobNo"));
				c.setAddress(rs.getString("address"));
				c.setEmailID(rs.getString("emailId"));
				c.setPassword(rs.getString("password"));
				
				return c;
			}
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
