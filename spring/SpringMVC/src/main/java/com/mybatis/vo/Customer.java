package com.mybatis.vo;

import org.apache.ibatis.type.Alias;

//vo : getter/setter/default생성자, private field
@Alias("Customer")
public class Customer {
	private String num, name, address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Customer(String num, String name, String address) {
		this.num = num;
		this.name = name;
		this.address = address;
	}

	public Customer() {
	}
	
}
