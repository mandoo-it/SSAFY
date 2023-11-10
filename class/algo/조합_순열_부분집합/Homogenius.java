package 조합_순열_부분집합;

import java.util.Arrays;

// 중복조합
public class Homogenius {
	public static int n, r, cnt, num[];
	public static int[] ar = {1, 3, 5, 7, 9};
	
	public static void homogenius(int before, int count) {
		if(count == r) {
			// 중복체크 안함
//			for(int i = 0; i < r; i++) {
//				for(int j = i+1; j < r; j++) {
//					if(num[i] == num[j]) return;
//				}
//			}
			
			cnt++;
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i = before; i < n; i++) {
			num[count] = ar[i];
			homogenius(i, count+1);
		}
	}
	
	public static void main(String[] args) {
		n = ar.length;
		r = 3;
		num = new int[r];
		
		homogenius(0, 0);
		System.out.println(cnt);
	}
}
