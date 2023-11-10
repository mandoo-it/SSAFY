package list;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,3,4,5,6,7,8,1,2,10,9};
		
		for(int i=1;i<arr.length;i++) {
//			for(int j=i;j<arr.length;j++) {
//				if(arr[i] > arr[j]) {
//					int tmp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = tmp;
//				}
//			}
			int k = i;
			for(int j=i-1;j>=0;j--) {
				if(arr[j] > arr[k]) {
					int T = arr[j];arr[j] = arr[k];arr[k] = T;
					k = j;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
		
	}

}
