import java.util.Scanner;

public class Solution_D4_4301_콩많이심기_서울8반_윤규희 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();//가로
			int M = sc.nextInt();//세로
			
			int[][] arr = new int[M][N];
			
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j] != 1) {
						if(i + 2 < M) {
							arr[i+2][j] = 1;
						}
						if(j + 2 < N) {
							arr[i][j+2] = 1;
						}
						
					}
				}
			}
			int count = 0;
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[i].length;j++) {
					if(arr[i][j] == 0) count++;
				}
				
			}
			System.out.println("#" + tc + " " + count);
			
			
		}
	}

}
