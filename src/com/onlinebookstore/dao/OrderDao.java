package com.onlinebookstore.dao;

import java.util.List;

import com.onlinebookstore.pojo.Order;

public interface OrderDao 
{
public int placeOrder(Order o);
//public int placeOrder(String emailId,double totalBill);
public List<Order>getAllOrder();
public String checkOrderStatus(int orderId);
}
