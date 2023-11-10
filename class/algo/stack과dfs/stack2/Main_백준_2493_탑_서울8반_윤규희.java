package stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_백준_2493_탑_서울8반_윤규희 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] arr2 = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] =Integer.parseInt(st.nextToken());
		}
		for(int i=n-1;i>=0;i--) {
			for(int j=i-1;j>=0;j--) {
				if(arr[i] <= arr[j]) {
					arr2[i] = j+1;
					break;
				}
			}
		}
		for(int a : arr2)
			System.out.println(a);

	}

}
