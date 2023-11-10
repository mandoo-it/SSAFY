package retry;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_소금쟁이합계_retry {
	static int[] diry = {0, -1, 1, 0 , 0};
	static int[] dirx = {0, 0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_소합.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int salt = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			int alive = 0;
			for(int i=0;i<salt;i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int jump = 3;
				
				if(arr[y][x] == 1)
					break;
				int ny = y;
				int nx = x;
	
				for(int j=0;j<3;j++) {
					ny += diry[d]*jump;
					nx += dirx[d]*jump;
					if(ny >= 0 && ny < n && nx >= 0 && nx < n) {
						if(arr[ny][nx] == 1) {
							break;}
						else jump--;
					}	
				}
				if(jump == 0) {
					alive++;
					arr[ny][nx] = 1;
				}
					
			}
			System.out.println("#" + tc + " " + alive);
			
			
		}
		
	}

}
