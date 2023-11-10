package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution13_teacher {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/Solution13빌딩.txt"));
		Scanner sc = new Scanner(System.in);
		int[] di = {-1, -1, 0, 1 ,1 ,1, 0, -1};
		int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
		
		int T = sc.nextInt();
		for(int tc=1;tc <= T;tc++) {
			int N = sc.nextInt();
			char[][] arr = new char[N][N];
			arr =  new char[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.next().charAt(0);
				}
			}
			int max = Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				//goto문 같은 것이다
				label:for(int j=0;j<N;j++) {
					int cnt = 0;
					if(arr[i][j] =='B') {
						for(int d=0;d<di.length;d++) {
							int ni = i+di[d];
							int nj = j+dj[d];
							if(0 <= ni && ni<N &&0<=nj  && nj<N) {
								if(arr[ni][nj] == 'G') {
									if(max < 2) max=2;
									continue label;
								}				
							}			
					}
					for(int k=0;k<N;k++) {
						if(arr[i][k] == 'B') cnt++;
						if(arr[k][j] == 'B') cnt++;
						
					}
					cnt--;
					}
				if(max<cnt) max=cnt;
			}

		}
		System.out.println(max);
		}
	
}}
