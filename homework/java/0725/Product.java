package com.ssafy;

public class Product {
	int sn;
	String name;
	int price;
	int stock;
	public Product(int sn, String name, int price, int stock) {
		super();
		this.sn = sn;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	@Override
	public String toString() {
		return sn + "  |  " +name + "  |  " + price + "  |  " + stock;
	}
	
}
