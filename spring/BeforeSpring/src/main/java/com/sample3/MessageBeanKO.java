package com.sample3;

public class MessageBeanKO implements MessageBean{

	public MessageBeanKO() {
		System.out.println("생성자");
	}
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("방가루 스프링 + ko");
	}




}
