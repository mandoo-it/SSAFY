package com.ssafy;

import java.util.Arrays;

public class CarTest {
	public static void main(String[] args) {
		CarMgr mgr = CarMgr.getInstance();
		
		mgr.add(new Car("111", "그랜져",3000)); 
		mgr.add(new Car("222", "소나타",2000)); 
		mgr.add(new Car("333", "아반테",1000)); 
		mgr.add(new Truck("444", "용역트락",1000, 20.3)); 
		mgr.add(new Bus("555", "서울시내버스",2000,50)); 
		
		System.out.println("-----------전체 차량 검색결과-------------");
		for(Car c : mgr.search()) {
			System.out.println(c); //c만 불러도 tostring이 불린다
		}
		System.out.println();
		
		System.out.println("-----------차량 변호로 검색결과-------------");
		System.out.println(mgr.search("222"));
		System.out.println();
		
		System.out.println("-----------지정 가격보다 작은 차량 검색-------------");
		for(Car c : mgr.search(3000)) {
			System.out.println(c); //c만 불러도 tostring이 불린다
		}
		System.out.println();
		
		System.out.println("-----------특정 챠량 가격 정보 수정-------------");
		mgr.update("333" , 1111);
		for(Car c : mgr.search(3000)) {
			System.out.println(c); //c만 불러도 tostring이 불린다
		}
		System.out.println();
		
		mgr.delete("222");
		System.out.println("-----------특정 챠량 삭제 후-------------");
		for(Car c : mgr.search()) {
			System.out.println(c); //c만 불러도 tostring이 불린다
		}
		System.out.println();
		
		System.out.println("------------등록 차량수---------------");
		System.out.println(mgr.size());
		System.out.println("-----------등록되 차량의 가격의 총합-------------");
		System.out.println(mgr.totalPrice());
	}
}
