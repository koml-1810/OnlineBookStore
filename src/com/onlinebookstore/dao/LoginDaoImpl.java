package com.onlinebookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.onlinebookstore.utility.DBUtility;

public class LoginDaoImpl implements LoginDao{
Connection conn=null;
PreparedStatement ps=null;
	@Override
	public boolean customerLogin(String email, String password) 
{
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from Customer where emailId=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean adminLogin(String email, String password) {
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select * from Admin where email=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changePassword(String email, String newPassword) {
		try 
		{
			conn=DBUtility.getConnect();
			String sql="update Admin set password=? where email=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, email);
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
