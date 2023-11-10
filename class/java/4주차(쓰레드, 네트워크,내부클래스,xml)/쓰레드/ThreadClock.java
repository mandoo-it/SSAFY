package com.thread;

import java.util.Date;

public class ThreadClock implements Runnable{
	public ThreadClock() {
		//thread을 생성하고 start시키고 
		Thread t = new Thread(this);
		t.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadClock();
	}
    
	//1초 간격으로 화면에 시간정보를 출력하기
	@Override
	public void run() { //쓰레드가 일할 내용을 가진 메소드
		while(true) {
			Date d = new Date();
			System.out.println(d);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
