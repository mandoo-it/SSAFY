package com.thread;
//Runnable 인터페이스를 구현하는 경우: 
class Lion implements Runnable{

	@Override
	
	public void run() {
		// TODO Auto-generated method stub
		Thread t = Thread.currentThread();//현재 실행중인 쓰레드를 알아냄 (static이라 객체 안만들고 바로쓴다. Math.처럼)
		System.out.println(t.getName() + " is playing....");
	}
	
}
public class LionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lion lion1 = new Lion(); //쓰레드타입 아니다. 러너블 타입(Runnable 객체)
		Lion lion2 = new Lion();
		Lion lion3 = new Lion();
		Thread t1 = new Thread(lion1);//Runnable객체를 인수로 전달
		Thread t2 = new Thread(lion2);//Runnable객체를 인수로 전달
		Thread t3 = new Thread(lion3);//Runnable객체를 인수로 전달
		t1.start();
		t2.start();
		t3.start();
		

	}

}
