package 파이팅;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 창고다각형 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int left = Integer.MAX_VALUE;
		int right = 0;
		int maxIndex = 0;
		int sum = 0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			arr[n1] = Integer.parseInt(st.nextToken());
			
			if(left > n1) {
				left = n1;
			}
			if(right < n1) {
				right = n1;
			}
			
		}
		
		for(int i=left;i<=right;i++) {
			if(arr[i] >= arr[maxIndex]) {
				maxIndex = i;
			}
		}
		
		
		int mid = left;
		for(int i=left;i<maxIndex;i++) {
			if(arr[i] > arr[mid]) {
				mid = i;
			}
			else if(arr[i] < arr[mid]) {
				arr[i] = arr[mid];
			}
		}
		
		mid = right;
		for(int i=right;i>maxIndex;i--) {
			if(arr[i] > arr[mid]) {
				mid = i;
			}
			else if(arr[i] < arr[mid]) {
				arr[i] = arr[mid];
			}
		}
		
		for(int i=left;i<=right;i++) {
			sum += arr[i];
		}
		System.out.println(sum);
		}
		
	}
