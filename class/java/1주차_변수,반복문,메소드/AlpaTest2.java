package com.ssafy.java;

public class AlpaTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'A';
		for(int i=1;i<=5;i++) {
			for(int k=0;k<=5-i;k++) {
				System.out.print(" ");
			}
			for(int k=0;k<i;k++)
				System.out.print(c++);
		System.out.println();	
		}
	}

}
