package com.ssafy.algo;

import java.util.Arrays;

public class BinarySearch1_반복_서울8반_윤규희 {
	
	static boolean binarysearch(int[] arr, int key) {
		int start = 0;
		int end = arr.length -1; 
		while(start <= end) {
			int middle = (start + end) / 2;
			if(arr[middle] == key) {
				return true;
			}
			else if(arr[middle] > key) {
				end = middle - 1;
			}
			else 
				start = middle -1;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {15, 43, 35, 12, 22, 24, 54};
		Arrays.sort(arr);
		int key = 22;
		System.out.println(binarysearch(arr, key));
		//System.out.println(Arrays.binarySearch(arr, 23));
	}
	}
