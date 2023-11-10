package com.ssafy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;

//megazine, novel을 관리하는 메소드를 가지고 있는 관리 클래스
public class BookManager implements IBookManager{
	//내부 클랴수
	class BookClient extends Thread{
		public void run() {//서버로 접속한 후에 list를 보낸다. 
			try {
				Socket s = new Socket("127.0.0.1",6000);
				OutputStream out = s.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(out);
				oos.writeObject(list);
				
				out.close();
				oos.close();
				s.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//field
	//Book[] list;//Megazine, novel을 저장할 수 있는 배열
	ArrayList<Book> list = new ArrayList<>();
	int sum = 0;
	private BookManager() {
		open();
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

	@Override
	public void update(String isbn, int price) {
		// TODO Auto-generated method stub
		findByIsbn(isbn).setPrice(price);
		
	}

	@Override
	public void remove(String isbn) {
		// TODO Auto-generated method stub
		list.remove(findByIsbn(isbn));		
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		// TODO Auto-generated method stub
		Book book = findByIsbn(isbn);
		if(book == null)
			throw new ISBNNotFoundException();
		if(book.getQuantity() - quantity < 0)
			throw new QuantityException();
		else
			book.setQuantity(book.getQuantity() - quantity);
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		// TODO Auto-generated method stub
		Book book = findByIsbn(isbn);
		if(book == null)
			throw new ISBNNotFoundException();
		book.setQuantity(book.getQuantity() + quantity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void open(){
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("book.dat"))) {
			Object obj=ois.readObject();
			if(obj!=null) {
				list=(ArrayList<Book>)obj;
			}
			System.out.println("자료 로딩 성공");
			ois.close();
		}catch(FileNotFoundException e) {
			System.out.println("지정한 파일이 없습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//7. 프로그램 종료시에 호출되어지며, ArrayList에 있는 도서 정보를 파일로 저장한다.
	public void close(){
		try{
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("book.dat"));//filter stream
			oos.writeObject(list);//객체 저장
			oos.close();
		}catch(FileNotFoundException e) {
			System.out.println("지정한 파일이 없습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void send() {
		// TODO Auto-generated method stub
		BookClient bc = new BookClient();//이 자체로 쓰레드
		bc.start();
	}
	
}
