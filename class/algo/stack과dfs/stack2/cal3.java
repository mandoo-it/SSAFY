package stack2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
 
public class cal3{
    public static String msg;
    public static Stack<Character> stack;
    public static Stack<Integer> stack2 = new Stack<Integer>();
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
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
    	System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        for(int tc=1;tc<=10;tc++) {
            stack = new Stack<Character>();
            int length = sc.nextInt();
            String msg = sc.next();
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
            msg = sb.toString();
            for(int i=0;i<msg.length();i++) {
                char c = msg.charAt(i);
                if('0' <= c && c <= '9') {
                    stack2.push(c - '0');
                } else {
                    int n2 = stack2.pop();
                    int n1 = stack2.pop();
                    int nn = 0;
                    switch(c) {
                        case '+': nn= n1 + n2;break;
                        case '-': nn= n1 - n2;break;
                        case '*': nn= n1 * n2;break;
                        case '/': nn= n1 / n2;break;
                     
                    }
                    stack2.push(nn);
                }
            }
            System.out.println("#" + tc + " " + stack2.pop());
        }
    }
 
}