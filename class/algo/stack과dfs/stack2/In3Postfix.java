package stack2;

import java.util.Stack;

public class In3Postfix {
	public static String msg = "(6+5*(2-8)/2)";
	//public static String msg = "2+3*(4/5)";
	public static Stack<Character> stack = new Stack<Character>();
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
		char c = (stack.isEmpty()) ?'(':stack.peek();
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
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<msg.length();i++) {
			char c = msg.charAt(i);
			if('0' <= c && c <= '9') {
				sb.append(c);
			} else if(c == ')') {
				char s;
				while((s=stack.pop())!='(') {
					sb.append(s);
				}
			} else {
				while(getIcp(c) <= getIsp()) {
					char s = stack.pop();
					sb.append(s);
				}
				stack.push(c);
			}
		
		}
		while(!stack.empty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}

}
