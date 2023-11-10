package com.ssafy.algo;

import java.util.Scanner;

public class Solution_d3_2817_부분수열의합_서울8반_윤규희 {
	public static int[] data;
	public static int[] bit = new int[4];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2^4
		/*
		 0 0000
		 1 0001
		 2 0010
		 3 0011
		 4 0100
		 5 0101
		 6 0110
		 7 0111
		 8 1000
		 9 1001
		10 1010
		11 1011
		12 1100
		13 1101
		14 1110
		15 1111
		 * */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int cnt = 0;
			data = new int[N];
			int hap = sc.nextInt();
			for(int i=0;i<N;i++) 
				data[i] = sc.nextInt();
			loop:for(int i=0; i<(1<<data.length);i++) {
				int sum = 0;
				for(int j=0;j<data.length;j++) 
				{
					if((i & (1<<j))>0) {
						sum = sum + data[j];
						if(sum>hap) continue loop;
					}
				}
				if(sum == hap) {
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	

	}

}
