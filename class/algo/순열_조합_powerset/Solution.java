import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i=1;i<=tc;i++) {
			
			int tsc = sc.nextInt();
			
			int[] cnt_arr = new int[101];
			for(int j=0;j<1000;j++) {
				int tc2 = sc.nextInt();
				cnt_arr[tc2]++;
			}
			int index = 0;
			int max = cnt_arr[0];
			for(int k=0;k<101;k++) {
				if(max <= cnt_arr[k]) {
					max = cnt_arr[k];
					index = k;
				}
					
			}
			System.out.println("#" + i + " " + index);
			
		}
		sc.close();
	}
}