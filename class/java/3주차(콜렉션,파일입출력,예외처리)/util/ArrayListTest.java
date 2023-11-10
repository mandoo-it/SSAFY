package com.util;

import java.util.ArrayList;

import com.abst.Circle;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Circle> list = new ArrayList<>();
		list.add(new Circle(8));
		list.add(new Circle(9));
		list.add(new Circle(10));
//		list.add("tommy");
//		list.add("bille");
//		list.add("jane");
//		list.add("loy");
//		list.add("kim");
//		list.add("hey");
		
		//list.add(99);
		//list.add(Interger.parseInt(99)); //이렇게 해야지 원래 추가되지만 현재 버전으로는 위에처럼 자동으로 박싱 해준다. 
		for(Circle name:list) {
			System.out.println("면적" + name.getArea());
			System.out.println("둘레" + name.getCircum());
		}
	}

}
