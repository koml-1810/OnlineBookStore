package com.onlinebookstore.test;


import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.onlinebookstore.dao.OrderDao;
import com.onlinebookstore.dao.OrderDaoImpl;
import com.onlinebookstore.pojo.Order;

public class OrderTest 
{
public static void main(String[] args) 
{
	String emailId;
	Scanner sc=new Scanner(System.in);
    OrderDao orderDao=new OrderDaoImpl();
	Order o=new Order();
    while(true)
    {
    	System.out.println("1.Place order");
    	System.out.println("2.Show all orders");
    	System.out.println("3.Check Status");
    	System.out.println("4.EXIT");
    System.out.println("Enter your choice");
    int ch=sc.nextInt();
    
    switch(ch)
    {
    case 1:
    	System.out.println("Please enter EmailId");
    	emailId=sc.next();
    int i=orderDao.placeOrder(o);
    	
    	if(i>0)
    	{
    		System.out.println("Order placed..!! ");
    	}
    	else
    	{
    		System.out.println("Order not placed..!!");
    	}
    	break;
    case 2:
    	List<Order>al=orderDao.getAllOrder();
    	Iterator<Order>itr=al.iterator();
    	while(itr.hasNext())
    	{
    		System.out.println(itr.next());
    	}
    	break;
    case 3:
    	System.out.println("Enter Order id");
    	int orderId=sc.nextInt();
    	String orderStatus=orderDao.checkOrderStatus(orderId);
    	System.out.println(orderStatus);
    	break;
    case 4:
    	System.exit(0);
    	break;
    	default:
    		System.out.println("Invalid Choice");
    }
}
}
}
