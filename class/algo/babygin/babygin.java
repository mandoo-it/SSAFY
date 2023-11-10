package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class babygin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String card = sc.next();
		int[] count = {0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<6;i++) {
			//char형 배열의 값이라 아스키코드 숫자 배열의 범위를 넘는거 이해하데 오래걸
			count[Integer.parseInt(card.substring(i,i+1))]++;
		}
		int isBabygin = 0;
		
		for(int i=0;i<count.length;i++) {
			if(count[i] >= 3) {
				isBabygin++;
				if(count[i] >= 6)
					isBabygin++;
				count[i] = 0;
			}
				
			if(count[i] >= 1 && i < 8) {
				if(count[i+1] >0) {
					if(count[i+2] >0) {
						isBabygin++;
						count[i] = 0;
						count[i+1] = 0;
						count[i+2] = 0;
					}
				}
			}
		}
		if(isBabygin >= 2)
			System.out.print("your cards are babygin!!");
		else 
			System.out.print("your cards are not babygin!!");
	}

}
