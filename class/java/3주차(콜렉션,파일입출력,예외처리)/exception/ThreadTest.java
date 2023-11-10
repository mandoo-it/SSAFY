package com.exception;
//Checked Exception : InterruptedException
public class ThreadTest {
	public static void main(String[] args) {
		//Thread t = new Thread();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 3초간 쓰레드가 잠을 잔다
		
		System.out.println("hello~~~~~~~~");
	}

}
