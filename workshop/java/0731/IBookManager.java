package com.ssafy2;

import java.util.ArrayList;

//BookManager가 구현해야하는 11개의 메소드를 가지고 있는 인터페이스
public interface IBookManager {
	//1.데이터 입력 기능 - 책 추가
	void add(Book book);
	
	//2.데이터 전체 검색 기능
	ArrayList<Book> allBooks();
	
	//3.isbn으로 정보를 검색하는 기능
	Book findByIsbn(String isbn);
	
	//4.title 검색
	ArrayList<Book> findByTitle(String title);
	
	//5.Novel으로만 검색하는 기능
	ArrayList<Book> findNovel();
	
	//6.Megazine으로만 검색하는 기능
	ArrayList<Book> findMegazine();
	
	//8. 출판사로 검색하는 기능
	ArrayList<Book> findByPublisher(String publisher);
	
	//9. 가격
	ArrayList<Book> findByPrice(int Price);
	
	//10.sum
	int sum();
	
	//11.average
	double average();
	
	//12. 올해 잡지만 검색
	ArrayList<Book> findMegazineByYear();
}
