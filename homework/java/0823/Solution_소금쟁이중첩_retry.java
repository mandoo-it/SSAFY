package retry;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_소금쟁이중첩_retry {
	static int[] diri = {0,1,0};
	static int[] dirj = {0,0,1};
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int salt = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			int count = 0;
			System.out.print("#" + tc + " ");
			
			for(int i=0;i<salt;i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());//column
				int x = Integer.parseInt(st.nextToken());//row
				int d = Integer.parseInt(st.nextToken());
				
				if(arr[y][x] == 1) {
					count++;
					System.out.println(i);
					break;
				}
				int ni = y;
				int nj = x;
				int jump = 3;
				for(int j=0;j<3;j++) {
					ni = ni + diri[d]*jump;
					nj = nj + dirj[d]*jump;
					if(ni >= 0 && ni < n && nj >= 0 && nj < n )
					{
						if(arr[ni][nj] == 1) {
							count++;
							System.out.println(i+1);
							break;
						} else 
							arr[ni][nj] = 1;
							jump--;
						}
					
				}	
			}
			if(count == 0)
				System.out.println(0);
		}
	}

}
