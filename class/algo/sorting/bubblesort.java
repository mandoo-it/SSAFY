package array1;
import java.util.*;
public class bubblesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
	
		int[] a = new int[100];
		for(int i=0;i<a.length;i++) a[i] = r.nextInt(100);
		System.out.println(Arrays.toString(a));

//최대값을 가져놓는당
//		for(int i=a.length-1;i--) {
//			for(int j=0;j<i;j++) {
//				if(a[j]>a[j+1]){
//					int temp = a[j];
//					a[j] = a[j+1];
//					a[j+1] = temp;
//				}
//			}
//		}
		for(int i=0;i<=a.length;i++) {
			for(int j=0;j<a.length - 1-i;j++) {
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}		

		System.out.println(Arrays.toString(a));

	}

}
