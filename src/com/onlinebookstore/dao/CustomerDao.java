package com.onlinebookstore.dao;

import java.util.List;

import com.onlinebookstore.pojo.Book;
import com.onlinebookstore.pojo.Customer;

public interface CustomerDao 
{
	public boolean addCustomer(Customer c);
	public boolean updCusomer(Customer c);
	public boolean deleteCustomer(int id);
	public List<Customer>getAllCustomers();
	
	public Customer searchByEmailId(String  email);
	public Customer searchById(int customerId);

}
