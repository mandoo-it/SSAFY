package com.thread;

public class WaitNotifyTest implements Runnable{

	int bread;//빵 개수, 공유 데이터
	Thread producer, consumer, producer2,consumer2 ;
	
	public WaitNotifyTest() {
		producer = new Thread(this,"producer");
		producer2 = new Thread(this,"producer");
		consumer = new Thread(this, "consumer");
		consumer2 = new Thread(this, "consumer");
		
		producer.start();
		producer2.start();
		consumer.start();
		consumer2.start();
		
		
		
	}
	
	public static void main(String[] args) {
		new WaitNotifyTest();
	}
	
	//thread가 일하는 내용을 가진 메소드
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			long time = (long)(Math.random() * 3000 + 10);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			doJob();
		}
		
	}

	private synchronized void doJob() {
		String name = Thread.currentThread().getName();
		if(name.equals("producer")) { // 빵만드는 Thread
			if(bread >= 3) { // 꽉 차있는 상태
				notify(); //빵무라
				try {
					System.out.println(name + " 빵이 가득차서 쉬러감 현재 빵 개수 " + bread);
					wait(); //자신은 쉬러감
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				bread++;
				System.out.println("빵 만듬. 현재 빵 갯수 " + bread);
			}
			
			
		}else { // 빵 먹는 thread
			if(bread<=0) {
				notify();//빵 만들라고 신호보냄
				try {
					System.out.println(name +" 빵이 없어가 쉬러감. 현재 빵 개수 " + bread);
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				bread--;
				System.out.println(name + " 빵 뭇다. 현재 빵 갯수 "+bread);
			}
			
		}
		
	}

}
