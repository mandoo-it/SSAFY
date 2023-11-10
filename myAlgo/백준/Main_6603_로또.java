package 푸는중;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6603_로또 {
    //순서 신경 스지 않으니 조합
	static int N;
	static int[] num;
	static int[] com;
	static int R = 6;
	static StringBuilder sb;
	
	static void comb(int start, int count) {
		if(count == R) {
			for(int i=0;i<R;i++) {
				sb.append(com[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<N;i++) {
			com[count] = num[i];
			comb(i + 1, count+1);
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			num = new int[N];
			com = new int[R];
			sb = new StringBuilder();
			
			for(int i=0;i<N;i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(num);
			comb(0 ,0);
			System.out.println(sb.toString());
		}

	}

}
