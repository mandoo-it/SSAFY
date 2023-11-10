package 푸는중;

import java.util.Arrays;
import java.util.Scanner;

public class NQueen {
	public static int N;
	public static int[] col;
	public static int result ;
	
	public static boolean promising(int i) {
		for(int j=0;j<i;j++) {
			if(col[j] == col[i] || Math.abs(col[i] - col[j]) == (i-j)) //x좌표가 같거나 대각선에 있으면 퀸이 가지 못하니까 return false
				return false;
		}
		return true;
	}
	public static void nqueen(int i) {
		if(i == N) { //각 열에 1개씩 n열까지 퀸이 채워지면 경우의 수를 하나 추가한다. 
			result += 1;
			return;
		}else {
			for(int j=0;j<N;j++) {
				col[i] = j;
				if(promising(i)) nqueen(i+1); //해당 자리에 놓을 수 있으면 바로 다음 열로 간다. 
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		result = 0;
		N = sc.nextInt();
		col = new int[N];
		nqueen(0);
		System.out.println(result);

		
	
	}

}
