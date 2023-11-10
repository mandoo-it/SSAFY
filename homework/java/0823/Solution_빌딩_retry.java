package retry;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_빌딩_retry {
	static int[] diry = {-1,-1,-1,0,0,1,1,1,};
	static int[] dirx = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/Solution13빌딩.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			int max = 2;
			char[][] arr = new char[n][n];
			for(int i=0;i<n;i++) {
				arr[i] = br.readLine().replace(" ","").toCharArray();
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j] == 'B') {
						int count = 0;
						for(int d=0;d<diry.length;d++) {
							int ny = i + diry[d];
							int nx = j + dirx[d];
							if(ny >= 0 && ny < n && nx >= 0 && nx < n) {
								if(arr[ny][nx] == 'G') {
									count = 2;
									break;
								}
							}
						}
						if(count == 0) {
							for(int k=0;k<n;k++) {
								if(arr[i][k] == 'B')
									count++;
								if(arr[k][j] == 'B')
									count++;
							}
						}
						if(count > max)
							max = count;
					}
					
				}
			}
			System.out.println(max-1);
			
		}
	}

}
