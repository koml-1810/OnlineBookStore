package com.onlinebookstore.controller;

import java.io.File;
import java.io.IOException;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.onlinebookstore.dao.BookDao;
import com.onlinebookstore.dao.BookDaoImpl;
import com.onlinebookstore.dao.CartDao;
import com.onlinebookstore.dao.CartDaoImpl;
import com.onlinebookstore.pojo.Book;
import com.onlinebookstore.pojo.Cart;
@MultipartConfig(maxFileSize=16777125)


public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Book book=new Book();
    BookDao bookDao=new BookDaoImpl();
    public BookServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession();
		String operation=request.getParameter("action");
		String bookName=request.getParameter("name");
		if(operation!=null && operation.equals("delete"))
		{
			int bookId=Integer.parseInt(request.getParameter("id"));
		book.setBookId(bookId);
		boolean b=bookDao.deleteBook(bookId);
		if(b)
		   {
				/*
				 * RequestDispatcher rd=request.getRequestDispatcher("BookServlet");
				 * rd.forward(request, response);
				 */
			   response.sendRedirect("BookServlet");

			
		   }
		   else
		   {
			   RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
				
		   }
		
		}
		else if(operation!=null && operation.equals("edit"))
		{
			int bookId=Integer.parseInt(request.getParameter("id"));
			book.setBookId(bookId);
			book=bookDao.searchById(bookId);
		
			session.setAttribute("bookId", book);
			/*
			 * RequestDispatcher rd=request.getRequestDispatcher("updateBook.jsp");
			 * rd.forward(request, response);
			 */
			response.sendRedirect("updateBook.jsp");
			
		}	
		else if(operation!=null && operation.equals("searchByCategory"))
		{
			String bookCategory=request.getParameter("category");
	List<Book>categoryList=bookDao.searchByCategory(bookCategory);
		session.setAttribute("book", categoryList);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
			
		}	
		else if(operation!=null && operation.equals("searchByPublisher"))
		{
			String bookPublisher=request.getParameter("publisher");
	List<Book>publisherList=bookDao.searchByPublisher(bookPublisher);
		session.setAttribute("book", publisherList);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
			
		}	
		else if(operation!=null && operation.equals("searchByName"))
		{
			bookName=request.getParameter("bookname");
	    List<Book>bookList=bookDao.searchByName(bookName);
	    Gson gson=new Gson();
	    JsonElement jsonElement=gson.toJsonTree(bookList,new TypeToken<List<Book>>() {}.getType());
	    JsonArray jsonArray=jsonElement.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		System.out.println(jsonArray);
			
		}	
		else
		 {
//			List<Book22263> bookList1=bookDao.searchByName(bookName);
//			session.setAttribute("book", bookList1);
//			
		List<Book> bookList=bookDao.getAllBooks();
		session.setAttribute("book", bookList);
		List<Book> categoryList=bookDao.getAllCategories();
		session.setAttribute("bookCategory", categoryList);
		List<Book> publisherList=bookDao.getAllPublishers();
		session.setAttribute("bookPublisher", publisherList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String operation=request.getParameter("action");
		if(operation!=null && operation.equals("Add"))
		{
		String bookName=request.getParameter("bookname");
		double prize=Double.parseDouble(request.getParameter("bookprize"));
		String author=request.getParameter("bookauthor");
		String publisher=request.getParameter("publisher");
		String category=request.getParameter("category");
	    int quantity=Integer.parseInt(request.getParameter("bookquantity"));
	    String bookDesc=request.getParameter("bookdesc");
			/*
			 * Part getPart=request.getPart("bookImage"); InputStream
			 * is=getPart.getInputStream();
			 */
	    
	    Part part=request.getPart("bookImage");
	    String fileName=extractFileName(part);
	    String savepath="C:\\Users\\komal\\Desktop\\miniproject\\OnlineBookStore\\WebContent\\images"+File.separator+fileName;
	    File fileSaveDir=new File(savepath);
	    part.write(savepath + File.separator);
	    
	    
	    
	   book.setBookName(bookName);
	   book.setPrize(prize);
	   book.setAuthorName(author);
	   book.setPublisher(publisher);
	   book.setCategory(category);
	   book.setQuantity(quantity);
	   book.setBookDesc(bookDesc);
	  book.setBookImage(savepath);
	  book.setFilename(fileName);
	   
	   boolean b=bookDao.addBook(book);
	   if(b)
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
			
		int bookId=Integer.parseInt(request.getParameter("bookid"));
		String bookName=request.getParameter("bookname");
		double prize=Double.parseDouble(request.getParameter("bookprize"));
		String author=request.getParameter("bookauthor");
		String publisher=request.getParameter("publisher");
		String category=request.getParameter("category");
	    int quantity=Integer.parseInt(request.getParameter("bookquantity"));
	    String bookDesc=request.getParameter("bookdesc");
	    
			/*
			 * Part part=request.getPart("bookImage"); String
			 * fileName=extractFileName(part); String
			 * savepath="/home/ctuser01/Desktop/Backup/ct-108 Komal/BookStore_22263/WebContent/images"
			 * +File.separator+fileName; File fileSaveDir=new File(savepath);
			 * part.write(savepath + File.separator);
			 */
	    
	   book.setBookId(bookId);
	   book.setBookName(bookName);
	   book.setPrize(prize);
	   book.setAuthorName(author);
	   book.setPublisher(publisher);
	   book.setCategory(category);
	   book.setQuantity(quantity);
	   book.setBookDesc(bookDesc);
			/*
			 * book.setBookImage(savepath); book.setFilename(fileName);
			 */
		   
	  
	   boolean b=bookDao.updateBook(book);
	   if(b)
	   {
				/*
				 * RequestDispatcher rd=request.getRequestDispatcher("BookServlet");
				 * rd.forward(request, response);
				 */
		   response.sendRedirect("BookServlet");
			
	   }
	   else
	   {
		   RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
	   }
	}
		

}


	private String extractFileName(Part part) 
	{
		String contentDisp=part.getHeader("content-disposition");
		String []items=contentDisp.split(";");
		for(String s:items)
		{
			if(s.trim().startsWith("filename"))
			{
				return s.substring(s.indexOf("=")+2,s.length()-1);
			}
		}
		
		return " ";
	}
}