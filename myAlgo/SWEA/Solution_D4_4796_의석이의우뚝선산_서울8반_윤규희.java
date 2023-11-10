import java.util.Scanner;

public class Solution_D4_4796_의석이의우뚝선산_서울8반_윤규희 {
	public static int N;
	public static int[] arr;
	public static int[] a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			a = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if(arr[i]<arr[j]) {
						if(a[i]+1 > a[j]) {
							a[j]=a[i]+1;
						}
					}
				}
			}
			int max=0;
			for(int i=0; i<N; i++) {
				System.out.println(a[i]);
				if(max<a[i])max=a[i];
			}
			System.out.println("#"+tc+" "+(max+1));
		}
	}
}
