package array2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class babygin22 {
//	public static final int N = 6;
//	public static int[] n  = new int[N];
//	public static int[] a = new int[N];
//	public static int[] c;
//	public static int caseCount = 0;
	public static int N=6;
	public static int n[]=new int[N];
	public static int a[]=new int[N];
	
	//flag=0번 자리 사용유무
	public static boolean permutation(int flag, int count) {
		if(count==N) {
			int tri=0;
			int run=0;
			for(int i=0;i<2;i++) {
				if(a[i*3]==a[i*3+1]&&a[i*3+1]==a[i*3+2])
					tri++;
				if(a[i*3]+1==a[i*3+1]&&a[i*3+1]+1==a[i*3+2])
					run++;
			}
			if(tri+run==2)return true;
			else return false;
		}
		for(int i=0;i<N;i++) {
			if((flag&(1<<i))==0) {
				a[count]=n[i];
				if(permutation(flag|(1<<i),count+1)) return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_babygin.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			for(int i=0;i<6;i++)
				n[i]=sc.nextInt();
			System.out.println("#"+tc+" "+permutation(0,0));
		}
		sc.close();
	}
}

