package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution42미로도착지점_서울8반_윤규희 {
	static int[] dy = {0,0,1,0,-1};
	static int[] dx = {0,1,0,-1,0};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/Solution42미로도착지점.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<T;tc++) {
			int N = sc.nextInt();
			int Y = sc.nextInt()-1;
			int X = sc.nextInt()-1;
			int jumper = sc.nextInt();
			
			int fy = 0;
			int fx = 0;
			int[][] arr = new int[N][N];
			for(int j=0;j<jumper;j++) {
				int jy = sc.nextInt()-1;
				int jx = sc.nextInt()-1;
				arr[jy][jx] = -1;
			}
			
			int move_cnt = sc.nextInt();
			int cy = 0;
			int cx = 0;
			int alive = 0;
			for(int i=0;i<move_cnt;i++) {
				int dir = sc.nextInt();
				int num = sc.nextInt();
				cy += Y + dy[dir]*num;
				cx += X + dy[dir]*num;
				if(cy < 0 && cy >= N && cx < 0 && cx >= N && arr[cy][cx] == -1) 
					break;
				
			}
			
			
			
			
		}

	}

}
