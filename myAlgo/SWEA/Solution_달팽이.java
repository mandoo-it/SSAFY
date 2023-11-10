import java.util.Arrays;
import java.util.Scanner;

public class Solution_달팽이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			
			int num = 1; //증가하는 숫자 
			int r = 0;
			int c = 0;
			int size = n;//한 변으로 전진할 칸의 수
			
			while(size > 0) {
				//우
				for(int i=0;i<size;i++) {
					arr[r][c] = num;
					c++;
					num++;
				}
				r++; //보정
				c--;
				size--;
				
				//하
				for(int i=0;i<size;i++) {
					arr[r][c] = num;
					r++;
					num++;
				}
				r--;
				c--;
				
				//좌
				for(int i=0;i<size;i++) {
					arr[r][c] = num;
					c--;
					num++;
				}
				r--;
				c++;
				size--;
				
				for(int i=0;i<size;i++) {
					arr[r][c] = num;
					r--;
					num++;
				}
				r++;c++;
			}
			
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
					
		}
	}

}
