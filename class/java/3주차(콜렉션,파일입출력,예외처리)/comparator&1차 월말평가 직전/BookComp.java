package com.ssafy.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookComp {

	public static void main(String[] args) {
//		List<String> list = new ArrayList<String>();
//		list.add("홍길동");
//		list.add("손오공");
//		list.add("강호동");
//		list.add("사오정");
//		Collections.sort(list);
//		System.out.println(list);

		List<Book> list = new ArrayList<>();
		list.add(new Book("123", "홍길동", 1200, 15));
		list.add(new Book("123", "홍길동", 1200, 12));
		list.add(new Book("456", "손오공", 170, 10));
		list.add(new Book("777", "강호동", 17000, 10));
		list.add(new Book("123", "홍길동", 1000, 10));
		list.add(new Magazine("123", "홍길동매거진", 1000, 10));
		for (Book b : list) {
			System.out.println(b);
		}
		System.out.println("---------------------------------");
		Collections.sort(list);
		for (Book b : list) {
			System.out.println(b);
		}
		System.out.println("---------------------------------");
		Collections.sort(list, new BookComparator());
		for (Book b : list) {
			System.out.println(b);
		}
	
	}

}
