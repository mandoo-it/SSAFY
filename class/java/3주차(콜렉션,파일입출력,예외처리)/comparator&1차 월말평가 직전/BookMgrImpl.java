package com.ssafy.book;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookMgrImpl implements IBookMgr {

	private static BookMgrImpl instance = new BookMgrImpl();

	private BookMgrImpl() {

	}

	public static BookMgrImpl getInstance() {
		return instance;
	}

	private List<Book> books = new ArrayList<>();

	@Override
	public void add(Book b) throws DuplicateException {
		try {
			search(b.getIsbn());
			throw new DuplicateException(b.getIsbn());
		} catch (NotFoundException e) {
			books.add(b);
		}
	}

	@Override
	public List<Book> search() {
		Collections.sort(books, new BookComparator());
		return books;
	}

	@Override
	public Book search(String isbn) throws NotFoundException {
		for (Book b : books) {
			if (b.getIsbn().equals(isbn)) {
				return b;
			}
		}
		throw new NotFoundException(isbn);
	}

	@Override
	public void update(String isbn, int price) throws NotFoundException {
		Book b = search(isbn);
		b.setPrice(price);
	}

	@Override
	public void delete(String isbn) throws NotFoundException {
		Book b = search(isbn);
		books.remove(b);
	}

	@Override
	public void load() {
		try {
			FileInputStream fis = new FileInputStream("book.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			books = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
			System.out.println(" 잘 불러 옴 ");
		} catch (Exception e) {
			System.out.println("Exception 발생:book.dat파일이 없습니다.");
		}
	}

	@Override
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("book.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(books);
			fos.close();
			oos.close();
		} catch (IOException e) {
			System.out.println("IOException 발생");
		}
	}

}
