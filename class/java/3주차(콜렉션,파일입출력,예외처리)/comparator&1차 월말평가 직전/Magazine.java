package com.ssafy.book;

public class Magazine extends Book {
	private String month;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Magazine(String isbn, String title, int price) {
		this(isbn, title, price, 0, "");
	}

	public Magazine(String isbn, String title, int price, int quantity) {
		this(isbn, title, price, quantity, "");
	}

	public Magazine(String isbn, String title, int price, int quantity, String month) {
		super(isbn, title, price, quantity);
		setMonth(month);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("\t").append(getMonth());
		return sb.toString();
	}
}
