package dp;

import java.util.Arrays;

public class LisTest3 {
	public static void main(String[] args) {
		int[] a= {8,2,4,3,6,11,7,10,14,5};
		int n=a.length;
		
		int[] l=new int[n+1];
		l[0]=a[0];
		int idx=0;
		for(int i=1; i<n;i++) {
			if(l[idx]<a[i]) {
				l[++idx]=a[i];
			}else {
				int start=0;
				int end=idx;
				while(start<end) {
					int mid=(start+end)/2;
					if(l[mid]>=a[i]) end=mid;
					else start=mid+1;
				}
				l[end]=a[i];
			}
		}
		System.out.println(idx+1);
		System.out.println(Arrays.toString(l));
	}
}
