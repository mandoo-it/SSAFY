package stack2;

import java.util.Scanner;
import java.util.Stack;

public class cal2 {
	public static String msg;
	public static Stack<Integer> stack = new Stack<Integer>();
	public static Stack<Character> stack2 = new Stack<Character>();
	public static int getIcp(char c) {
		switch(c) {
		case '+':
		case '-':
			return 1;
		
		case '*':
		case '/':
			return 2;
			
		case '(':
			return 3;
		default:
			return 0;
		}
	}
	public static int getIsp() {
		char c = (stack2.isEmpty()) ?'(':stack2.peek();
		switch(c) {
		case '+':
		case '-':
			return 1;
		
		case '*':
		case '/':
			return 2;
			
		case '(':
			return 0;
		default:
			return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		String ss = sc.next();
		StringBuilder sb = new StringBuilder(ss);
		for(int i=0;i<length;i++) {
			char c = sb.charAt(i);
			if('0' <= c && c <= '9') {
				sb.append(c);
			} else if(c == ')') {
				char s;
				while((s=stack2.pop())!='(') {
					sb.append(s);
				}
			} else {
				while(getIcp(c) <= getIsp()) {
					char s = stack2.pop();
					sb.append(s);
				}
				stack2.push(c);
			}
		
		}
		while(!stack.empty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
		msg = sb.toString();
		for(int i=0;i<msg.length();i++) {
			char c = msg.charAt(i);
			if('0' <= c && c <= '9') {
				stack.push(c - '0');
			} else {
				int n2 = stack.pop();
				int n1 = stack.pop();
				int nn = 0;
				switch(c) {
					case '+': nn= n1 + n2;break;
					case '-': nn= n1 - n2;break;
					case '*': nn= n1 * n2;break;
					case '/': nn= n1 / n2;break;
				
				}
				stack.push(nn);
			}
		}
		System.out.println(stack.pop());
	}
}
