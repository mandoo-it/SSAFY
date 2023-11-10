package com.thread;

//쓰레드 클래스 상속받는 방법 : 
class Tiger extends Thread{
	//thread가 해야할 작업 내용을 가지고 있는 메소드 : thread를 상속받은 클래스 자신이 곧 thread가 됨
	//callback 메소드 : 특정 조건(start()가 호출되는 경우)이 만족되면 자동 실행되는 메소드. 간접 호출됨
	public void run() {
		System.out.println(getName() + " is running..."); // getName()은 부모의 메소드(스레드의 이름)
	}
}

public class TigerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//메인까지 쓰레드가 총 4개
		Tiger t1 = new Tiger();//tiger은 쓰레드타입
		Tiger t2 = new Tiger();
		Tiger t3 = new Tiger();
		//t1.run();//run과 start의 차이 : start()는 t1이 일하러 가는데(메인이 start()실행하면 t1이라는 일꾼을 보내 run()을 실행시킨다.) / run()은  main thread에 의해 실행된다. 
		t1.start(); //thread 작업 시작을 알리는 메소드
		t2.start();
		t3.start();
		//t1.stop();
		

	}

}
