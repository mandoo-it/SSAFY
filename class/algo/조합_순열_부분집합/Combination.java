package 조합_순열_부분집합;

import java.util.Arrays;


// 조합
public class Combination {
	public static int n, r, cnt, num[];
	public static int[] ar = {3, 4, 5, 6, 7};
	
	public static void combination(int before, int count) {
		if(count == r) {
			for(int i = 0; i < r; i++) {
				for(int j = i+1; j < r; j++) {
					if(num[i] == num[j]) return; //중복 제거하는 부분
				}
			}
			
			cnt++;//중복 제거하는 부분에서 살아남은 애들 
			System.out.println(Arrays.toString(num));
			return;
		}
		
		for(int i = before; i < n; i++) { //모든 경우의 수 뽑는 경우
			num[count] = ar[i];
			System.out.println(before + "a" + Arrays.toString(num) + count);
			combination(i, count+1);
		}
	}

	public static void main(String[] args) {
		n = ar.length;
		r = 3;
		num = new int[r];
		
		combination(0, 0);
		System.out.println(cnt);
	}
}
