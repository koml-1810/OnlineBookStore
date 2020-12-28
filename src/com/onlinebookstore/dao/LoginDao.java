package com.onlinebookstore.dao;

public interface LoginDao
{
public boolean customerLogin(String email,String password);
public boolean adminLogin(String email,String password);

public boolean changePassword(String email,String newPassword);
}
