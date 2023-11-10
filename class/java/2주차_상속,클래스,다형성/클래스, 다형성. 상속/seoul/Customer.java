package com.seoul;

public class Customer {
	//field
	private int num;
	private String name;
	private String address;
	
	//getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	//메쏘드가 public이라서 field가 PRIVATE이라도 이런식으로 접근 가능하다
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
