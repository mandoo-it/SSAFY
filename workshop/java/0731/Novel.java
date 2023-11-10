package com.ssafy2;

public class Novel extends Book{
	@Override
	public String toString() {
		return super.toString() + "|" + genre;
	}

	public Novel(String isbn, String title, String author, String publisher, int price, String desc, String genre) {
		super(isbn, title, author, publisher, price, desc);
		this.genre = genre;
	}

	private String genre;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
