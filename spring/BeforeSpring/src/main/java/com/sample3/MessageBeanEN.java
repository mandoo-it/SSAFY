package com.sample3;

public class MessageBeanEN implements MessageBean{
	public MessageBeanEN() {
		System.out.println("생성자");
	}
	@Override
	public void sayHello() {
		System.out.println("방가루 스프링 + en");
		
	}

}
