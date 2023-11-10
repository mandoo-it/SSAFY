package com.inner;
//member class : 내부클래스 생성 전에 외부 클래스가 반드시 생성되어있어야함

class Car{//top-level class
	int speed = 200;
	
	public class Engine{
		public void go() {
			System.out.println("speed" + speed);
		}
	}
	
}
public class MemberClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		Engine e = new Engine();
		//		e.go();
		Car c = new Car();
		System.out.println(c.speed);
		
		Car.Engine e = c.new Engine();
		e.go();

	}

}
