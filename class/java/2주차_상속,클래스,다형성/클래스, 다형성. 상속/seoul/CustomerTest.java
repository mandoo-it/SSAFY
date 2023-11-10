package com.seoul;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer tom = new Customer();
		//num이 private라 집적 접근은 못한다.
		tom.setNum(19);
		tom.getNum();
	}

}
