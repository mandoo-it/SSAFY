package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D2_1959_두개의숫자열_서울8반_윤규희 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] N_arr = new int[N];
			int[] M_arr = new int[M];
			
			for(int i=0;i<N;i++)
				N_arr[i] = sc.nextInt();
			for(int i=0;i<M;i++)
				M_arr[i] = sc.nextInt();
				
			int max = 0;

			if(N > M) {
				for(int i=0;i<=N-M;i++) {
					int sum = 0;
					for(int j=0;j<M;j++) {
						sum += M_arr[j] * N_arr[j+i];
					}
					if(sum > max)
						max = sum;
				}
			}
			else 
			{
				for(int i=0;i<=M-N;i++) {
					int sum = 0;
					for(int j=0;j<N;j++) {
						sum += N_arr[j] * M_arr[j+i];
					}
					if(sum > max)
						max = sum;
				}
			}
			
			
				
				
			
			System.out.println("#" + tc + " "+ max);
		}

	}

}
