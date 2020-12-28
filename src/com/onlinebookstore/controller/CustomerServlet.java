package com.onlinebookstore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookstore.dao.CustomerDao;
import com.onlinebookstore.dao.CustomerDaoImpl;
import com.onlinebookstore.pojo.Book;
import com.onlinebookstore.pojo.Customer;


public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Customer customer=new Customer();
    CustomerDao custDao=new CustomerDaoImpl();
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String operation=request.getParameter("action");
		if(operation!=null && operation.equals("delete"))
		{
			int customerId=Integer.parseInt(request.getParameter("id"));

			
			customer.setCustomerId(customerId);
		boolean c=custDao.deleteCustomer(customerId);
		if(c)
		   {
			  
				/*
				 * RequestDispatcher
				 * requestDispatcher=request.getRequestDispatcher("CustomerServlet");
				 * requestDispatcher.forward(request, response);
				 */
				 response.sendRedirect("CustomerServlet");
		   }
		   else
		   {
		   
		   RequestDispatcher requestDispatcher=request.getRequestDispatcher("Error.jsp");
			requestDispatcher.forward(request, response);
		   }
		
		}
		else if(operation!=null && operation.equals("edit"))
		{

			int customerId=Integer.parseInt(request.getParameter("id"));
			customer.setCustomerId(customerId);
			customer=custDao.searchById(customerId);
			session.setAttribute("custId", customer);
			
			/*
			 * RequestDispatcher
			 * requestDispatcher=request.getRequestDispatcher("updateCustomer.jsp");
			 * requestDispatcher.forward(request, response);
			 */
			
				   response.sendRedirect("updateCustomer.jsp");

			
		}
			
		
		
	else {
		
		List<Customer> customerList=custDao.getAllCustomers();
		session.setAttribute("customer", customerList);
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("customerList.jsp");
		requestDispatcher.forward(request, response);
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation=request.getParameter("action");
		if(operation!=null && operation.equals("Add"))
		{
		String custName=request.getParameter("customername");
	
		String custMob=request.getParameter("customerMobno");
		String custAddress=request.getParameter("address");
		String emailId=request.getParameter("customerEmailid");
		String password=request.getParameter("customerPassword");
	    
	     customer.setCustomerName(custName);
	     customer.setMobNo(custMob);
	     customer.setAddress(custAddress);
	     customer.setEmailID(emailId);
	     customer.setPassword(password);
	   
	   boolean c=custDao.addCustomer(customer);
	   if(c)
	   {
		  
		   RequestDispatcher requestDispatcher=request.getRequestDispatcher("success.jsp");
			requestDispatcher.forward(request, response);
	   }
	   else
	   {
	   
	   RequestDispatcher requestDispatcher=request.getRequestDispatcher("Error.jsp");
		requestDispatcher.forward(request, response);
	   }
		}
		else if(operation!=null && operation.equals("update"))
		{
			
		int custId=Integer.parseInt(request.getParameter("customerid"));
		String custName=request.getParameter("customername");
		
		String custMob=request.getParameter("customerMobno");
		String custAddress=request.getParameter("address");
		String emailId=request.getParameter("customerEmailid");
		String password=request.getParameter("customerPassword");
	     customer.setCustomerId(custId);
	     customer.setCustomerName(custName);
	     customer.setMobNo(custMob);
	     customer.setAddress(custAddress);
	     customer.setEmailID(emailId);
	     customer.setPassword(password);
	   
	   boolean c=custDao.updCusomer(customer);
	   if(c)
	   {
		   
				/*
				 * RequestDispatcher
				 * requestDispatcher=request.getRequestDispatcher("CustomerServlet");
				 * requestDispatcher.forward(request, response);
				 */
		   response.sendRedirect("CustomerServlet");
	   }
	   else
	   {
		   
		   RequestDispatcher requestDispatcher=request.getRequestDispatcher("Error.jsp");
			requestDispatcher.forward(request, response);
	   }
	}
	}

}
