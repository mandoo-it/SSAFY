package retry;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소금쟁이중첩 {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int salt = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			int count = 0;
			for(int s=1;s<=salt;s++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
			
				
				if(arr[n1][n2] == 1) {
					System.out.println(s);
					count++;
				}
					
				if(d == 1) {
					int jump = 3;
					int ny = n1;
					for(int i=0;i<3;i++) {
						ny = ny+jump;
						if(ny < n ) {
							if(arr[ny][n2] == 1) {
								System.out.println(s);
								count++;
								break;
							}
							else arr[ny][n2] = 1;
							jump--;
						}
						
					}
				} else {
					int jump = 3;
					int nx = n2;
					for(int i=0;i<3;i++) {
						nx = nx + jump;
						if(nx < n) {
							if(arr[n1][nx] == 1) {
								System.out.println(s);
								count++;
								break;
							}
							else arr[n1][nx] = 1;
							jump--;
						}
						
					}
				}
			}
			if(count == 0)
				System.out.println(0);
		}
		
	}

}
