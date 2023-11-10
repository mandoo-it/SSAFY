package stack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class 막대자르기_스택 {
	public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("res/input_d4_5432.txt"));
	Scanner sc = new Scanner(System.in);
	
	int T = sc.nextInt();
	
	for (int tc=1; tc<=T; tc++) {
		
		String str = sc.next();
		int len = str.length();
		
		int max = 0;
		int count = 0;
		
		Stack<Character> c = new Stack<Character>();
		boolean check = false;
		for(int i=0; i<len; i++) {
			if(str.charAt(i) == '(') {
				c.push('(');
				check = true;
			}
			else {
				c.pop();
				if(check == false) {
					count+=1;
				}
				else {
					count += c.size();
				}
				check = false;
			}
		}
		System.out.println("#" + tc + " " + count);
	}
	sc.close();
}
	}
