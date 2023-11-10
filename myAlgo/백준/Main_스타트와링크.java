package 푸는중;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_스타트와링크 {
	static int N;
	static int[] start;
	static int[] link;
	static int[][] map;
	static boolean[] visited;
	static int min = 100000000;
	
	static void comb(int s, int count) {
		if(count == N/2) {
			//System.out.println(Arrays.toString(start));
			//System.out.println(Arrays.toString(visited));
			int idx = 0;
			int idx1 = 0;
			int start_sum = 0;
			int link_sum = 0;
			
			for(int i=0;i<N;i++) {
				if(!visited[i]) {
					link[idx++] = i; 
				}
				else {
					start[idx1++] = i; 
				}
			}
			
			for(int i=0;i<N/2;i++) {
				for(int j=i+1;j<N/2;j++) {
					//System.out.println(i + " " + j);
					start_sum += (map[start[i]][start[j]] +map[start[j]][start[i]] );
					link_sum += (map[link[i]][link[j]] + map[link[j]][link[i]]);		
				}
			} 
			//System.out.println(start_sum + " " + link_sum);
			if(min > Math.abs(start_sum - link_sum)) min =  Math.abs(start_sum - link_sum);
			
			return;
		}
		
		for(int i=s;i<N;i++) {
			start[count] = i;
			visited[i] = true;
			comb(i+1, count+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		start = new int[N/2];
		link = new int[N/2];
		visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0 , 0);
		System.out.println(min);
		

	}


}
