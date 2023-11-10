package com.di.javaconfig;


public class Tiger implements Animal {
	private int age;
	private String name;
	
	public Tiger(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void info() {
		System.out.println("------Tiger--------------");
		System.out.println("나이      :  "+age);
		System.out.println("이름    :  "+name);
		System.out.println("----------------------------");
		System.out.println();
		
	}

}
