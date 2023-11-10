package com.ssafy2;
//megazine, novel을 관리하는 메소드를 가지고 있는 관리 클래스
public class BookManager implements IBookManager{
	//field
	Book[] list;//Megazine, novel을 저장할 수 있는 배열
	int i = 0;
	int sum = 0;
	public BookManager() {
		list = new Book[5];
	}

	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub
		list[i] = book;
		i++;	
	}

	@Override
	public Book[] allBooks() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Book findByIsbn(String isbn) {
		// TODO Auto-generated method stub
		for(int j=0;j<list.length;j++) {
			if(list[j].getIsbn().equals(isbn))
					return list[j];
		}
		return null;
	}

	@Override
	public Book[] findByTitle(String title) {
		// TODO Auto-generated method stub
		int ct = 0;
		for(int j=0;j<list.length;j++) {
			if(list[j].getTitle().equals(title))
					ct++;
		}
		Book[] titlebook = new Book[ct];
		int count = 0;
		for(int j=0;j<list.length;j++) {
			if(list[j].getTitle().equals(title)) {
				titlebook[count] = list[j];
				count++;
			}
		}
		return titlebook;
	}

	@Override
	public Book[] findNovel() {
		// TODO Auto-generated method stu
		int ct = 0;
		for(int j=0;j<list.length;j++) {
			if(list[j].getClass().getSimpleName().contains("Novel"))
					ct++;
		}
		Book[] titlebook = new Book[ct];
		int count = 0;
		for(int j=0;j<list.length;j++) {
			if(list[j].getClass().getSimpleName().contains("Novel")) {
				titlebook[count] = list[j];
				count++;
			}
		}
		return titlebook;
	}

	@Override
	public Book[] findMegazine() {
		// TODO Auto-generated method stub		
		int ct = 0;
		for(int j=0;j<list.length;j++) {
			if(list[j].getClass().getSimpleName().equals("Magazine"))
					ct++;
		}
		Book[] titlebook = new Book[ct];
		int count = 0;
		for(int j=0;j<list.length;j++) {
			if(list[j].getClass().getSimpleName().equals("Magazine")) {
				titlebook[count] = list[j];
				count++;
			}
		}
		return titlebook;
	}

	@Override
	public Book[] findByPublisher(String publisher) {
		// TODO Auto-generated method stub
		int ct = 0;
		for(int j=0;j<list.length;j++) {
			if(list[j].getPublisher().contains(publisher))
					ct++;
		}
		Book[] titlebook = new Book[ct];
		int count = 0;
		for(int j=0;j<list.length;j++) {
			if(list[j].getPublisher().contains(publisher)) {
				titlebook[count] = list[j];
				count++;
			}
		}
		return titlebook;
	}

	@Override
	public Book[] findByPrice(int Price) {
		// TODO Auto-generated method stub
		int ct = 0;
		for(int j=0;j<list.length;j++) {
			if(list[j].getPrice() == Price)
					ct++;
		}
		Book[] titlebook = new Book[ct];
		int count = 0;
		for(int j=0;j<list.length;j++) {
			if(list[j].getPrice() == Price) {
				titlebook[count] = list[j];
				count++;
			}
		}
		return titlebook;
	}

	@Override
	public int sum() {
		// TODO Auto-generated method stub
		for(int j=0;j<list.length;j++) {
				sum += list[j].getPrice();
		}
		return sum;
	}

	@Override
	public double average() {
		// TODO Auto-generated method stu
		return sum / list.length;
	}
	
}
