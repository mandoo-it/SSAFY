package stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class top{

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		int[] arr = new int[N];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		String snum = br.readLine();
		String[] sa = snum.split(" ");
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(sa[i]);
			
			while(!stack.empty() && arr[stack.peek()] < arr[i]) {
				stack.pop();
			}
			
			if(stack.empty())
				System.out.print("0 ");
			else
				System.out.print((stack.peek() + 1) + " ");
			stack.push(i);
		}
 
	}

}
