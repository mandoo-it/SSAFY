package com.ssafy2;

import java.util.ArrayList;
import java.util.Calendar;

//megazine, novel을 관리하는 메소드를 가지고 있는 관리 클래스
public class BookManager implements IBookManager{
	//field
	//Book[] list;//Megazine, novel을 저장할 수 있는 배열
	ArrayList<Book> list = new ArrayList<>();
	int sum = 0;
	private BookManager() {
		
	}
	//2.singleton - 3의 static 메소드 안에는 static 변수밖에 쓰지 못한다. 
	private static BookManager instance = new BookManager();
	
	//3.singleton 
	public static BookManager getInstance() {
		return instance;
	}
	
	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub
		list.add(book);
	}

	@Override
	public ArrayList<Book> allBooks() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Book findByIsbn(String isbn) {
		// TODO Auto-generated method stub
		for(int j=0;j<list.size();j++) {
			if(list.get(j).getIsbn().equals(isbn))
					return list.get(j);
		}
		return null;
	}

	@Override
	public ArrayList<Book> findByTitle(String title) {
		// TODO Auto-generated method stub
		ArrayList<Book> titlebook = new ArrayList<>();
		for(int j=0;j<list.size();j++) {
			if(list.get(j).getTitle().equals(title)) {
				titlebook.add(list.get(j));
			}
		}
		return titlebook;
	}

	@Override
	public ArrayList<Book> findNovel() {
		// TODO Auto-generated method stu
		ArrayList<Book> titlebook = new ArrayList<>();
		for(int j=0;j<list.size();j++) {
			if(list.get(j).getClass().getSimpleName().contains("Novel")) {
				titlebook.add(list.get(j));
			}
		}
		return titlebook;
	}

	@Override
	public ArrayList<Book> findMegazine() {
		// TODO Auto-generated method stub		
		ArrayList<Book> titlebook = new ArrayList<>();
		for(int j=0;j<list.size();j++) {
			if(list.get(j).getClass().getSimpleName().equals("Magazine")) 
				titlebook.add(list.get(j));
		}
		return titlebook;
	}

	@Override
	public ArrayList<Book> findByPublisher(String publisher) {
		// TODO Auto-generated method stub
		ArrayList<Book> titlebook = new ArrayList<>();
		for(int j=0;j<list.size();j++) {
			if(list.get(j).getPublisher().contains(publisher)) 
				titlebook.add(list.get(j));
		}
		return titlebook;
	}

	@Override
	public ArrayList<Book> findByPrice(int Price) {
		// TODO Auto-generated method stub
		ArrayList<Book> titlebook = new ArrayList<>();
		for(int j=0;j<list.size();j++) {
			if(list.get(j).getPrice() == Price) 
				titlebook.add(list.get(j));
		}
		return titlebook;
	}

	@Override
	public int sum() {
		// TODO Auto-generated method stub
		for(int j=0;j<list.size();j++) {
				sum += list.get(j).getPrice();
		}
		return sum;
	}

	@Override
	public double average() {
		// TODO Auto-generated method stu
		return sum / list.size();
	}

	@Override
	public ArrayList<Book> findMegazineByYear() {
		// TODO Auto-generated method stub
		ArrayList<Book> titlebook = new ArrayList<>();
		Calendar now = Calendar.getInstance();
		
		for(int j=0;j<list.size();j++) {
			if(list.get(j) instanceof Magazine) {
				Magazine m = (Magazine)list.get(j);
				if(now.get(Calendar.YEAR) == m.getYear())
					titlebook.add(list.get(j));
			}
		}
		return titlebook;
	}
	
}
