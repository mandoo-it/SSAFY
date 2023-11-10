package com.ssafy;

import java.util.Scanner;

public class MovieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MovieMgr mg = MovieMgr.getInstance();
		
		mg.add(new Movie("명량", "이승철", 3, "한국사", "이순신장군"));
		mg.add(new Movie("해리포터", "조앤롤링", 3, "판타지", "즐거운 마법학교"));
		mg.add(new Movie("독전", "차승원", 1, "스릴러"));
		
		StringBuffer s = new  StringBuffer();
		s
		.append("<<<영화 관리 프로그램>>>\n")
		.append("1.영화 정보 입력\n")
		.append("2.영화 정보 전체 검색\n")
		.append("3.영화명 검색\n")
		.append("4.영화 장르별 검색\n")
		.append("5.영화 정보 삭제\n")
		.append("0. 종료\n")
		.append("원하는 정보를 선택하세요. ");
		int input = 0;
		do {
			System.out.println();
			System.out.println(s.toString());
			input = sc.nextInt();
			switch(input) {
				case 1 : 
					System.out.print("영화 제목을 입력하세요 : ");
					String title = sc.next();
					System.out.print("영화 감독 입력하세요 : ");
					String director = sc.next();
					System.out.print("영화 등급 입력하세요 : ");
					String grade_str = sc.next();
					System.out.print("영화 장르를 입력하세요 : ");
					String genre = sc.next();
					System.out.println("줄거리를 입력하세요 ");
					String summary = sc.next();
					mg.add(new Movie(title,director,Integer.parseInt(grade_str),genre,summary));
					System.out.println();
					break;
				case 2 : 
					if(mg.search().length > 0) {
						for(Movie m : mg.search()) 
							System.out.println(m);
					} else System.out.println("등록된 영화가 없습니다. ");
					break;
				
				case 3 : 
					System.out.print("검색할 영화명을 입력하세요 : ");
					String search_title = sc.next();
					if(mg.search(search_title).length > 0) {
						for(Movie m : mg.search(search_title)) 
							System.out.println(m);
					} else System.out.println("해당되는 영화가 없습니다.");
					break;
				case 4 : 
					System.out.print("검색할 영화 장르를 입력하세요 : ");
					String search_gr = sc.next();
					if(mg.searchGenre(search_gr).length > 0) {
						for(Movie m : mg.searchGenre(search_gr)) 
							System.out.println(m);
					} else System.out.println("해당되는 영화가 없습니다.");
					break;
				case 5 : 
					System.out.print("삭제할 영화 제목을 입력하시오: ");
					String delete_title = sc.next();
					mg.delete(delete_title);
					break;
				case 6 : 
					System.out.print("검색할 영화 감독을 입력하세요 : ");
					String search_dr = sc.next();
					if(mg.searchDirector(search_dr).length > 0) {
						for(Movie m : mg.searchDirector(search_dr)) 
							System.out.println(m);
					} else System.out.println("해당되는 영화가 없습니다.");
					break;
				case 0 : {
					System.out.println("잘가요");
					break;
				}
			}
		} while(input != 0);
		
		
	}

}
