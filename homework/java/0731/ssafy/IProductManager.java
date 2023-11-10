package com.ssafy;
import java.util.ArrayList;

public interface IProductManager {

	void add(Product product);
	ArrayList<Product> allProduct();
	Product findBySn(int sn);
	ArrayList<Product> findByName(String name);
	ArrayList<Product> findTv();
	ArrayList<Product> findRefrigerator();
	ArrayList<Product> deleteProduct(int sn);
	int sum();
	ArrayList<Product> findRefrigeratorByVolume();
	ArrayList<Product> findTvByInch();
	void changePrice(int sn, int price);
	
}
