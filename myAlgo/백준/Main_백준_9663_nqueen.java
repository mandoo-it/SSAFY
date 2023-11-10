package 푸는중;

import java.util.Scanner;

public class Main_백준_9663_nqueen {
	static int N;
	static int[] col; 
	static int result = 0;
	
	static boolean validate(int i) {
		for(int j=0;j<i;j++) {
			if(col[j] == col[i] || Math.abs(col[i] - col[j]) == i-j)
				return false;
		}
		return true;
	}
	static void dfs(int count) {
		if(count == N) {
			result+=1;
			return;
		}
	
		for(int i=0;i<N;i++) {
			col[count] = i;
			if(validate(count)) {
				dfs(count+1);
			}
		}	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N];
		
		dfs(0);
		System.out.println(result);
	}

}
