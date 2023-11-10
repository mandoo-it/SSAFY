package com.ssafy.java;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {
	static int[] list;
	static int size;
	static void input() {
		Scanner sc = new Scanner(System.in);
		list = new int[size];
		for(int i=0;i<list.length;i++)
			list[i] = sc.nextInt();
	}
	static void print() {
		for(int i=0;i<list.length;i++)
			System.out.println(list[i]);
	}
	static void total() {
		int sum = 0;
		for(int i=0;i<list.length;i++)
			sum += list[i];
		System.out.println("배열의 합:" + sum);
	}
	static void average() {
		int sum = 0;
		for(int i=0;i<list.length;i++)
			sum += list[i];
		System.out.println("배열의 평균:" + sum / list.length);
	}
    static void minimum() {
			System.out.println("최솟값: " + list[0]);
	}
    static void selectionSort() {
		for(int i=0;i<list.length-1;i++) {
			for(int j=i+1;j<list.length;j++) {
				if(list[i] > list[j]) {
					int temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		input();
		print();
		total();
		average();
		selectionSort();
		minimum();			
	}

}
