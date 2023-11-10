package brutegreedy;

import java.util.Arrays;

public class SelectionSort2 {
	public static int n = 5;
	public static int[] a = {12,34,12,34,75};
	
	public static int minidx(int i, int j) {
		if(i == j) return i;
		int min = minidx(i+1,j);
		return a[i] < a[min] ? i : min;
	}
	public static void selection(int index) {
		
		if(index == n) return;
		int k = minidx(index, n-1);
		if(index != k) {
			int T = a[index];
			a[index] = k;
			a[k] = T;
		}
		selection(index + 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(a));
		System.out.println();
		selection(0);
//		for(int i=0;i<a.length;i++) {
//			int min = i;
//			for(int j=i+1;j<a.length;j++) {
//				if(a[j]<a[min]) min = j;
//			}
//			int T = a[i];
//			a[i] = a[min];
//			a[min] = T;
//		}
		System.out.println(Arrays.toString(a));
	}

}
