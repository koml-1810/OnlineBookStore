package com.onlinebookstore.dao;

import java.util.List;

import com.onlinebookstore.pojo.Cart;

public interface CartDao 
{
public boolean addToCart(Cart c);
List<Cart>showCart(String emailId);
public boolean deleteFromCart(int cartId);
public boolean clearCart(String emailId);
}
