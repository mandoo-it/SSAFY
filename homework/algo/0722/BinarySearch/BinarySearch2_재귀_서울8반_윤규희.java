package com.ssafy.algo;
import java.util.*;
public class BinarySearch2_재귀_서울8반_윤규희 {

	static boolean binarysearch(int[] arr, int low, int high, int key) {
		if(low > high)
			return false;
		int middle = (low + high) / 2;
		if(key == arr[middle])
			return true;
		else if(low == high)
			return false;
		else if(key < arr[middle])
			return binarysearch(arr, low, middle-1,key);
		else
			return binarysearch(arr, middle+1, high,key);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {15, 43, 35, 12, 22, 24, 54};
		Arrays.sort(arr);
		int key = 54;
		System.out.println(binarysearch(arr, 0, arr.length-1, key));
	}

}
