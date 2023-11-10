package array2;

import java.util.Arrays;
import java.util.Scanner;

//중복순열 nPir=n^r
public class Product {
	public static int n,r,caseCount,data[];
	public static void product(int start, int flag, int count) {
		if(count == r) {
			caseCount++;
			System.out.println(Arrays.toString(data));
			return;
		}
		else {
			for(int i=1;i<=n;i++) {
				
				if((flag&1<<i) == 0) {
					data[count] = i;
					product(i+1,flag|1<<i, count+1);
				}
			
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		r = sc.nextInt();
		n = 3;
		r = 2;
		data = new int[r];
		product(1, 0, 0);
		//product(0);
		System.out.println(caseCount);
		sc.close();

	}

}
