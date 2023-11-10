package array1;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D2_1204_최빈수구하기_서울8반_윤규희
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i=1;i<=tc;i++) {
			int[] cnt_arr = new int[101];
			for(int j=0;j<1000;j++) {
				int tc2 = sc.nextInt();
				cnt_arr[tc2]++;
			}
			int index = 0;
			int max = cnt_arr[0];
			for(int k=0;k<101;k++) {
				//최빈수가 여러개일때 높은 점수 출력해야해서 =을 쓴다
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