package com.util;

import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		//generic progamming 방식에 맞훠 객체 생성
		Vector<String> v2 = new Vector<String>();
		v2.add("11");
		v2.add("22");
		v2.add("33");
		
		Vector v1 = new Vector(2, 5);
		System.out.println(v1.capacity());
		v1.add(123);
		v1.add("hello");
		v1.add(2.87);
		v1.add(true);
		
		v1.remove(true); //값을넣을 수도 있고 인덱스를 넣을 수도 있다. 
		v1.set(0, "Red");
		System.out.println(v1.capacity());
		for(int i=0;i< v1.size();i++) {
			System.out.println(v1.get(i));
		}
		v1.clear();
		for(int i=0;i< v1.size();i++) {
			System.out.println(v1.get(i));
		}
	}

}
