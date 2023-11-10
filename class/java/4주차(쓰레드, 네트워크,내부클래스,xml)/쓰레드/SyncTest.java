package com.thread;
//synchronization(동기화) : 여러개의 스레드가 공유자원을 사용하려 할 때 한개의 쓰레드만 제외하고 
//다른 스레들들의 접근을 막는 것: 순차실행

public class SyncTest implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SyncTest().go();
	}

	//thread생성 및 start
	private void go() {
		Thread tom = new Thread(this,"tom");
		Thread jerry = new Thread(this,"jerry");
		
		tom.start();
		jerry.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		livingroom();
		kitchen();
	}

	private synchronized void kitchen() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		System.out.println(name + " is in kitchen..");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + " is out from kitchen..");
	}

	private synchronized void livingroom() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		System.out.println(name + " is in livingroom..");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + " is out from livingroom..");
	}

}
