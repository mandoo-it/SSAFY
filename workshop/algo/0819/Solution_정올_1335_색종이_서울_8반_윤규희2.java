import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_정올_1335_색종이_서울_8반_윤규희2 {
	static int n;
	static int[][] arr;
	static int cnt0;
	static int cnt1;
	
	static void divide(int i, int j, int n) {
		int sum = 0;
		for(int ni=i;ni<n+i;ni++) {
			for(int nj=j;nj<n+j;nj++)
				sum += arr[ni][nj];
		}
		if(sum == 0) cnt0++;
		else if(sum == n*n) cnt1++;
		else {
			divide(i, j, n/2);
			divide(i, j+n/2, n/2);
			divide(i+n/2, j, n/2);
			divide(i+n/2, j+n/2, n/2);
		}
		
	}
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				arr[i][j] = sc.nextInt();
		}
		
		divide(0, 0, n);
		System.out.println(cnt0);
		System.out.println(cnt1);
		
	}

}
