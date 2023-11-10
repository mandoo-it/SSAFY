package array1;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
public class Solution_D3_Flatten_서울8반_윤규희 {

	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_d1_2046.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		for(int t=0; t< 10; t++) {
			int dump = sc.nextInt();
			int gap = 0;
			int[] arr = new int[100];
			for(int i=0;i<100;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			for(int k=0;k<dump;k++) {
				if(arr[99] - arr[0] >= 2) {
					arr[0] = arr[0] + 1;
					arr[99] = arr[99] - 1;
					Arrays.sort(arr);
				}			
			}
			System.out.println("#" + (t+1) + " " + (arr[99] - arr[0]));
			
		}
	}
}

