package stack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 거듭제곱 {
	public static int mul(int a, int b) {
		if(b < 2) return a;
		else return mul(a,b-1) * a;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		for(int tc =1 ;tc<=10;tc++) {
			int t = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println("#" + tc + " " + mul(a, b));
		}
	}

}
