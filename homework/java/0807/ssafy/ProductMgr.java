package com.ssafy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import com.ssafy.DuplicateException;

//megazine, novel을 관리하는 메소드를 가지고 있는 관리 클래스
public class ProductMgr implements IProductManager {
	// 내부 클랴수
	class ProductSend extends Thread {
		public void run() {// 서버로 접속한 후에 list를 보낸다.
			try {
				Socket s = new Socket("127.0.0.1", 7000);
				OutputStream out = s.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(out);
				ArrayList<Product> newarr= new ArrayList<>();
				for(Product p : list) {
					if(p instanceof Tv)
						newarr.add(p);
				}
				for(Product p : list) {
					if(p instanceof Refrigerator)
						newarr.add(p);
				}
				oos.writeObject(newarr);
				out.close();
				oos.close();
				s.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	class ProductSave extends Thread {
		public void run() {// 서버로 접속한 후에 list를 보낸다.
			close();
		}
	}

	ArrayList<Product> list;
	int sum;

	private ProductMgr() {
		list = new ArrayList<>();
	}

	private static ProductMgr instance = new ProductMgr();

	public static ProductMgr getInstance() {
		return instance;
	}

	@Override
	public void add(Product product) throws DuplicateException {
		// TODO Auto-generated method stub
		Product p;
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getSn() == product.getSn())
				throw new DuplicateException();
		}
		list.add(product);
	}

	@Override
	public ArrayList<Product> allProduct() {
		// TODO Auto-generated method stub
		Collections.sort(list);
		return list;
	}

	@Override
	public Product findBySn(int sn) throws CodeNotFoundException {
		// TODO Auto-generated method stub
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getSn() == sn)
				return list.get(j);
		}
		throw new CodeNotFoundException();
	}

	@Override
	public ArrayList<Product> findByName(String name) {
		// TODO Auto-generated method stub
		ArrayList<Product> pr_list = new ArrayList<>();
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getName().contains(name)) {
				pr_list.add(list.get(j));
			}
		}
		return pr_list;

	}

	@Override
	public ArrayList<Product> findTv() {
		// TODO Auto-generated method stub
		ArrayList<Product> pr_list = new ArrayList<>();
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getClass().getSimpleName().contains("Tv")) {
				pr_list.add(list.get(j));
			}
		}
		return pr_list;
	}

	@Override
	public ArrayList<Product> findRefrigerator() {
		// TODO Auto-generated method stub
		ArrayList<Product> pr_list = new ArrayList<>();
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getClass().getSimpleName().contains("Refrigerator")) {
				pr_list.add(list.get(j));
			}
		}
		return pr_list;
	}

	@Override
	public ArrayList<Product> deleteProduct(int sn) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSn() == sn) {
				list.remove(i);
			}
		}
		return list;
	}

	@Override
	public int sum() {
		// TODO Auto-generated method stub
		for (int j = 0; j < list.size(); j++) {
			sum += list.get(j).getPrice() * list.get(j).getStock();
		}
		return sum;
	}

	@Override
	public ArrayList<Product> findRefrigeratorByVolume() throws ProductNotFoundException {
		ArrayList<Product> pr_list = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Refrigerator) {
				Refrigerator r = (Refrigerator) list.get(i);
				if (r.getVolume() >= 400) {
					pr_list.add(r);
				}
			}
		}
		if (pr_list.size() == 0)
			throw new ProductNotFoundException();
		return pr_list;
	}

	@Override
	public ArrayList<Product> findTvByInch() throws ProductNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Product> pr_list = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Tv) {
				Tv r = (Tv) list.get(i);
				if (r.getInch() >= 50) {
					pr_list.add(r);
				}
			}
		}
		if (pr_list.size() == 0)
			throw new ProductNotFoundException();
		return pr_list;
	}

	@Override
	public void changePrice(int sn, int price) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSn() == sn) {
				list.get(i).setPrice(price);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void open() {
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("dd.dat"))) {
			Object ob = oi.readObject();
			if (ob != null)
				list = (ArrayList<Product>) ob;
		} catch (FileNotFoundException e) {
			System.out.println("지정한 파일이 없습니다. ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 7. 프로그램 종료시에 호출되어지며, ArrayList에 있는 도서 정보를 파일로 저장한다.
	public void close() {
		try {
			FileOutputStream fos = new FileOutputStream("dd.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			System.out.println("파일 저장 성공");
			for (Product p : list) {
				System.out.println(p);
			}
			oos.writeObject(list);
		} catch (FileNotFoundException e) {
			System.out.println("지정한 파일이 없습니다. ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void send() {
		// TODO Auto-generated method stub
		ProductSend ps = new ProductSend();
		ps.start();
	}

//	public void sort() {
//		// TODO Auto-generated method stub
//		Collections.sort(list, new Comparator<Product>() {
//			public int compare(Product o1, Product o2) {
//				return o2.getClass().getName().compareTo(o1.getClass().getName());
//			}
//		});
//	}

	public void save() {
		// TODO Auto-generated method stub
		ProductSave ps = new ProductSave();
		ps.start();
	}

}
