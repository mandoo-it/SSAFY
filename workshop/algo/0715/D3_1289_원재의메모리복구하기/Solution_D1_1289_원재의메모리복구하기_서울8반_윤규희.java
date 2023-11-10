package array1;
import java.util.Scanner;

public class Solution_D1_1289_원재의메모리복구하기_서울8반_윤규희 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		String[] tr_arr = new String[tc];
		int[] cnt_arr = new int[tc];
	
		
		for(int i = 0; i < tr_arr.length; i++)
		{
			tr_arr[i] = sc.next();
			cnt_arr[i] = 0;
			
		}
		
		for(int i = 0;i < tr_arr.length;i++) {
			char comp = '0';
			for(int j = 0;j < tr_arr[i].length(); j++) {
				if(tr_arr[i].charAt(j) != comp) {
					cnt_arr[i]++;
				}
				comp = tr_arr[i].charAt(j);
			}
			System.out.println("#" + (i+1) + " " + cnt_arr[i]);
		}
		sc.close();
	}
}
