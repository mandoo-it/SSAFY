package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution22소금쟁이합계_서울8반_윤규희 {
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0 , 0 ,-1, 1};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/Solution22소금쟁이합계.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc <= T;tc++) {
			int N = sc.nextInt();
			int salt = sc.nextInt();	
			int[][] lake = new int[N][N];
			int alive = 0;
			
			for(int i=0;i<salt;i++) {
				int salt_x = sc.nextInt();
				int salt_y = sc.nextInt();
				int direct = sc.nextInt();
				int success = 0;
				int nx = salt_x;
				int ny = salt_y;
				int jump = 3;
				
				if(lake[salt_x][salt_y] == 1)
					break;
				for(int j=0;j<3;j++) {
					nx += jump * dx[direct];
					ny += jump * dy[direct];
					if(nx >=0 && nx < N && ny >= 0 && ny < N && lake[nx][ny] != 1) {
						jump--;
						success++;
					}
					else {
						jump--;
						break;
					}					
				}
				if(success == 3) {
					lake[nx][ny] = 1;
					alive++;
				}
			}
			System.out.println("# " + tc + "  " + alive);
			
			
	}

}
	}
