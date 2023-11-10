import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_8016_홀수피라미드_서울8반_윤규희 {	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int left = 2*(n-1)*(n-1) +1;
			int right = 2*n*n -1;
			System.out.println("#" + tc + " " + left+" " + right);
		}
		
			
			
		}
	
}
