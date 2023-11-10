package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution32점프사방_서울8반_윤규희 {
	static int[] dy = {0,0,1,0,-1};
	static int[] dx = {0,1,0,-1,0};
 	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/Solution32점프사방.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1;tc <= T;tc++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int m = sc.nextInt();
			int reward = m * (-1000);
			
			int[][] arr = new int[y][x];
			int[][] member= new int[m][3];
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[i].length;j++)
					arr[i][j] = sc.nextInt();
			}
			//index 관련된 것들은 -1해준다. 문제에서 제시한 게 1부터 시작하지만 실제 배열은 0부터니
			for(int i=0;i<m;i++) {
				member[i][0] = sc.nextInt()-1;
				member[i][1] = sc.nextInt()-1;
				member[i][2] = sc.nextInt();
			}
			
			int trap_ct = sc.nextInt();
			
			for(int i=0;i<trap_ct;i++) {
				int ty = sc.nextInt()-1;
				int tx = sc.nextInt()-1;
				arr[ty][tx] = -1;
			}
			for(int i=0;i<m;i++) {
				int my = member[i][0];
				int mx = member[i][1];

				if(arr[my][mx] == -1) 
					break;
				int value;
				for(int j=0;j<member[i][2];j++) {
					value = arr[my][mx];
					my += dy[value/10] * (value % 10);
					mx += dx[value/10] * (value % 10);
					if(my >= 0 && my < y && mx >=0 && mx < x) {
						//갈곳이 함정이아니 마지막 점프일 때의 위치의 value값이 중요하니까 j값으로 마지막 점프인지 확
						if(arr[my][mx] != -1 && j==(member[i][2] - 1)) {
							value = arr[my][mx];
							reward += value * 100;
						}
					}
					else
						break;
				}
				
			}
			System.out.println("#" + tc + " " +reward);	
		}

	}

}
