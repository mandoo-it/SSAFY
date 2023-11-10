import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_2805_농작물수확하기_서울8반_윤규희 {
	public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
  
        for (int tc = 0; tc < T; tc++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }
  
            for (int i = 0; i <= n / 2; i++) {
                for (int j = (n / 2) - i; j <= (n / 2) + i; j++) {
                    count += arr[i][j];
                }
  
            }
  
           for(int i=1;i<=n/2;i++) {
               for(int j=i;j<n-i;j++)
                   count += arr[n/2 + i][j];
           }
  
            System.out.println("#" + (tc + 1) + " " + count);
        }
    }

}
