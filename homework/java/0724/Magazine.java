package com.ssafy;

public class Magazine extends Book{
	int year;
	int month;

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year,
			int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}



	public String toString() {
		String s = isbn + "|" +title + "|"+author + "|"+publisher + "|"+price + "|"+desc +"|" + year +"." +month;
		return s;
	}
}
