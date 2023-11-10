import java.util.Arrays;
import java.util.Scanner;

public class sstelecom {
	static int[] diry = {-1,1,0,0};
	static int[] dirx = {0,0,-1,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			int n = sc.nextInt();
			char[][] arr = new char[n][n];
			
			for(int i=0;i<n;i++) {
				String s = sc.next();
				arr[i] = s.toCharArray();
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j] != 'X' && arr[i][j] != 'H') {
						for(int k=1;k<arr[i][j] - 'A'+2;k++) {
							if(arr[i][j+k] == 'H') // 동 
							{
								arr[i][j+k] ='X';
							}
							if(arr[i][j-k] == 'H') // 서
							{
								arr[i][j-k] ='X';
							}
							if(arr[i+k][j] == 'H') // 남
							{
								arr[i+k][j] ='X';
							}
							if(arr[i-k][j] == 'H') // 동 
							{
								arr[i-k][j] ='X';
							}
						}
					}
					
				}
			}
			int count = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j] == 'H')
						count++;
				}
			System.out.println(Arrays.toString(arr[i]));
			}
			System.out.println(count);
		}
		
		
		
	}

}
