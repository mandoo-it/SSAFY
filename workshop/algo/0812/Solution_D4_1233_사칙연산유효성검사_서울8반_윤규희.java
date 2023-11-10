package tree;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D4_1233_사칙연산유효성검사_서울8반_윤규희 {
    static char[] arr;
    static int N;
    static int r = 1;
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input.txt"));
    	Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            N = sc.nextInt();
            arr = new char[N + 1];
            for (int i = 1; i <= N; i++) {
                String[] s = sc.nextLine().split(" ");
                if(s.length == 2) {
                	if(!(s[1].charAt(0) >=48 && s[1].charAt(0) <= 57)) {
                		r = 0;
                		break;
                	}
                		
         
                }
                	
 
            }
            System.out.print("#"+tc+" "+r);
           
            System.out.println();
        }
    }
}
