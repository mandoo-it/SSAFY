package retry;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_로봇이동거리_retry {
	static int count = 0;
	static int n;
	static char[][] arr;
	static void right(int i, int j) {
		for(int k=j+1;k<n;k++){
			if(arr[i][k] == 'S')
				count++;
			else 
				break;
		}
	}
	static void left(int i,int j) {
		for(int k=j-1;k>=0;k--){
			if(arr[i][k] == 'S')
				count++;
			else 
				break;
		}
	}
	static void updown(int i, int j) {
		for(int k=i-1;k>=0;k--){
			if(arr[k][j] == 'S')
				count++;
			else 
				break;
		}
		for(int k=i+1;k<n;k++){
			if(arr[k][j] == 'S')
				count++;
			else 
				break;
		}
	}
	
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/Solution11로봇이동거리.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			count = 0;
			arr = new char[n][n];
			for(int i=0;i<n;i++) {
				arr[i] = br.readLine().replace(" ", "").toCharArray();
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
						if(arr[i][j] == 'A') right(i,j);
						else if(arr[i][j] == 'B') {left(i,j);right(i,j);}
						else if(arr[i][j] == 'C') {right(i,j);left(i,j);updown(i,j);}	
						}
					}
			System.out.println("#" + tc + " " + count);
			
		}
		
	}
}

