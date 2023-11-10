

import java.util.Scanner;
public class Main_정올_2000_동전교환_서울8반_윤규희 {
   public static int[] coin;
   public static int[] dp;
   public static int N;
   public static int M;
   public static void main(String[] args) {
       //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       Scanner sc = new Scanner(System.in);
       M = sc.nextInt();
       coin = new int[M];
       for(int i=0; i<M; i++) {
           coin[i]=sc.nextInt();
       }
       N =sc.nextInt();
       dp= new int[N+1];
       for(int i=1; i<=N; i++) {
           int min=Integer.MAX_VALUE/2;
           for(int j=0; j<coin.length; j++) {
               if(i-coin[j] >=0) {
                   if(min > dp[i-coin[j]]) min=dp[i-coin[j]];
               }
           }
           dp[i]=min+1;
       }
       if(dp[N] >= Integer.MAX_VALUE/2) {
           System.out.println("impossible");
           return;
       }
       System.out.println(dp[N]);
   }

 
}

