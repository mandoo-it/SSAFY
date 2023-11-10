package 조합_순열_부분집합;

import java.util.Arrays;

// 중복순열
public class Product {

	public static int n, r, cnt, num[];
	public static int[] ar = {2, 3, 4, 5};
	
	public static void product(int count) {
		if(count == r) {
			// 중복 확인 x
//			for(int i = 0; i < r; i++) {
//				for(int j = i+1; j < r; j++) {
//					if(num[i] == num[j]) return;
//				}
//			}
			
			cnt++;
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i = 0; i < n; i++) {
			num[count] = ar[i];
			
			product(count+1);
		}
	}
	
	
	public static void main(String[] args) {
		n = ar.length;
		r = 3;
		num = new int[3];
		
		product(0);
		
		System.out.println(cnt);
	}
}
