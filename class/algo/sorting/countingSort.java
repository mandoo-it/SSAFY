package array1;

import java.util.Arrays;

public class countingSort {
	public static void main(String[] args) {
	int[] a = {10, 4, 6, 7, 8,8, 9, 3, 1, 8, 5};
	int M = Arrays.stream(a).max().getAsInt();
	int[] c = new int[M+1];
	int[] s = new int[a.length];
	for(int i=0;i<a.length;i++) c[a[i]]++;
	for(int i=1;i<c.length;i++) c[i] += c[i-1];
	for(int i=0;i<a.length;i++) {
		c[a[i]]--;
		s[c[a[i]]] = a[i];
	}
	System.out.println(Arrays.toString(s));

	}}
