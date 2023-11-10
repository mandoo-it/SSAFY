package com.ssafy.algo;

import java.util.Scanner;

public class Solution_D2_1289_초심자의회문검사_서울8반_윤규희 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			 String str = sc.next();
	            StringBuilder sb = new StringBuilder(str);
	            String str_rvs = sb.reverse().toString();
	            if(str.equals(str_rvs)) 
	            	 System.out.println("#" + tc + " " + 1);
	            else
	            	 System.out.println("#" + tc + " " + 0);
	           
		}
	}

}
