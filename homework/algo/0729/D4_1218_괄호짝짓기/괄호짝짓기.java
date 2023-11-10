package stack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 괄호짝짓기 {
	public static int[] stack = new int[10000];
	public static int top = -1;
	public static char[] left = {'(', '[','{','<'};
	public static char[] right = {')', ']','}','>'};
	public static boolean push(int value) {
		if(top >= stack.length) return false;
		else {
			stack[++top] = value;
			return true;
		}
	}
	
	public static int pop() {
		if(top == -1) return -1;
		return stack[top--];
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int num = sc.nextInt();
			String str = sc.next();
			int r = 1;
			for(int i=0;i<num;i++) {
				
				char ca = str.charAt(i);
				if(ca == '{' || ca == '[' || ca == '(' ||ca == '<') {
					push(ca);
				}
				else if(ca == '}' || ca == ']' || ca == ')' ||ca == '>') {
					int idx = 0;
					for(int k=0;k<left.length;k++) {
						if(stack[top] == left[k])
							idx = k;
					}
					if(ca == right[idx])
						pop();
					else {
						r = 0;
						break;
					}
						
				}
				
			}
			System.out.println("#" + tc + " " + r);
	
			
		
		}
	}
}
