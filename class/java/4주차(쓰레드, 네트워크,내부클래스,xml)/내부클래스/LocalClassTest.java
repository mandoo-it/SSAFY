package com.inner;
//local class : 메소드 안에 선언되어있는 클래스, 메소드 내부에서만 사용 가능
class Mountain{
	int height = 1950;
	
	public void go() {
		class Gold{ //local inner class
			void dig() {
				System.out.println("h" + height);
			}
		}
		Gold g = new Gold();
		g.dig();
		System.out.println(g.getClass().getName());
	}
}
public class LocalClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mountain m = new Mountain();
		m.go();
	}

}
