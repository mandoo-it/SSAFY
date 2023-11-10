package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {
	static int N;
	static int M;
	static int[][] map;
	static int[] diry = {-1,1,0,0};
	static int[] dirx = {0,0,-1,1};
	static Queue<int[]> queue;
	static void bfs(int i, int j) {
		queue.add(new int[] {i, j});
		while(!queue.isEmpty()) {
			int[] n = queue.poll();
			map[n[0]][n[1]] = 0;
			for(int d=0;d<diry.length;d++) {
				int ny = n[0] + diry[d];
				int nx = n[1] + dirx[d];
				if(ny >= 0 && ny < N && nx >= 0 && nx < M) {
					if(map[ny][nx] == 1) {
						map[ny][nx] = 0;
						queue.offer(new int[] {ny, nx});
					}
						
				}
			}
		}
	}
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			queue = new LinkedList<>();
			int bechu = Integer.parseInt(st.nextToken());
			int count = 0;
			for(int i=0;i<bechu;i++) {
				st = new StringTokenizer(br.readLine());
				int n2 = Integer.parseInt(st.nextToken());
				int n1 = Integer.parseInt(st.nextToken());
				map[n1][n2] = 1;
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j] == 1) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		
		
		
		
	}

}
