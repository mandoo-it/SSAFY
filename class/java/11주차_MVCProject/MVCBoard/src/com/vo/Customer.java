package com.vo;
//vo (value object:customer 테이블 안의 레코드 한개의 값을 저장하기 위한 객체)
public class Customer {
	//field : 테이블안의 칼럼과 동일하게 추출
	private String num;
	private String name;
	private String address;

	public String getNum() {
		return num;
	}
	public Customer(String num, String name, String address) {
		this.num = num;
		this.name = name;
		this.address = address;
	}
	public Customer() {
		super();
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [num=" + num + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
