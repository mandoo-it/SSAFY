 package com.model;

public class Product {
	private int sn;
	private String name;
	private int price;
	private int stock;
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
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
