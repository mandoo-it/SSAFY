package list;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_3499_퍼펙트셔플_서울8반_윤규희 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input33.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0;tc<T;tc++) {
			int ct = sc.nextInt();
			String[] arr = new String[ct];
			for(int i=0;i<ct;i++) {
				arr[i] = sc.next();
			}
			System.out.print("#" + (tc+1) + " ");
			if(ct % 2 == 0) {
				String[] arr1 = new String[ct/2];
				String[] arr2 = new String[ct/2];
			
				for(int i=0;i<ct/2;i++) {
					arr1[i] = arr[i];
					arr2[i] = arr[i + (ct /2)];
				}
				for(int i=0;i<(ct/2);i++) {
					System.out.print(arr1[i]);
					System.out.print(" ");
					System.out.print(arr2[i]);
					System.out.print(" ");
				}
			}
			else {
				String[] arr1 = new String[(ct/2) + 1];
				String[] arr2 = new String[ct/2];
				
				for(int i=0;i<ct/2;i++) {
					arr1[i] = arr[i];
					arr2[i] = arr[i + (ct /2) + 1];
				}
				arr1[(ct/2)] = arr[ct/2];  
				
				for(int i=0;i<(ct/2);i++) {
					System.out.print(arr1[i]);
					System.out.print(" ");
					System.out.print(arr2[i]);
					System.out.print(" ");
				}
				System.out.print(arr1[(ct/2)]);
			}
			
			//System.out.println(Arrays.toString(arr));
			
			System.out.println();
			
			
		}
	}

}
