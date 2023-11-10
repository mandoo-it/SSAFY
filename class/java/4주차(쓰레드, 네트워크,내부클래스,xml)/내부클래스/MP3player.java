package com.inner;

//추상클래스는 객체 생성을 하지 못한다.
abstract class Song{
	abstract public void sing();
}
interface Movie{
	void play();
}
public class MP3player {
	public void play(Song s) {
		s.sing();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MP3player player = new MP3player();
		player.play(new Song( ) {//song을 상속받는 무명클래스 선언 & 생성
			@Override
			public void sing() {
				// TODO Auto-generated method stub
				System.out.println("happy~~~");
			} 
			
		});
		
	//	Movie m = new Movie();
//		player.play(new Movie() {
//
//			@Override
//			public void play() {
//				// TODO Auto-generated method stub
//				System.out.println("happy~~~");
//			}});
	}

}
