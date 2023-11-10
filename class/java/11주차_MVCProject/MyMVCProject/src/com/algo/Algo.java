package com.algo;

public class Algo {
	int num1, num2;
	
	public Algo(String num1, String num2) {
		this.num1 = Integer.parseInt(num1);
		this.num2 = Integer.parseInt(num2);
	}
	
	public int doJob() {
		//이 안에다 알고리즘 문제 풀 것
		return num1 + num2;
	}
	
	public int doJob2() {
		//이 안에다 알고리즘 문제 풀 것
		return num1 * num2;
	}

}
