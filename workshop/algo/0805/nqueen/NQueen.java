package stack2;

import java.util.Scanner;

public class NQueen {
	public static int N;
	public static int[] col;
	public static int result ;
	
	public static boolean promising(int i) {
		for(int j=0;j<i;j++) {
			if(col[j] == col[i] || Math.abs(col[i] - col[j]) == (i-j))
				return false;
		}
		return true;
	}
	public static void nqueen(int i, String s) {
		if(i == N) {
			System.out.println(s);
			result += 1;
			return;
		}else {
			for(int j=0;j<N;j++) {
				col[i] = j;
				if(promising(i)) nqueen(i+1,s+i+","+col[i]+","+col[j]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=0;tc<t;tc++) {
			result = 0;
			N = sc.nextInt();
			col = new int[N];
			nqueen(0,"");
			System.out.println("#" + (tc+1) + " " + result);
		}
	
	}

}
