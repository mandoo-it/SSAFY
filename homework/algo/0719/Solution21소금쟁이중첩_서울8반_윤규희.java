package com.ssafy.algo;
import java.io.FileInputStream;
import java.util.*;

public class Solution21소금쟁이중첩_서울8반_윤규희 {
	static int[] dx = {0, 1, 0};
	static int[] dy = {0 ,0, 1};
	
 	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/Solution21소금쟁이중첩.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc <= T;tc++) {
			int N = sc.nextInt();
			int salt = sc.nextInt();	
			int[][] lake = new int[N][N];
			int isOverlap = 0;
			
			for(int i=0;i<salt;i++) {
				int salt_x = sc.nextInt();
				int salt_y = sc.nextInt();
				int dir = sc.nextInt();
				int jump = 3;
				
				if(lake[salt_x][salt_y] == 1) {
					System.out.println("#" + tc + " " + (i + 1) );
					break;
				}
				int nx = salt_x;
				int ny = salt_y;
				
				for(int j=0;j<3;j++) {
					nx += jump * dx[dir];
					ny += jump * dy[dir];
					if(nx >= 0 && nx<N && ny >=0 && ny <N)
					{ 
						if(lake[nx][ny] != 1) {
							lake[nx][ny] = 1;
							jump--;
						}
						else {
							System.out.println("#" + tc + " " +(i+1));
							isOverlap++;
							break;
						}
					}						
				}				
			}
			if(isOverlap == 0) {
				System.out.println("#" + tc + " " + 0);
				break;
			}
		}
	}
}
