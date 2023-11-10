package com.ssafy.book;

import java.io.Serializable;

public class Book implements Serializable, Comparable<Book> {
	private String isbn;
	private String title;
	private int price;
	private int quantity;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Book(String isbn, String title, int price, int quantity) {
		setIsbn(isbn);
		setPrice(price);
		setQuantity(quantity);
		setTitle(title);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getIsbn());
		sb.append("\t");
		sb.append(getTitle());
		sb.append("\t");
		sb.append(getPrice());
		sb.append("\t");
		sb.append(getQuantity());
		return sb.toString();
	}

	@Override
	public int compareTo(Book o) {
		// 이름 순으로 정렬
		return this.isbn.compareTo(o.getIsbn());
		// 가격 순으로 정렬
		// return Integer.compare(this.price, o.getPrice());
//		if (this.getPrice() < o.getPrice()) {
//			return 1;
//		}
//		return -1;

	}

}
