package com.inner;
//static class : 내부 클래스를 바로 사용 가능
class Out{//top-level-class
	static int num = 999;
	
	static class In{//static inner class
		public void go() {
			System.out.println("num: " + num);
		}
	}
}
public class StaticClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Out.In i = new Out.In();
		i.go();
		System.out.println(i.getClass().getName());

	}

}
