package com.mooc.admin;

public class Book {
	private String bookID;
	private String bookName;
	private String categoryName;
	private String bookPrice;
	private String description;
	public Book() {
		// TODO 自动生成的构造函数存根
	}
	public Book(String bookID, String bookName, String categoryName, String bookPrice, String description) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.categoryName = categoryName;
		this.bookPrice = bookPrice;
		this.description = description;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", bookName=" + bookName + ", categoryName=" + categoryName + ", bookPrice="
				+ bookPrice + ", description=" + description + "]";
	}
}
