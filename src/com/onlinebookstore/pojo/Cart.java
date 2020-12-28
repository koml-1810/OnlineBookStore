package com.onlinebookstore.pojo;

public class Cart 
{
	private int cartId;
	private int bookId;
	private int bookQuantity;
	private double prize;
	private String emailId,bookName;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	public double getPrize() {
		return prize;
	}
	public void setPrize(double prize) {
		this.prize = prize;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", bookId=" + bookId + ", bookQuantity=" + bookQuantity + ", prize=" + prize
				+ ", emailId=" + emailId + ", bookName=" + bookName + "]";
	}
	
	

}
