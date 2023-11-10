package array2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BabyGin2 {
	public static final int N = 6;
	public static int[] n  = new int[N];
	public static int[] a = new int[N];
	public static int[] c;
	public static int caseCount = 0;
	
	public static boolean solve() {
		int tri = 0;
		int run = 0;
		
		for(int i=0;i<c.length;i++) {
			if(c[i] >= 3) {
				c[i] = c[i]-3;
				tri++;
				i--;
			} else if(c[i]>=1&&c[i+1]>=1&&c[i+2]>=1&&i<=7){
				c[i]--;c[i+1]--;c[i+2]--;
				run++;
				i--;
			}
		}
			if(tri+run==2) return true;
			return false;
		
	}
 	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_babygin.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		c = new int[10];
		for(int tc=1;tc<=T;tc++) 
		{
			caseCount = 0;
			for(int i=0;i<6;i++)
				n[i] = sc.nextInt();
			for(int i=0;i<6;i++)
				c[n[i]]++;
			System.out.println("#" + tc +" " +  solve());
			
		}	
			
		}
}
