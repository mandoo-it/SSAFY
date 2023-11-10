package 푸는중;

import java.util.Scanner;

public class Main_정올_1719_별삼각형2_서울8반_윤규희 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if(n % 2 == 0) {
			System.out.println("INPUT ERROR!");
			return;
		}
		switch(m) {
		case 1 : 
			int mid = n / 2;
			for(int i=0;i<mid;i++) {
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for(int i=mid;i>=0;i--) {
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			int mid2 = n / 2;
			for(int i=0;i<mid2;i++) {
				for(int j=0;j<mid2-i;j++) {
					System.out.print(" ");
				}
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for(int i=mid2;i>=0;i--) {
				for(int j=0;j<mid2-i;j++) {
					System.out.print(" ");
				}
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3:
			int mid3 = n / 2;
			for(int i=mid3;i>0;i--) {
				for(int j=0;j<mid3-i;j++) {
					System.out.print(" ");
				}
				for(int j=0;j<i*2+1;j++) {
					System.out.print("*");
				}
				for(int j=0;j<mid3-i;j++) {
					System.out.print(" ");
				}
				System.out.println();
			}
			for(int i=0;i<=mid3;i++) {
				for(int j=0;j<mid3-i;j++) {
					System.out.print(" ");
				}
				for(int j=0;j<i*2+1;j++) {
					System.out.print("*");
				}
				for(int j=0;j<mid3-i;j++) {
					System.out.print(" ");
				}
				System.out.println();
			}
			
			break;
		case 4:
			int mid4 = n / 2 ;
			for(int i=mid4;i>0;i--) {
				for(int j=0;j<mid4-i;j++) {
					System.out.print(" ");
				}
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for(int i=0;i<=mid4;i++) {
				for(int j=0;j<mid4;j++) {
					System.out.print(" ");
				}
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		default:
			System.out.println("INPUT ERROR!");

		}
	}
}
