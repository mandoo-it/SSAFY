package com.util;

import com.abst.Circle;

//컴파일 후 실행할 때 X의 타입 결정
public class GenericTest<X> {
		// TODO Auto-generated method stub
		private int num;
		private X what;
		
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public X getWhat() {
			return what;
		}
		public void setWhat(X what) {
			this.what = what;
		}
		
		public static void main(String[] args) {
			GenericTest<String> g1 = new GenericTest<>();
			GenericTest<Integer> g2 = new GenericTest<>();
			GenericTest<Circle> g3 = new GenericTest<>();
			
			g1.setWhat("hello");
			g2.setWhat(new Integer(456));
			
			System.out.println(g1.getWhat());
			System.out.println(g2.getWhat());
			
		}



}
