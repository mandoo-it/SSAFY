package com.ssafy.book;

import java.util.Scanner;

public class BookTest {
	BookMgrImpl mgr = BookMgrImpl.getInstance();
	Scanner sc = new Scanner(System.in);

	public BookTest() {
		load();
	}

	public static void main(String[] args) {
		BookTest m = new BookTest();
		while (true) {
			int n = m.menu();
			if (n == 0) {
				m.save();
				break;
			}
			switch (n) {
			case 1:
				m.add();
				break;
			case 2:
				m.search();
				break;
			case 3:
				m.searchIsbn();
				break;
			case 4:
				m.update();
				break;
			case 5:
				m.delete();
				break;

			default:
				break;
			}
		}
	}

	private int menu() {
		System.out.println("1. 등록");
		System.out.println("2. 전체 검색(정렬 적용)");
		System.out.println("3. ISBN으로 검색");
		System.out.println("4. 변겅");
		System.out.println("5. 삭제");
		System.out.println("0. 종류");
		System.out.println("메뉴 선택? : ");
		return Integer.parseInt(sc.nextLine());
	}

	private void load() {
		mgr.load();
	}

	private void save() {
		mgr.save();
	}

	private void add() {
		try {
			System.out.println("북 등록(예 : isbn, title, price, quantity)");
			String s = sc.nextLine();
			String[] sa = s.split(",");
			String isbn = sa[0];
			String title = sa[1];
			int price = Integer.parseInt(sa[2]);
			int quantity = Integer.parseInt(sa[3]);
			Book b = new Book(isbn, title, price, quantity);
			mgr.add(b);
		} catch (DuplicateException e) {
			System.out.println("등록예외 : " + e.getMessage());
		}
	}

	private void search() {
		for (Book b : mgr.search()) {
			System.out.println(b);
		}
	}

	private void searchIsbn() {
		System.out.println("북 검색(예 : isbn)");
		String isbn = sc.nextLine();
		try {
			Book b = mgr.search(isbn);
			System.out.println(b);
		} catch (NotFoundException e) {
			System.out.println("검색 예외 : " + e.getMessage());
		}

	}

	private void update() {
		System.out.println("북 변경(예 : isbn, price)");
		String[] sa = sc.nextLine().split(",");
		String isbn = sa[0];
		int price = Integer.parseInt(sa[1]);
		try {
			mgr.update(isbn, price);
		} catch (NotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void delete() {
		System.out.println("북 삭제(예 : isbn)");
		String isbn = sc.nextLine();
		try {
			mgr.delete(isbn);
		} catch (NotFoundException e) {
			System.out.println("검색 예외 : " + e.getMessage());
		}

	}

}
