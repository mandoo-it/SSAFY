package dp;

import java.util.Arrays;

public class DpEx2 {
	public static void main(String[] args) {
		int N=6;
		int[] DP=new int[N+1];
		DP[0]=1;
		DP[1]=2;
		for(int i=2;i<=N;i++) {
			DP[i]=2*DP[i-1]+DP[i-2];
		}
		System.out.println(DP[N]);
		System.out.println("DP"+Arrays.toString(DP));
	}
}
