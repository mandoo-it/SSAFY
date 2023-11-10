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
			if(list[j].getSn() == sn)
					return list[j];
		}
		return null;
	}

	public Product[] findByName(String name) {
		// TODO Auto-generated method stub
		int ct = 0;
		for(int j=0;j<i;j++) {
			if(list[j].getName().contains(name))
					ct++;
		}
		Product[] product_arr = new Product[ct];
		int count = 0;
		for(int j=0;j<i;j++) {
			if(list[j].getName().contains(name)) {
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
			if(list[j].getSn() == sn) {
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
				sum += list[j].getPrice() * list[j].getStock(); 
		}
		return sum;
	}
	
	public int getPriceByType(String type) {
		int sum2 = 0;
		if(type.equals("냉장고")) {
			for(int j=0;j<i;j++) {
				if(list[j] instanceof Refrigerator) {
					sum2 += list[j].getStock() * list[j].getPrice();
				}
			}
		}
		else if(type.equals("tv")) {
			for(int j=0;j<i;j++) {
				if(list[j] instanceof Tv) {
					sum2 += list[j].getStock() * list[j].getPrice();
				}
			}
		}
		return sum2;
		
	}
	
	public int getPriceByType(Product p) {
		int sum2 = 0;
		if(p instanceof Tv) {
			for(int j=0;j<i;j++) {
				if(list[j] instanceof Tv) {
					sum2 += list[j].getStock() * list[j].getPrice();
				}
			}
		}
		else if(p instanceof Refrigerator) {
			for(int j=0;j<i;j++) {
				if(list[j] instanceof Refrigerator) {
					sum2 += list[j].getStock() * list[j].getPrice();
				}
			}
		}
		return sum2;
		
	}
	
	public int getStockByType(String type) {
		int sum2 = 0;
		if(type.equals("냉장고")) {
			for(int j=0;j<i;j++) {
				if(list[j] instanceof Refrigerator) {
					sum2 += list[j].getStock();
				}
			}
		}
		else if(type.equals("tv")) {
			for(int j=0;j<i;j++) {
				if(list[j] instanceof Tv) {
					sum2 += list[j].getStock();
				}
			}
		}
		return sum2;
		
	}
	
	public int getStockByType(Product p) {
		int sum2 = 0;
		if(p instanceof Tv) {
			for(int j=0;j<i;j++) {
				if(list[j] instanceof Tv) {
					sum2 += list[j].getStock();
				}
			}
		}
		else if(p instanceof Refrigerator) {
			for(int j=0;j<i;j++) {
				if(list[j] instanceof Refrigerator) {
					sum2 += list[j].getStock();
				}
			}
		}
		return sum2;
		
	}
	
	public int getAverageInch() {
		int sum2 = 0;
		int ct =0 ;
		for(int j=0;j<i;j++) {
			if(list[j] instanceof Tv) {
				Tv t = (Tv)list[j];
				sum2 += t.getInch()*t.getStock();
				ct += t.getStock();
			}
		}
		return sum2 / ct;
		
	}
	
	public int getTotalVolume() {
		int sum2 = 0;
		for(int j=0;j<i;j++) {
			if(list[j] instanceof Refrigerator) {
				Refrigerator t = (Refrigerator)list[j];
				sum2 += t.getVolume();
			}
		}
		return sum2;
		
	}
	
	public Product[] lowerPriceProduct(String name, int price) {
		int idx = 0;
		for(int j=0;j<i;j++) {
			if(list[j].getName().contains(name)) {
				if(list[j].getPrice() < price) 
					idx++;
			}
		}
		Product[] arr = new Product[idx];
		idx = 0;
		for(int j=0;j<i;j++) {
			if(list[j].getName().contains(name)) {
				if(list[j].getPrice() < price) 
					arr[idx++] = list[j];
			}
		}
		return arr;
		
	}	
}
