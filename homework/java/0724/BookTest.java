package com.ssafy;

public class BookTest {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		
	Book b1 = new Book("21424", "JavaPro", "김하나", "Jaen.kr", 15000, "Java기본문법");
	Book b2 = new Book("35355", "분석설계", "소나무", "Jaen.kr", 30000, "sw모델링");
	Magazine m1 = new Magazine("35355", "Java World", "편집부", "java.com", 7000,"첫걸음",2018,2);
	
	System.out.println("*********************도서 목록*********************");
	System.out.println(b1.toString());
	System.out.println(b2.toString());
	System.out.println(m1.toString());
	
	
	
	}

}
