import java.util.Scanner;

public class Solution_백준_4344_평균은넘겠지_서울8반_윤규희 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			int total = 0;
			int[] arr2 = new int[arr[i]];
			for(int j=0;j<arr[i];j++) {
				arr2[j] = sc.nextInt();
				total += arr2[j];
			}

			int average = total / arr2.length;		
			int cnt = 0;
			for(int j=0;j<arr2.length;j++) {
				if(arr2[j] > average)
					cnt++;
			}
			System.out.printf("%.3f",(double)cnt/arr2.length * 100);
			System.out.println("%");
		}
	
    }
}
