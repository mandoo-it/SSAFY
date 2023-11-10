package 파이팅;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 수지의수지맞는여행 {
	static int N;
	static int M;
	static char[][] map;
	static Queue<int[]> queue;
	static int[] diry = {0, 0, -1, 1};
	static int[] dirx = {-1, 1, 0, 0};
	
	static void bfs() {
		queue.offer(new int[] {0,0});
		while(!queue.isEmpty()) {
			for(int d=0;d<diry.length;d++) {
				
			}
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			queue = new LinkedList<>();
			
			for(int i=0;i<N;i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			bfs();
		}
		

	}

}
