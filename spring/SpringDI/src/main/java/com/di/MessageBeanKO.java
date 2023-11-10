package com.di;

public class MessageBeanKO implements MessageBean{
	private String num;
	private String name;
	private String city;//생성자 주입
	private Truck truck;
	
	public void setTruck(Truck truck) {
		this.truck = truck;
	}
	//setter 주입
	public MessageBeanKO() {
		System.out.println("생성자");
	}
	public MessageBeanKO(String city) {
		this.city = city;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println(num);
		System.out.println(name);
		System.out.println(city);
		truck.work();
	}




}
