package com.ssafy;

public class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;
	
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	
	public String toString() {
		String s = isbn + "|" +title + "|"+author + "|"+publisher + "|"+price + "|"+desc;
		return s;
	}
	
	
}
