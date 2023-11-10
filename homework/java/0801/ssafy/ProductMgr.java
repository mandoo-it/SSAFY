package com.ssafy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.ssafy.DuplicateException;
//megazine, novel을 관리하는 메소드를 가지고 있는 관리 클래스
public class ProductMgr implements IProductManager{
	ArrayList<Product> list = new ArrayList<>();
	int sum;
	
	private ProductMgr() {
		open();
	}
	
	private static ProductMgr instance = new ProductMgr();
	
	//3.singleton 
	public static ProductMgr getInstance() {
		return instance;
	}
	@Override
	public void add(Product product) throws DuplicateException{
		// TODO Auto-generated method stub
		Product p;
		for(int j=0;j<list.size();j++) {
			if(list.get(j).getSn() == product.getSn()) 
				throw new DuplicateException();	
		}
		list.add(product);
	}

	@Override
	public ArrayList<Product> allProduct() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Product findBySn(int sn) throws CodeNotFoundException{
		// TODO Auto-generated method stub
		for(int j=0;j<list.size();j++) {
			if(list.get(j).getSn() == sn)
					return list.get(j);
		}
		throw new CodeNotFoundException();
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
	public ArrayList<Product> findRefrigeratorByVolume() throws ProductNotFoundException{
		ArrayList<Product> pr_list = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i) instanceof Refrigerator) {
				Refrigerator r = (Refrigerator)list.get(i);
				if(r.getVolume() >= 400) {
					pr_list.add(r);
				}
			}
		}
		if(pr_list.size() == 0) throw new ProductNotFoundException();
		return pr_list;
	}
	@Override
	public ArrayList<Product> findTvByInch() throws ProductNotFoundException{
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
		if(pr_list.size() == 0) throw new ProductNotFoundException();
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
	@SuppressWarnings("unchecked")
	@Override
	public void open(){
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("product.dat"))) {
			Object obj=ois.readObject();
			if(obj!=null) {
				list=(ArrayList<Product>)obj;
			}
			System.out.println("자료 로딩 성공");
			ois.close();
		}catch(FileNotFoundException e) {
			System.out.println("지정한 파일이 없습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//7. 프로그램 종료시에 호출되어지며, ArrayList에 있는 도서 정보를 파일로 저장한다.
	public void close(){
		try{
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("product.dat"));//filter stream
			oos.writeObject(list);//객체 저장
			oos.close();
		}catch(FileNotFoundException e) {
			System.out.println("지정한 파일이 없습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}




}
