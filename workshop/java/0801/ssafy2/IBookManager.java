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
	
	//13. 지정한 ISBN의 책을 찾아서 가격 수정
	void update(String isbn, int price);
	
	//14.지정한 isbn의 책을 삭제
	void remove(String isbn);
	
	//15. 도서가 판매되어 재고 수량을 뺀다. 
	void sell(String isbn,int quantity) throws QuantityException, ISBNNotFoundException;
	
	//16. 도서가 구매되어 재고 수량을 뺀다. 
	void buy(String isbn,int quantity) throws ISBNNotFoundException;
	
	//17.파일 읽어서 arraylist에 추가
	void open();
	
	//18.도서 정보를 파일로 저장
	void close();
}
