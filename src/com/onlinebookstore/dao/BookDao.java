package com.onlinebookstore.dao;

import java.util.List;

import com.onlinebookstore.pojo.Book;

public interface BookDao
{
public boolean addBook(Book b);
public boolean updateBook(Book b);
public boolean deleteBook(int id);
public List<Book>getAllBooks();
public List<Book>searchByName(String  name);
public List<Book>searchByAuthor(String  author);
public List<Book>searchByPublisher(String  publisher);
public Book searchById(int bookid);
public List<Book>getAllCategories();
public List<Book>getAllPublishers();
public List<Book>searchByCategory(String  category);

}
