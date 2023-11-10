package com.ssafy.java;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 Random r = new Random();
	  int num1= r.nextInt(45) + 1; 
	  int[] arr = new int[6];
	  int count = 6;
	  
	  for(int i=0;i<6;i++) {
		arr[i] = r.nextInt(45) + 1;
		for(int j=0;j<i;j++) {
			if(arr[i] == arr[j])
				i--;		
		}
	  }
	  System.out.println(Arrays.toString(arr));
	}

}
