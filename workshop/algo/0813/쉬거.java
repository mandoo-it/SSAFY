import java.util.Arrays;
import java.util.Scanner;

public class 쉬거 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc=1;tc<=t;tc++) {
			int[] arr = new int[8];
			int n = sc.nextInt();
			int remain = 0;
			
			if(n >= 50000) {
				int i = n/50000;
				arr[0] = i;
				n = n % 50000;
			}
			if(n >= 10000) {
				int i = n/10000;
				arr[1] = i;
				n = n % 10000;
			}

			if(n >= 5000) {
				int i = n/5000;
				arr[2] = i;
				n = n % 5000;
			}

			if(n >= 1000) {
				int i = n/1000;
				arr[3] = i;
				n = n % 1000;
			}

			if(n >= 500) {
				int i = n/500;
				arr[4] = i;
				n = n % 500;
			}

			if(n >= 100) {
				int i = n/100;
				arr[5] = i;
				n = n % 100;
			}

			if(n >= 50){
				int i = n/50;
				arr[6] = i;
				n = n % 50;
			}

			if(n >= 10) {
				int i = n/10;
				arr[7] = i;
				n = n % 10;
			}
			System.out.println("#" + tc);
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i] + " ");
			}

		}
	}
}
