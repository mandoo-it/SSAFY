package tree;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D4_1232_사칙연산_서울8반_윤규희 {
    static String[] arr;
    static int N;
    static double num1 = -1;
    static double num2 = -1;
    static double sum = 0;
    static char stick = '0';
    public static void inorder(int i) {
        if (i <= N && arr[i] != null) {
            inorder(2 * i); 
            if(arr[i].charAt(0) >=48 && arr[i].charAt(0) <= 57 ) {
            	if(num1 == -1)
            		num1 = Integer.parseInt(arr[i]);
            	else
            		num2 = Integer.parseInt(arr[i]);
            	//num1 = Integer.parseInt(arr[i]);
            }
//				System.out.println(arr[i]);
            else {
            	stick = arr[i].charAt(0);
            	switch(stick) {
	            	case '-':
	            		sum += (num1-num2);
	            	break;
	            	case '+':
	            		sum += (num1+num2);
	                	break;
	            	case '/':
	            		sum += (num1/num2);
	                	break;
	            	case '*':
	            		sum += (num1*num2);
	                	break;
            	}
            	num1 = -1;
            	num2 = -1;
            }
            inorder(2 * i + 1); 
            System.out.print(arr[i] + " ");
           
        }
    }
 
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input.txt"));
    	Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(sc.nextLine());
            arr = new String[N + 1];
            for (int i = 1; i <= N; i++) {
                String[] s = sc.nextLine().split(" ");
                arr[i] = s[1];
 
            }
            System.out.print("#"+tc+" ");
            inorder(1);
            System.out.print(sum);
        }
    }
}
