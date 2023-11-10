package com.ssafy;

public class BookTest {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	BookManager bm = BookManager.getInstance();
	bm.add(new Magazine("1", "Java World", "편집부", "java.com", 7000,"첫걸음",2018,2,2));
	bm.add(new Magazine("2", "Java World", "편집부", "java.com", 7000,"첫걸음",2019,2,3));
	bm.add(new Novel("3", "twilter", "편집부", "java.com", 7000,"첫걸음","호러",5));
	bm.add(new Novel("4", "Java World", "편집부", "java.com", 7000,"첫걸음","로맨스",9));
	bm.add(new Magazine("5", "Java World", "편집부", "java", 7000,"첫걸음",2019,2,10));
	
	System.out.println("-------------전체 검색----------------");
	for(Book book:bm.allBooks()) {
		System.out.println(book.toString());
	}
	System.out.println("-------------isbn으로 검색----------------");
	System.out.println(bm.findByIsbn("3").toString());
	
	System.out.println("-------------title으로 검색----------------");
	if(bm.findByTitle("twilterdd").size() > 0) {
		for(Book book:bm.findByTitle("twilter")) {
			System.out.println(book.toString());
		}
	}
	else 
		System.out.println("검색 결과 없음");

	System.out.println("-------------소설만 검색----------------");
	if(bm.findNovel().size() > 0) {
		for(Book book:bm.findNovel()) {
			System.out.println(book.toString());
		}
	}
	else 
		System.out.println("검색 결과 없음");
	
	System.out.println("-------------megazine만 검색----------------");
	if(bm.findMegazine().size() > 0) {
		for(Book book:bm.findMegazine()) {
			System.out.println(book.toString());
		}
	}
	else 
		System.out.println("검색 결과 없음");
	
	System.out.println("-------------출판사로만 검색----------------");
	if(bm.findByPublisher("java").size() > 0) {
		for(Book book:bm.findByPublisher("jav")) {
			System.out.println(book.toString());
		}
	}
	else 
		System.out.println("검색 결과 없음");
	
	System.out.println("-------------올해 출간된 잡지만 검색---------------");
	if(bm.findMegazineByYear().size() > 0) {
		for(Book book:bm.findMegazineByYear()) {
			System.out.println(book.toString());
		}
	}
	else 
		System.out.println("검색 결과 없음");
		
	System.out.println("-------------가격으로 검색 기능----------------");
	if(bm.findByPrice(7000).size() > 0) {
		for(Book book:bm.findByPrice(7000)) {
			System.out.println(book.toString());
		}
	}
	else 
		System.out.println("검색 결과 없음");
	
	System.out.println("-------------합계----------------");
	System.out.println(bm.sum());
	
	System.out.println("-------------평균----------------");
	System.out.println(bm.average());
	
	System.out.println("-------------isbn으로 특정 책 가격 수정----------------");
	bm.update("4", 8000);
	for(Book book:bm.allBooks()) {
		System.out.println(book.toString());
	}
	
	System.out.println("-------------isbn으로 특정 책 삭제----------------");
	bm.remove("4");
	bm.remove("3");
	for(Book book:bm.allBooks()) {
		System.out.println(book.toString());
	}
	
	try {
		bm.sell("00", 11);
	} catch (QuantityException e) {
		// TODO Auto-generated catch block
		System.out.println(e.toString());
	} catch (ISBNNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println(e.toString());
	}
	
	try {
		bm.buy("00", 12);
	} catch (ISBNNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println(e.toString());
	}
	
	bm.close();
	System.out.println("-------------서버에 책 정보 보내기----------------");
	bm.send();
	}

}
