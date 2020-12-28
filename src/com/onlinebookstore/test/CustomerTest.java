package com.onlinebookstore.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.onlinebookstore.dao.CustomerDaoImpl;
import com.onlinebookstore.dao.BookDaoImpl;
import com.onlinebookstore.dao.CustomerDao;
import com.onlinebookstore.pojo.Book;
import com.onlinebookstore.pojo.Customer;;

public class CustomerTest 
{

	public static void main(String[] args) 
	{
		String customerName;
		String mobNo;
		String address,emailId,password;
		int customerId;
		Customer customer=new Customer();
		CustomerDao customerdao=new CustomerDaoImpl();
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1.Add Customer");
			System.out.println("2.Update Customer details");
			System.out.println("3.Delete Customer details");
			System.out.println("4.Get all Customers");
			System.out.println("5.Search By Customer Id");
			System.out.println("6.Search By Email Id");
			System.out.println("7.Exit");
			System.out.println("Enter your choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Add Customer details");
				System.out.println("Enter Customer name");
				customerName=sc.next();
				System.out.println("Enter Mobile no");
				mobNo=sc.next();
				System.out.println("Enter address");
				address=sc.next();
				System.out.println("Enter Email id");
				emailId=sc.next();
				System.out.println("Enter password");
				password=sc.next();
				customer=new Customer();
				customer.setCustomerName(customerName);
				customer.setMobNo(mobNo);
				customer.setAddress(address);
				customer.setEmailID(emailId);
				customer.setPassword(password);
				customerdao=new CustomerDaoImpl();
				boolean c=customerdao.addCustomer(customer);
				if(c)
				{
					System.out.println("Customer details added Successfully");
				}
				else
				{
					System.out.println("Customer details not added");
				}
				break;
			case 2:
				System.out.println("Add Customer details to update");
				System.out.println("Enter book id to update:");
				customerId=sc.nextInt();
				System.out.println("Enter Customer name");
				customerName=sc.next();
				System.out.println("Enter Mobile no");
				mobNo=sc.next();
				System.out.println("Enter address");
				address=sc.next();
				System.out.println("Enter Email Id");
				emailId=sc.next();
				System.out.println("Enter pasword");
				password=sc.next();
				customer=new Customer();
				customer.setCustomerId(customerId);
				customer.setMobNo(mobNo);
				customer.setAddress(address);
				customer.setEmailID(emailId);
				customer.setPassword(password);
				
				boolean b1=customerdao.updCusomer(customer);
				if(b1)
				{
					System.out.println("Customer details updated Successfully");
				}
				else
				{
					System.out.println(" Not updated");
				}
			case 3:
				System.out.println("Enter book id to delete:");
				customerId=sc.nextInt();
				
				customer=new Customer();
				
				customer.setCustomerId(customerId);
				customerdao=new CustomerDaoImpl();
				boolean b2=customerdao.deleteCustomer(customerId);
				if(b2)
				{
					System.out.println("Customer details deleted Successfully");
				}
				else
				{
					System.out.println("not deleted");
				}
				break;
			
			case 4:
				  List<Customer>al=customerdao.getAllCustomers();
				  Iterator<Customer>itr=al.iterator();
				  while(itr.hasNext())
				  {
					  System.out.println(itr.next());
				  }
				  
				     break;
			case 5:
				System.out.println("Enter Customer id to be search");
			   customerId=sc.nextInt();
			   Customer cust=customerdao.searchById(customerId);
			
				System.out.println(cust);
				     break;
			case 6:
				System.out.println("Enter email id to be search");
			   emailId=sc.next();
			   Customer cust1=customerdao.searchByEmailId(emailId);
			
				System.out.println(cust1);
				     break;
				     
			case 7:
				System.exit(0);
			
			     
			     default:
			    	 System.out.println("Invalid choice");
					

	}
		}
	}
}


	
