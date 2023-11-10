package stack2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class top {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack= new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int max = arr[0];
		stack.push(max);
		
		for(int i=0;i<n;i++) {
			if(stack.peek() >= arr[i]) {
				System.out.println(Arrays.binarySearch(arr, stack.peek()));
			}
			System.out.println(stack.toString());
		}
		
	}

}
