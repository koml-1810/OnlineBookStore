 package com.onlinebookstore.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.onlinebookstore.dao.BookDao;
import com.onlinebookstore.dao.BookDaoImpl;
import com.onlinebookstore.pojo.Book;

public class BookTest {

	public static void main(String[] args) 
	{
		String bookName;
		double prize;
		String authorName,publisher,bookDesc,category;
		int bookId,quantity;
		Book book=new Book();
		BookDao bookdao=new BookDaoImpl();
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1.Add Book");
			System.out.println("2.Update Book");
			System.out.println("3.Delete Book");
			System.out.println("4.Get all books");
			System.out.println("5.Search by name");
			System.out.println("6.Search by Author");
			System.out.println("7.Search by Publisher");
			System.out.println("8.Search by BookId");
			System.out.println("9.Exit");
			System.out.println("Enter your choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Add book details");
				System.out.println("Enter Book name");
				bookName=sc.next();
				System.out.println("Enter prize");
				prize=sc.nextDouble();
				System.out.println("Enter authorname");
				authorName=sc.next();
				System.out.println("Enter publisher name");
				publisher=sc.next();
				System.out.println("Enter Book Description");
				bookDesc=sc.next();
				System.out.println("Enter category of book");
				category=sc.next();
				System.out.println("Enter quantity");
				quantity=sc.nextInt();
				book=new Book();
				book.setBookName(bookName);
				book.setPrize(prize);
				book.setAuthorName(authorName);
				book.setPublisher(publisher);
				book.setBookDesc(bookDesc);
				book.setCategory(category);
				book.setQuantity(quantity);
				bookdao=new BookDaoImpl();
				boolean b=bookdao.addBook(book);
				if(b)
				{
					System.out.println("Book added Successfully");
				}
				else
				{
					System.out.println("Book not added");
				}
				break;
			case 2:
				System.out.println("Add book details to update");
				System.out.println("Enter book id to update:");
				bookId=sc.nextInt();
				System.out.println("Enter Book name");
				bookName=sc.next();
				System.out.println("Enter prize");
				prize=sc.nextDouble();
				System.out.println("Enter authorname");
				authorName=sc.next();
				System.out.println("Enter publisher name");
				publisher=sc.next();
				System.out.println("Enter Book Description");
				bookDesc=sc.next();
				System.out.println("Enter category of book");
				category=sc.next();
				System.out.println("Enter quantity");
				quantity=sc.nextInt();
				book=new Book();
				book.setBookName(bookName);
				book.setPrize(prize);
				book.setAuthorName(authorName);
				book.setBookId(bookId);
				book.setPublisher(publisher);
				book.setBookDesc(bookDesc);
				book.setCategory(category);
				book.setQuantity(quantity);
				bookdao=new BookDaoImpl();
				boolean b1=bookdao.updateBook(book);
				if(b1)
				{
					System.out.println("Book updated Successfully");
				}
				else
				{
					System.out.println("Book not updated");
				}
				break;
			case 3:
				
				System.out.println("Enter book id to delete:");
				bookId=sc.nextInt();
				
				book=new Book();
				
				book.setBookId(bookId);
				bookdao=new BookDaoImpl();
				boolean b2=bookdao.deleteBook(bookId);
				if(b2)
				{
					System.out.println("Book deleted Successfully");
				}
				else
				{
					System.out.println("Book not deleted");
				}
				break;
			case 4:
			  List<Book>al=bookdao.getAllBooks();
			  Iterator<Book>itr=al.iterator();
			  while(itr.hasNext())
			  {
				  System.out.println(itr.next());
			  }
			  
			     break;
			case 5:
				System.out.println("Enter Book name to be search");
				bookName=sc.next();
				  List<Book>al1=bookdao.searchByName(bookName);
				  Iterator<Book>itr1=al1.iterator();
				  while(itr1.hasNext())
				  {
					  System.out.println(itr1.next());
				  }
				  
				     break;
			case 6:
				System.out.println("Enter Author name to be search");
				authorName=sc.next();
				  List<Book>al2=bookdao.searchByAuthor(authorName);
				  Iterator<Book>itr2=al2.iterator();
				  while(itr2.hasNext())
				  {
					  System.out.println(itr2.next());
				  }
				  
				     break;
			case 7:
				System.out.println("Enter Publisher name to be search");
				publisher=sc.next();
				  List<Book>al3=bookdao.searchByPublisher(publisher);
				  Iterator<Book>itr3=al3.iterator();
				  while(itr3.hasNext())
				  {
					  System.out.println(itr3.next());
				  }
				  
				     break;
			case 8:
				System.out.println("Enter Book id to be search");
				bookId=sc.nextInt();
				Book book1=bookdao.searchById(bookId);
				System.out.println(book1);
				     break;
			case 9:
				System.exit(0);
			     default:
			    	 System.out.println("Invalid choice");
					
				
			}
		}

	}

}
