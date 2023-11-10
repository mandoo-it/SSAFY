package dp;

import java.util.Arrays;

public class CoinDP1 {
	public static int[] coin= {1,4,6};
	public static int[] dp;
	
	public static void main(String[] args) {
		int N=8;
		dp=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			int min=Integer.MAX_VALUE/2;
			for(int j=0;j<coin.length;j++) {
				if(i-coin[j]>=0) {
					if(min>dp[i-coin[j]]) min=dp[i-coin[j]];
				}
			}
			dp[i]=min+1;
		}
		System.out.println(dp[N]);
		System.out.println(Arrays.toString(dp));
	}
}
