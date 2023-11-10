package com.di;

public class MessageBeanEN implements MessageBean{
	//값이 주입이 되어야함
	private String num;
	private String name;
	private String address;//setter주입
	private Truck truck;
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	//생성자 주입
	public MessageBeanEN(String num, String name) {
		this.num = num;
		this.name = name;
	}
	@Override
	public void sayHello() {
		System.out.println(num);
		System.out.println(name);
		System.out.println(address);
		truck.work();
		
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

}
