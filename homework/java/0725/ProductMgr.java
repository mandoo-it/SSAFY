package com.ssafy;

//megazine, novel을 관리하는 메소드를 가지고 있는 관리 클래스
public class ProductMgr {
	//field
	Product[] list;//Megazine, novel을 저장할 수 있는 배열
	int i = 0;
	int sum = 0;
	public ProductMgr() {
		list = new Product[5];
	}

	public void add(Product product) {
		// TODO Auto-generated method stub
		list[i] = product;
		i++;	
	}

	public Product[] allProduct() {
		// TODO Auto-generated method stub
		return list;
	}

	public Product findBySn(int sn) {
		// TODO Auto-generated method stub
		for(int j=0;j<i;j++) {
			if(list[j].sn == sn)
					return list[j];
		}
		return null;
	}

	public Product[] findByName(String name) {
		// TODO Auto-generated method stub
		int ct = 0;
		for(int j=0;j<i;j++) {
			if(list[j].name.contains(name))
					ct++;
		}
		Product[] product_arr = new Product[ct];
		int count = 0;
		for(int j=0;j<i;j++) {
			if(list[j].name.contains(name)) {
				product_arr[count] = list[j];
				count++;
			}
		}
		return product_arr;
	}
	
	public Product[] findTv() {
		// TODO Auto-generated method stub
		int ct = 0;
		for(int j=0;j<i;j++) {
			if(list[j].getClass().getSimpleName().contains("Tv"))
					ct++;
		}
		Product[] product_arr = new Product[ct];
		int count = 0;
		for(int j=0;j<i;j++) {
			if(list[j].getClass().getSimpleName().contains("Tv")) {
				product_arr[count] = list[j];
				count++;
			}
		}
		return product_arr;
	}
	
	public Product[] findRefrigerator() {
		// TODO Auto-generated method stub
		int ct = 0;
		for(int j=0;j<i;j++) {
			if(list[j].getClass().getSimpleName().contains("Refrigerator"))
					ct++;
		}
		Product[] product_arr = new Product[ct];
		int count = 0;
		for(int j=0;j<i;j++) {
			if(list[j].getClass().getSimpleName().contains("Refrigerator")) {
				product_arr[count] = list[j];
				count++;
			}
		}
		return product_arr;
	}
	
	public Product[] deleteProduct(int sn) {
		// TODO Auto-generated method stub
		int index = -1;
		for(int j=0;j<i;j++) {
			if(list[j].sn == sn) {
				index = j;
				list[index] = list[i-1];
				list[i-1] = null;
				i--;
			}
					
		}
		return list;
		
	}

	public int sum() {
		// TODO Auto-generated method stub
		for(int j=0;j<i;j++)
		{
				sum += list[j].price * list[j].stock; 
		}
		return sum;
	}
	
}
