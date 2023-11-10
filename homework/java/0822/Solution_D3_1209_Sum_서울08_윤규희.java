import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1209_Sum_서울08_윤규희 {
	static int[][] arr;
	static int[] sum;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_sum.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			sc.nextInt();
			arr = new int[100][100];
			sum = new int[202];
			
			int sum_cross1 = 0;
			int sum_cross2 = 0;
			
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr.length;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<arr.length;i++) {
				int sum_row = 0;
				int sum_columns = 0;
				for(int j=0;j<arr.length;j++) {
					sum_row += arr[i][j];
					sum_columns += arr[j][i];
					if(i == j)
						sum_cross1 = arr[i][j];
					if(99 - i == j)
						sum_cross2 = arr[i][j];
				}
				sum[i] = sum_row;
				sum[100 + i] = sum_columns;
			}
			sum[200] = sum_cross1;
			sum[201] = sum_cross2;
			System.out.println("#" + tc + " " + Arrays.stream(sum).max().getAsInt());
				
		
		}
	}
}
