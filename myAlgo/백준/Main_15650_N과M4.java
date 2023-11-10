package 푸는중;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_15650_N과M4 {
	static int[] arr;
	static boolean[] visit;
	static int[] perm;
	static int n;
	static int r;
	static StringBuilder sb;
	
	static void perm(int count, int start) {
		if(count == r) {
			for(int i=0;i<r;i++) {
				sb.append(perm[i] + " ");
			}
			sb.append("\n");
			return;
		} else {
			for(int i=start;i<n;i++) {
					perm[count] = arr[i];
					perm(count+1, i );
			}
		}
	}
	public static void main(String[] args) throws Exception { 
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		n = sc.nextInt();
		r = sc.nextInt();
		
		arr = new int[n];
		perm = new int[r];
		visit = new boolean[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = i+1;
		}
		
		perm(0, 0);
		System.out.println(sb.toString());
		
		
	}
}
