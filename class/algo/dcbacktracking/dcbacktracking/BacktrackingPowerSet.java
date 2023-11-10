package dcbacktracking;

import java.util.Arrays;

public class BacktrackingPowerSet {
	static int[] d = { 1, 3, 5 };
	static int cnt;

	static int candidates(int[] a, int k, int[] c) {
		c[0] = 0;
		c[0] = 1;
		return 2;
	}

	static void backtrack(int[] a, int k, int input) {
		int[] c = new int[a.length];
		if (k == input) {
			cnt++;
			System.out.println(Arrays.toString(a) + " ");
			for (int i = 0; i < input; i++) {
				if (a[i] == 1) {
					System.out.print(d[i] + " ");
					System.out.println();
				}
			}
		} else {
			int ncands = candidates(a, k, c);
			for (int i = 0; i < ncands; i++) {
				a[k] = c[i];
				backtrack(a, k + 1, input);
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[d.length];
        backtrack(a,0,a.length);
        System.out.println(cnt);
	}

}
