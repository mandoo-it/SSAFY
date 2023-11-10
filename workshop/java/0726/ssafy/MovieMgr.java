package com.ssafy;

public class MovieMgr {
	private Movie[] movie = new Movie[100];
	private int index;
	
		private MovieMgr() {
			
		}
		//2.singleton - 3의 static 메소드 안에는 static 변수밖에 쓰지 못한다. 
		private static MovieMgr instance = new MovieMgr();
		
		//3.singleton 
		public static MovieMgr getInstance() {
			return instance;
		}
		
		public void add(Movie m) {
			movie[index++] = m;
		}
		
		public Movie[] search() {
			Movie[] arr = new Movie[index];
			for(int i=0;i<index;i++) {
				arr[i] = movie[i];
			}
			return arr;
		}
		
		public Movie[] search(String title) {
			int ct = 0;
			for(int i=0;i<index;i++) {
				if(movie[i].getTitle().contains(title))
					ct++;
			}
			Movie[] arr = new Movie[ct];
			ct = 0;
			for(int i=0;i<index;i++) {
				if(movie[i].getTitle().contains(title))
					arr[ct++] = movie[i];
			}
			return arr;
			
		}
		
		public Movie[] searchDirector(String name) {
			int ct = 0;
			for(int i=0;i<index;i++) {
				if(movie[i].getDirector().contains(name))
					ct++;
			}
			Movie[] arr = new Movie[ct];
			ct = 0;
			for(int i=0;i<index;i++) {
				if(movie[i].getDirector().contains(name))
					arr[ct++] = movie[i];
			}
			return arr;
			
		}
		
		public Movie[] searchGenre(String genre) {
			int ct = 0;
			for(int i=0;i<index;i++) {
				if(movie[i].getGenre().equals(genre))
					ct++;
			}
			Movie[] arr = new Movie[ct];
			ct = 0;
			for(int i=0;i<index;i++) {
				if(movie[i].getGenre().equals(genre))
					arr[ct++] = movie[i];
			}
			return arr;
		}
		
		public void delete(String title) {
			for(int i=0;i<index;i++) {
				if(movie[i].getTitle().equals(title)) {
					index--;
					movie[i] = movie[index];
					movie[index] = null;
					i--;
				}
			}
		}
		
		public int size( ) {
			return index;
		}
}
