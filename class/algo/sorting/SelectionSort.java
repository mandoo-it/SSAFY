package array2;

import java.util.Arrays;

public class SelectionSort {
	public static int[] a = {12,34,12,34,75};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(a));
		System.out.println();
		
		for(int i=0;i<a.length;i++) {
			int min = i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[min]) min = j;
			}
			int T = a[i];
			a[i] = a[min];
			a[min] = T;
		}
		System.out.println(Arrays.toString(a));
	}

}
