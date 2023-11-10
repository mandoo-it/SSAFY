package 조합_순열_부분집합;

import java.util.Arrays;

// 전체 부분집합, 중복순열 활용
public class Powerset {

	public static int n, cnt, num[];
	public static int[] ar = {1, 3, 5};
	
	public static void powerset(int count) {
		if(count == n) {
			for(int i = 0; i < n; i++) {
				if(num[i] == 1)
					System.out.print(ar[i] + " ");
			}
			cnt++;
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i = 0; i <= 1; i++) {
			num[count] = i;
			powerset(count+1);
		}
	}
	
	public static void main(String[] args) {
		n = ar.length;
		num = new int[n];
		
		powerset(0);
		System.out.println(cnt);
	}
}
