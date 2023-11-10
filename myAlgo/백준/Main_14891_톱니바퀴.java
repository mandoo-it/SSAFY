package 푸는중;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
	static void rotate(int[][] topni, int num, int dir) {
	//	System.out.println(num + " "+ dir);
		if(dir == -1) {//반시계 
			int temp = topni[num][0];
			for(int i=0;i<7;i++) {
				topni[num][i] = topni[num][i+1];
			}
			topni[num][7] = temp;
		} else {
			int temp = topni[num][7];
			
			for(int i=7;i>0;i--) {
				topni[num][i] = topni[num][i-1];
			}
			topni[num][0] = temp;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] topni = new int[5][8];
		
		for(int i=1;i<=4;i++) {
			String s = br.readLine();
			for(int j=0;j<8;j++) {
				topni[i][j] = s.charAt(j) - '0';
			}
		}
		
		int cycle = Integer.parseInt(br.readLine());
		
		for(int i=0;i<cycle;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			int leftidx = topni[num][6];
			int rightidx = topni[num][2];
			int value1 = topni[num][6];
			int value2 = topni[num][2];
			int d = dir;
			
			rotate(topni, num, dir);
			
			//해당 톱니 기준 왼쪽 
			for(int left=num-1;left>0;left--) {
				int c_leftidx = topni[left][6];
				int c_rightidx = topni[left][2];
				
				if(leftidx != c_rightidx) {
					 leftidx = c_leftidx;
					 rightidx = c_rightidx;
					 d = d * (-1);
					 rotate(topni, left, d);
				} else break;
			}
		
			rightidx = value2;
			leftidx = value1;
			int d2 = dir;
			
			for(int right=num+1;right<5;right++) {
				//System.out.println("here");
				int c_leftidx = topni[right][6];
				int c_rightidx = topni[right][2];
				
				if(rightidx != c_leftidx) {
					 leftidx = c_leftidx;
					 rightidx = c_rightidx;
					 d2 = d2 * (-1);
					 rotate(topni, right, d2);
				} else break;
				
			}
			
//			for(int K=1;K<=4;K++) {
//				for(int j=0;j<8;j++) {
//					System.out.print(topni[K][j]);
//				}
//				System.out.println();
//		}
			
		}
//		for(int i=1;i<=4;i++) {
//			for(int j=0;j<8;j++) {
//				System.out.print(topni[i][j]);
//			}
//			System.out.println();
//		}
		int sum = 0;
		for(int i=0;i<4;i++) {
			if(topni[i+1][0] == 1) {
				sum += Math.pow(2, i);
			}
			
		}
		System.out.println(sum);

	}

}
