package stack;

import java.util.Arrays;
import java.util.Stack;

public class StackTest {
	public static int[] stack = new int[100];
	public static int top = -1;
	
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
	
	public static <E> void main(String[] args) {
		// TODO Auto-generated method stub
//		push(1);
//		push(2);
//		push(3);
//		
//		System.out.println(pop());
//		System.out.println(pop());
//		System.out.println(pop());
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.empty());
		System.out.println(s.pop());
		System.out.println(s.pop());

	}

}
