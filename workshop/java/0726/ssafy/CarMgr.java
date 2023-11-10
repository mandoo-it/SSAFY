package com.ssafy;

import java.util.Arrays;

public class CarMgr {
	private Car[] cars = new Car[100];
	private int index;
	
	 //싱글톤 방법 1 - carMgr을 자주 사용 할때 (미리 먼저 PRE-PATCH객체를 만들어)해 놓는다. 
	 //1. singleton - private 생성자
		private CarMgr() {
			
		}
		//2.singleton - 3의 static 메소드 안에는 static 변수밖에 쓰지 못한다. 
		private static CarMgr instance = new CarMgr();
		
		//3.singleton 
		public static CarMgr getInstance() {
			return instance;
		}
	
	// 싱글톤 방법 2 - 필욜할 때 객체 생성
	//1. singleton - private 생성자
	//		private CarMgr() {
	//			
	//		}
	//		//2.singleton - 3의 static 메소드 안에는 static 변수밖에 쓰지 못한다. 
	//		private static CarMgr instance;
	//		
	//		//3.singleton 
	//		public static CarMgr getInstance() {
	//			if(instance == null) instance = new CarMgr(); //객체를 안 쓸 때 안 쓰려고 필요할 때만 만듬 
	//			return instance;
	//		}
		
	public void add(Car car) {
		Car c = search(car.getNum());
		if(c == null) cars[index++] = car;
	}
	
	//crud중 search를 먼저 해야한다. 중복 체크를 해야하기 때문에 
	public Car[] search() {
		return Arrays.copyOf(cars, index);	
	}
	
	//오버로딩
	public Car search(String num) {
		for(int i=0;i<index;i++) {
			Car c = cars[i];
			String nm = c.getNum();
			if(nm.equals(num)) return c;
		}
		return null;
	}
	
	public Car[] search(int price) {
		int cnt = 0;
		for(int i=0;i<index;i++) {
			Car c = cars[i];
			if(c.getPrice() < price)
				cnt++;
		}
		
		Car[] temp = new Car[cnt];
		cnt = 0;
		for(int i=0;i<index;i++) {
			Car c = cars[i];
			int pr = c.getPrice();
			if(pr < price) {
				temp[cnt++] = c;
			}	
		}
		return temp;
	}
	public void update(String num, int price) {
		Car c = search(num);
		if(c != null) c.setPrice(price);
		
		
	}
	public void delete(String num) {
		for(int i=0;i<index;i++) {
			Car ca= cars[i];
			String nm = ca.getNum();
			if(nm.equals(num)) {
	// 					1. 1개씩 앞으로 댕기기
	//					for(int j=i;j<index-1;j++) {
	//						cars[j] = cars[j+1];
	//					}
	//					cars[--index] = null;
				
	//					2. 맨 뒤에거를 삭제한 인덱스의 위치에 넣어주기
				index--;
				cars[i] = cars[index];
				cars[index] = null;
				//멀티개 삭제 될 경우 i--
				//return; 1개 삭제 될 경우
 			}
		}
	}

	
	public int size() {
		return index;
		
	}
	public int totalPrice() {
		int total = 0;
		for(int i=0;i<index;i++) {
			Car c = cars[i];
			total += c.getPrice();
		}
		return total;
	}
		

}
