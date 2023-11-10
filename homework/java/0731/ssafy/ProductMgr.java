package com.ssafy;

import java.util.ArrayList;

//megazine, novel을 관리하는 메소드를 가지고 있는 관리 클래스
public class ProductMgr implements IProductManager{
	ArrayList<Product> list = new ArrayList<>();
	int sum;
	
	private ProductMgr() {
	}
	
	private static ProductMgr instance = new ProductMgr();
	
	//3.singleton 
	public static ProductMgr getInstance() {
		return instance;
	}
	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		list.add(product);
	}

	@Override
	public ArrayList<Product> allProduct() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Product findBySn(int sn) {
		// TODO Auto-generated method stub
		for(int j=0;j<list.size();j++) {
			if(list.get(j).getSn() == sn)
					return list.get(j);
		}
		return null;
	}

	@Override
	public ArrayList<Product> findByName(String name) {
		// TODO Auto-generated method stub
		ArrayList<Product> pr_list = new ArrayList<>();
		for(int j=0;j<list.size();j++) {
			if(list.get(j).getName().contains(name)) {
				pr_list.add(list.get(j));
			}
		}
		return pr_list;
		
	}

	@Override
	public ArrayList<Product> findTv() {
		// TODO Auto-generated method stub
		ArrayList<Product> pr_list = new ArrayList<>();
		for(int j=0;j<list.size();j++) {
			if(list.get(j).getClass().getSimpleName().contains("Tv")) {
				pr_list.add(list.get(j));
			}
		}
		return pr_list;
	}

	@Override
	public ArrayList<Product> findRefrigerator() {
		// TODO Auto-generated method stub
		ArrayList<Product> pr_list = new ArrayList<>();
		for(int j=0;j<list.size();j++) {
			if(list.get(j).getClass().getSimpleName().contains("Refrigerator")) {
				pr_list.add(list.get(j));
			}
		}
		return pr_list;
	}

	@Override
	public ArrayList<Product> deleteProduct(int sn) {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getSn() == sn) {
				list.remove(i);
			}
		}
		return list;
	}
	@Override
	public int sum() {
		// TODO Auto-generated method stub
		for(int j=0;j<list.size();j++)
		{
				sum += list.get(j).getPrice() * list.get(j).getStock(); 
		}
		return sum;
	}
	@Override
	public ArrayList<Product> findRefrigeratorByVolume() {
		ArrayList<Product> pr_list = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i) instanceof Refrigerator) {
				Refrigerator r = (Refrigerator)list.get(i);
				if(r.getVolume() >= 400) {
					pr_list.add(r);
				}
			}
		}
		return pr_list;
	}
	@Override
	public ArrayList<Product> findTvByInch() {
		// TODO Auto-generated method stub
		ArrayList<Product> pr_list = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i) instanceof Tv) {
				Tv r = (Tv)list.get(i);
				if(r.getInch() >= 50) {
					pr_list.add(r);
				}
			}
		}
		return pr_list;
	}
	@Override
	public void changePrice(int sn, int price) {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getSn() == sn) {
				list.get(i).setPrice(price);
			}
		}
	}




}
