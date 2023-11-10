package array2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution부분순열 {

	public static int n,r,caseCount,data[];
	public static void product(int count) {
		if(count == r) {
			for(int i=0;i<r;i++) {
				for(int j=i+1;j<r;j++) {
					if(data[i] == data[j]) return;
				}
			}
			caseCount++;
			System.out.println(Arrays.toString(data));
			return;
		}
		else {
			for(int i=1;i<=n;i++) {
				data[count] = i;
				product(count+1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		r = sc.nextInt();
		n = 6;
		r = 3;
		data = new int[r];
		product(0);
		System.out.println(caseCount);
		sc.close();

	}
}
