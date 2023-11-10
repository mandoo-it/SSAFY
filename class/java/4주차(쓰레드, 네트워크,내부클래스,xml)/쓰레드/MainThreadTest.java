package com.thread;

public class MainThreadTest implements Runnable {
	//쓰레드 생성, start
	//쓰레드 두개(메인, thread)
	public MainThreadTest() {
		Thread t = new Thread(this);//자기 자신을 넣어서 객체 생성
		t.start();
		try {
			t.join();//7번줄을 실행하는 아이(메인)ㅣ보고 기다려라. 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainThreadTest m = new MainThreadTest();
	
		m.go();//메인이 실행 - 메인이 우선순위가 높아서 메인이 실행하는 메소드가 먼저 실행된다. 

	}
	public void go() {
		System.out.println("gogogo~~~~");
	}
	@Override
	public void run() {//thread가 수행하는 메소드
		// TODO Auto-generated method stub
		System.out.println("thread가 실행...");
	}

}
