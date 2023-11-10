package 다시해봅시다아자화이팅;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 정올_1355_색종이 {
	static int[][] arr;
	static int blue;
	static int white;
	
	static void divide(int sy, int sx, int len) {
		int start = arr[sy][sx];
		Boolean check = false;
		
		label : for(int i=sy;i<sy+len;i++) {
			for(int j=sx;j<sx+len;j++) {
				if(arr[i][j] != start) {
					check = true;
					break label;
				}
			}
		}
		
		if(check) {
			divide(sy, sx, len /2 ); //왼쪽 위
			divide(sy + len/2, sx, len /2 ); //왼쪽 아래
			divide(sy, sx+ len/2, len /2 );//오른쪽 위
			divide(sy+ len/2, sx+ len/2, len /2 ); //오른 쪽 아래
		} else {
			if(start == 1) blue++;
			else white++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,N);
		System.out.println(white);
		System.out.println(blue);
		
	}

	

}
