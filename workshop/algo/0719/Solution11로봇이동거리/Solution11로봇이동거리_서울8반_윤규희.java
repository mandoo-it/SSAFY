package com.ssafy.algo;
import java.io.FileInputStream;
import java.util.*;

public class Solution11로봇이동거리_서울8반_윤규희 {
	// TODO Auto-generated method stub
	
	static int T, N;
	static int Answer;
	static char[][] map;
    static int count = 0;
    
	public static void right(int x, int y) {
		for(int i = y+1; i< map.length; i++) {
			if(map[x][i] == 'S') {
				count++;
			}
				
			else
				break;
		}
	}
	
	public static void left(int x, int y) {
		for(int i = y -1;i>=0; i--) {
			if(map[x][i] == 'S')
				count++;
			else
				break;
		}
	}
	public static void updown(int x, int y) {
		for(int i = x+1; i< map.length; i++) {
			if(map[i][y] == 'S') {
				count++;
			}
				
			else
				break;
		}
		for(int i = y -1;i>=0; i--) {
			if(map[i][x] == 'S')
				count++;
			else
				break;
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution11로봇이동거리.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)	{
			N = sc.nextInt();
			count = 0;
			map=new char[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {					
					map[i][j] = sc.next().charAt(0);				
				}
			}

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] == 'A') {
						right(i, j);
					}
					else if(map[i][j] == 'B') {
						right(i,j);
						left(i,j);
					}
					else if(map[i][j] == 'C') {
						right(i,j);
						left(i,j);
						updown(i,j);
					}
				}
			}
			
			System.out.println("#" +test_case +" " + count);

			
		}
	}

}
