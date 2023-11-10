package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Soulution13빌딩_서울8반_윤규희 {
	static int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/Solution13빌딩.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc <= T;tc++) {
			int N = sc.nextInt();
			char[][] arr = new char[N][N];

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.next().charAt(0);
				}
			}
			
			int max = 2;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int count = 0;
					if(arr[i][j] == 'B') {
						for(int d=0;d<di.length;d++) {
							int ni = i + di[d];
							int nj = j + dj[d];
							if(ni < N && ni >= 0 && nj < N && nj >= 0)
							{
								if(arr[ni][nj] == 'G')
									count = 2;
							}
						}
						if(count == 0) {
							for(int k=0;k<N;k++) {
								if(arr[i][k] == 'B') 
									count++;
								if(arr[k][j] == 'B') 
									count++;
							}	
						}
					}
					count--; // 자기가 두번 중복되니까 한 번빼
					if(count > max) max = count;
				}
			}
			System.out.println("#" + tc + " "+  max);
		}		
	}
} 
						
					
			
		
	



 