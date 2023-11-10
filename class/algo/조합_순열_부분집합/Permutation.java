package 조합_순열_부분집합;

import java.util.Arrays;

// 순열: 중복 허용x, 순서o -> 1,2,3 != 3,2,1
public class Permutation {
	
	public static int[] ar = {3, 4, 5, 6};
	public static int[] num;
	public static int n, r, cnt;

	public static void permutation(int count) {
		if(count == r) {
			for(int i = 0; i < r; i++) {
				for(int j = i+1; j < r; j++) {
					if(num[i] == num[j]) return;
				}
			}
			cnt++;
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i = 0; i < n; i++) {
			num[count] = ar[i];
			permutation(count+1);
		}
	}
	
	public static void main(String[] args) {
		n = 3;
		r = 3;
		num = new int[r];
		permutation(0);
		
		System.out.println(cnt);
	}
}
