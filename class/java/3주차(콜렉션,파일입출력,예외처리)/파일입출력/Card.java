package com.io;

import java.io.Serializable;

//value object
//stream을 통해 객체를 이동시키려면 직렬화조건을 만족시켜야한다. 
//직렬화 : 객체가 스트림을 통해 객체 안의 데이터가 바이트 스트림으로 바뀌어 전송되는 일
//직렬화(Serialization)조건 : serializable 인터페이스 구현
public class Card implements Serializable{
	private int num;
	private String name;
	private String company;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Card(int num, String name, String company) {
		this.num = num;
		this.name = name;
		this.company = company;
	}
	
	
}
