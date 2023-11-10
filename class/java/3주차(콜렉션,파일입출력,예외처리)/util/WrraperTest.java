package com.util;

public class WrraperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		short s = 45;
		int i = 889;
		double d = 8.99;
		boolean flag = true;
		
		//기본형 -> 참조형(객체)로 변환시켜주는 클래스 : WrrapperClass
		Integer i2 = new Integer(i); //기본형->객체 boxing
		Short s2 = new Short(s);
		Double d2 = new Double(d);
		Boolean flag2 = new Boolean(flag);
		
		int i3 = i2.intValue(); // 객체 -> 기본형.unboxing
		double d3 = d2.doubleValue();
		
		int num = 123;
		String num3 = num + "";
		String num2 = String.valueOf(num);
	}

}
