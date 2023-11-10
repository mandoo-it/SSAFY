package retry;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소금쟁이합계 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			int salt = Integer.parseInt(st.nextToken());
			int alive = 0;
			for(int s=0;s<salt;s++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int jump = 3;
				if(arr[y][x] == 1)
					break;
				if(d == 1) { //상
					int ny = y;
					for(int i=0;i<3;i++) {
						ny = ny - jump;
						if(ny >= 0) {
							if(arr[ny][x] == 1)
								break;
							else {
								jump--;
							}
						}
					}
					if(jump == 0) {
						alive++;
						arr[ny][x] = 1;
					}
						
				} else if(d == 2) { //하
					int ny = y;
					for(int i=0;i<3;i++) {
						ny = ny + jump;
						if(ny < n) {
							if(arr[ny][x] == 1)
								break;
							else {
								jump--;
							}	
						}
					}
					if(jump == 0) {
						alive++;
						arr[ny][x] = 1;
					}
						
				} else if(d == 3) { //좌
					int nx = x;
					for(int i=0;i<3;i++) {
						nx = nx - jump;
						if(nx >= 0) {
							if(arr[y][nx] == 1)
								break;
							else {
								jump--;
							}
						}
					}
					if(jump == 0) {
						alive++;
						arr[y][nx] = 1;
					}
						
				} else { //우
					int nx = x;
					for(int i=0;i<3;i++) {
						nx = nx + jump;
						if(nx < n) {
							if(arr[y][nx] == 1)
								break;
							else {
								jump--;
							}
						}
					}
					if(jump == 0) {
						alive++;
						arr[y][nx] = 1;
					}
				}
				
			}
			System.out.println(alive);
		}

	}

}
