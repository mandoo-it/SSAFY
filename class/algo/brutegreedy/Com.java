package brutegreedy;

import java.util.Arrays;

//조합 nCr=nPr/r!
public class Com {
	public static int n,r,caseCount,data[];
	
	public static void combination(int start, int flag, int count) {
		if(count==r) {
			caseCount++;
			System.out.println(Arrays.toString(data));
			return;
		}
		for(int i=start;i<n;i++) {
			if((flag&1<<i)==0) {
				data[count]=i;
				combination(i+1,flag|1<<i,count+1);
			}
		}
	}
	
	public static void main(String [] args) {
		n=6;
		r=3;
		data=new int[r];
		combination(1,0,0);
		System.out.println(caseCount);
	}
}
