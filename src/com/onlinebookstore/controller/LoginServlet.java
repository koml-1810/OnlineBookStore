package com.onlinebookstore.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookstore.dao.LoginDao;
import com.onlinebookstore.dao.LoginDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    LoginDao loginDao=new LoginDaoImpl();
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
  	 HttpSession session=request.getSession();
     session.invalidate();
  	 RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
  	 requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 {
		String email=request.getParameter("emailid");
		String password=request.getParameter("password");
		String type=request.getParameter("type");
		String operation=request.getParameter("action");
		HttpSession session=request.getSession();
		if(operation !=null && operation.equals("Login"))
		{
			
			
			if(type.equals("admin"))
			{
			 boolean b =loginDao.adminLogin(email, password);
			 if(b)
			 {
				 session.setAttribute("adminId", email);
				  RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
			 }
			 else
			 {
				
				 RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
			 }
			}
			else if(type.equals("customer"))
			{
				boolean b=loginDao.customerLogin(email, password);
				if(b)
				{
					session.setAttribute("customerId", email);
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				
				else
				{
					 RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
						rd.forward(request, response);
				}
			}
				
		}
		else if(operation.equals("Change"))
		{
			boolean flag=loginDao.adminLogin(email, password);
			System.out.println("flag"+flag+"user"+email+"pass"+password);
			if(flag)
			{
				String newPassword=request.getParameter("newPassword");
				String confirmPassword=request.getParameter("newPassword");
				if(confirmPassword.equals(newPassword))
				{
					flag=loginDao.changePassword(email, newPassword);
					if(flag)
					{
					
						 RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
							rd.forward(request, response);
					}
					else
					{
						 RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
							rd.forward(request, response);
					}
				}
				
			}
				else
				{

					 RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
						rd.forward(request, response);
				}
			
		}
		
	}

}
