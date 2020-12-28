package com.onlinebookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.onlinebookstore.dao.BookDao;
import com.onlinebookstore.dao.BookDaoImpl;
import com.onlinebookstore.pojo.Book;

/**
 * Servlet implementation class DemoJsonServlet
 */
public class DemoJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookId=Integer.parseInt(request.getParameter("countryCode"));
		System.out.println(bookId);
		BookDao lookDao=new BookDaoImpl();
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		 JsonObject jsonObject=new JsonObject();
		 
		 Book lookPojo=lookDao.searchById(bookId);
		 JsonElement jsonElement=gson.toJsonTree(lookPojo);
		 jsonObject.addProperty("success", true);
		
		jsonObject.add("countryInfo", jsonElement);
		out.print(jsonObject.toString());
		out.close();
		System.out.println(jsonObject.toString());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
