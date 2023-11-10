package com.ssafy;
import java.util.ArrayList;

import com.ssafy.DuplicateException;
import com.ssafy.ProductNotFoundException;

public interface IProductManager {

	void add(Product product) throws DuplicateException;
	ArrayList<Product> allProduct();
	Product findBySn(int sn) throws CodeNotFoundException;
	ArrayList<Product> findByName(String name);
	ArrayList<Product> findTv();
	ArrayList<Product> findRefrigerator();
	ArrayList<Product> deleteProduct(int sn);
	int sum();
	ArrayList<Product> findRefrigeratorByVolume() throws ProductNotFoundException;
	ArrayList<Product> findTvByInch() throws ProductNotFoundException;
	void changePrice(int sn, int price);
	void open();
	void close();
	
}
