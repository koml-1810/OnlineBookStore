package com.onlinebookstore.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.onlinebookstore.dao.BookDaoImpl;
import com.onlinebookstore.dao.CartDao;
import com.onlinebookstore.dao.CartDaoImpl;
import com.onlinebookstore.pojo.Book;
import com.onlinebookstore.pojo.Cart;

public class CartTest {

	public static void main(String[] args) 
	{
		String bookName;   
		double prize;
		String authorName,publisher,bookDesc,category,emailId;
		int bookId,bookQuantity,cartId;
		Cart cart=new Cart();
		CartDao cartdao=new CartDaoImpl();
		Scanner sc=new Scanner(System.in);
		
		while(true) 
		{
			System.out.println("1.Add Book to cart");
			System.out.println("2.Show all books in Cart");
			System.out.println("3.Delete Book from cart");
			System.out.println("4.Clear cart");
			System.out.println("5.Exit");
			System.out.println("Enter your choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Add Cart details");
				System.out.println("Enter Book Id ");
				bookId=sc.nextInt();
				System.out.println("Enter Book quantity");
				bookQuantity=sc.nextInt();
				System.out.println("Enter emailId");
				emailId=sc.next();
				
				
				cart =new Cart ();
				cart.setBookId(bookId);;
				cart.setBookQuantity(bookQuantity);
				cart.setEmailId(emailId);
				cartdao=new CartDaoImpl();
				boolean c=cartdao.addToCart(cart);
				if(c)
				{
					System.out.println("Book added to cart Successfully");
				}
				else
				{
					System.out.println("Book not added");
				}
				break;
			case 2:
				System.out.println("Enter email id");
				emailId=sc.next();
				  List<Cart>al=cartdao.showCart(emailId);
				  Iterator<Cart>itr=al.iterator();
				  while(itr.hasNext())
				  {
					  System.out.println(itr.next());
				  }
				  
				     break;
case 3:
				
				System.out.println("Enter cart id to delete:");
				cartId=sc.nextInt();
				
				cart=new Cart();
				
				cart.setCartId(cartId);
				cartdao=new CartDaoImpl();
				boolean c2=cartdao.deleteFromCart(cartId);
				if(c2)
				{
					System.out.println("Book deleted from cart  Successfully");
				}
				else
				{
					System.out.println("Book not deleted");
				}
				break;
	
		case 4:
		
			
			System.out.println("Enter email id to delete:");
			emailId=sc.next();
			
			cart=new Cart();
			
			cart.setEmailId(emailId);
			cartdao=new CartDaoImpl();
			boolean c3=cartdao.clearCart(emailId);
			if(c3)
			{
				System.out.println("Cleared...!!");
			}
			else
			{
				System.out.println("Failed...!!");
			}
			break;
		case 5:
			System.exit(0);
		default:
			System.out.println("Invalid Choice");
}

}
	}
}
