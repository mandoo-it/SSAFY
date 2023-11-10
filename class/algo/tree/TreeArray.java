package tree;

import java.io.FileInputStream;
import java.util.Scanner;

public class TreeArray {
    static char[] arr;
    static int N;
 
    public static void inorder(int i) {
        if (i <= N && arr[i] != 0) {
            inorder(2 * i); 
            System.out.print(arr[i]);
            inorder(2 * i + 1); 
        }
    }
 
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input.txt"));
    	Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(sc.nextLine());
            arr = new char[N + 1];
            for (int i = 1; i <= N; i++) {
                String[] s = sc.nextLine().split(" ");
                arr[i] = s[1].charAt(0);
 
            }
            System.out.print("#"+tc+" ");
            inorder(1);
            System.out.println();
        }
    }
}
