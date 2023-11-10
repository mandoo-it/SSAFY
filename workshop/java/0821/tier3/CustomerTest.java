package com.tier3;

import java.util.ArrayList;

//dao를 이용하는 객체인 client program
public class CustomerTest {
	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAO();
		ArrayList<Customer> list =  dao.selectAll();
		for(Customer c : list) {
			System.out.println(c);
		}
		System.out.println(dao.selectOne(121).getName());
		//System.out.println(dao.insert(new Customer("1000","hello","3")));
		//System.out.println(dao.delete("1000"));
		System.out.println(dao.update("1000", "역삼구"));
		ArrayList<Customer> list2 =  dao.findByAddress("seoul");
		for(Customer c : list2) {
			System.out.println(c);
		}
	}
}
