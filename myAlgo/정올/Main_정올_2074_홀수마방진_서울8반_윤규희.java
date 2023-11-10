package 푸는중;

import java.util.Scanner;

public class Main_정올_2074_홀수마방진_서울8반_윤규희 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] map = new int[n+1][n+1];
		
		int y = 0;
		int x = n / 2;
		
	
		for(int i=1;i<=n*n;i++) {
			map[y][x] = i;
			if(i % n == 0) {
				y++;
			} else {
				x--;y--;
				if(x < 0) {
					x = n-1;
				}
				if(y < 0) {
					y = n-1;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j] +  " ");
			}
			System.out.println();
		}

	}

}
