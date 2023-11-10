package com.vo;

import java.io.Serializable;

public class Member implements Serializable {
	private String id        ;
	private String password  ;
	private String name      ;
	private String email     ;
	private String phone     ;
	private String address   ;
	private String al		 ;
	public Member() {}
	public Member(String id, String name, String email, String phone, String al) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.al = al;
	}
	public Member(String id, String password, String name, String email, String phone, String address, String al) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.al=al;
	}
	
	
	public String getAl() {
		return al;
	}
	public void setAl(String al) {
		this.al = al;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", phone="
				+ phone + ", address=" + address + ", al=" + al + "]";
	}

}
