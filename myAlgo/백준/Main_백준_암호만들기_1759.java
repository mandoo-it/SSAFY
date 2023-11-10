package 푸는중;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_암호만들기_1759 {
	static int N;
	static int R;
	static String[] num;
	static String[] com;
	static boolean[] visited;
	static String mo = "aeiou";
	
	static void comb(int start, int count) {
		if(count == R) {
			//System.out.println(Arrays.toString(com));
			int mocnt = 0;
			int jacnt = 0;
			for(int c=0;c<com.length;c++) {
				if(mo.contains(com[c])) {
					mocnt++;
				} else jacnt++;
			}
			
			if(mocnt >= 1 && jacnt >=2)  {
				for(String c : com) {
					System.out.print(c);
				}
				System.out.println();
			}
			return;
		}
		for(int i=start;i<N;i++) {
			com[count] = num[i];
			comb(i +1, count+1);
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		num = new String[N];
		visited = new boolean[N];
		com = new String[R];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = st.nextToken();
		}
		
		Arrays.sort(num);
		comb(0 ,0);
		//System.out.println(Arrays.toString(num));
		
		

	}

}
