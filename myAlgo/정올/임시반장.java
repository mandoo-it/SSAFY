package 파이팅;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class 임시반장 {

	 public static void main(String[] args){
	        // TODO Auto-generated method stub
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int[][] arr = new int[n+1][6];
	        int[] count = new int[n+1];
	         
	        for(int i=1;i<=n;i++) {
	            for(int j=1;j<=5;j++) { 
	                arr[i][j] = sc.nextInt();
	            }
	        }
	          
	         
	         for(int i=1;i<=n;i++) { //1번학생~n번 학생
	             int[] check = new int[n+1];   
	             for(int j=1;j<=5;j++) { //1-5학년 까지
	                    int value = arr[i][j];
	                    for(int k=1;k<=n;k++) { 
	                        if(value == arr[k][j] && k != i) {
	                            check[k] ++;
	                        }
	                    }
	                }  
	            // System.out.println(Arrays.toString(check));
	             for(int c=1;c<=n;c++) {
	                 if(check[c] >= 1) {
	                     count[i]++;
	                 }
	             }
	              
	           }
	        // System.out.println(" count " + Arrays.toString(count));
	         int max = 0;
	         for(int i=1;i<=n;i++) {
	             if(count[i] > max) {
	                max = count[i];
	             }
	         }
	         for(int i=1;i<=n;i++) {
	             if(count[i] == max) {
	                 System.out.println(i);
	                 break;
	             }
	         }
	    }

}
