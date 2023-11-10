import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_정올_1335_색종이_서울8반_윤규희 {
	static int n;
	static int[][] arr;
	static int white;
	static int blue;
	
	static void divide(int y, int x, int len) {
		int check = arr[y][x];
		int count = 0;
		
		label : for(int i=y;i<y+len;i++) {
			for(int j=x;j<x+len;j++) {
				if(arr[i][j] != check) {
					count++;
				    break label;
				}
			}
			
		}
		if(count == 0) {
			if(check == 1) blue++;
			else white++;
		} else 
		{
			 divide(y, x, len/2); // 왼쪽 위
			 divide(y+len/2, x, len/2); // 왼쪽 아래
			 divide(y, x+len/2, len/2); // 오른쪽 위
			 divide(y+len/2, x +len/2, len/2); //오른쪽 아래
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
		System.out.println(white);
		System.out.println(blue);
		
	}

}
