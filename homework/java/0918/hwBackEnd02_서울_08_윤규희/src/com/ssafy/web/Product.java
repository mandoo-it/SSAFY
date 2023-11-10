package com.ssafy.web;

//Product p = new Product(pid,  pname, price, description, quantity);
public class Product {
	String pid;
	String pname;
	String price;
	String description;
	String quantity;
	
	public Product() {
	
	}
	
	public Product(String pid, String pname, String price, String description, String quantity) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
}
