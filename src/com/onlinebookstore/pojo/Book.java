package com.onlinebookstore.pojo;



public class Book 
{
	private int bookId;
	private String bookName;
	private String bookImage;
	private double prize;
	private String authorName;
	private String publisher;
	private String bookDesc;
	private String category;
	private int quantity;
	private String filename;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	public double getPrize() {
		return prize;
	}
	public void setPrize(double prize) {
		this.prize = prize;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "Book22263 [bookId=" + bookId + ", bookName=" + bookName + ", bookImage=" + bookImage + ", prize="
				+ prize + ", authorName=" + authorName + ", publisher=" + publisher + ", bookDesc=" + bookDesc
				+ ", category=" + category + ", quantity=" + quantity + ", filename=" + filename + "]";
	}
	
	

	
	

}