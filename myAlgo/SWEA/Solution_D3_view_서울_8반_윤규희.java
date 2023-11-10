import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_view_서울_8반_윤규희 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10;tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			int pre = 1;
			int next = 3;
			int count = 0;
			
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			for(int i=2;i<n;i++) {
				int max = 0;
				if(arr[i] - arr[pre] >= 1 && arr[i] - arr[next] >= 1 &&arr[i] - arr[pre-1] >= 1 && arr[i] - arr[next+1] >= 1) {
						int[] a = new int[4];
						a[0] = arr[pre];
						a[1] = arr[pre-1];
						a[2] = arr[next];
						a[3] = arr[next+1];
						Arrays.sort(a);
						count += (arr[i] - a[3]);
				}
					
				pre = i;
				next = i+2;
			}
			System.out.println("#" + tc + " " + count);
		}
	}

}
