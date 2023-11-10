package stack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 거듭제곱3 {
	public static int[] memo;
	public static int mul(int a, int b) {
		for(int i=2;i<=b;i++) {
			memo[i] = memo[i-1] * a;
			
		}
		return memo[b];
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		for(int tc =1 ;tc<=10;tc++) {
			int t = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			memo = new int[20];
			memo[0] = 0;
			memo[1] = a;
			System.out.println("#" + tc + " " + mul(a, b));
		}
	}

}
