package 파이팅;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈도둑 {
	static int N;
	static int[][] map;
	static Queue<int[]> queue; 
	static int[] diry = {-1,1,0,0};
	static int[] dirx = {0,0,-1,1};
	static int count;
	static int[][] visited;
	
	static void bfs(int i, int j) {
		queue.offer(new int[] {i, j});
		visited[i][j] = 1;
		
		while(!queue.isEmpty()) {
			int[] n = queue.poll();
			
			for(int d=0;d<diry.length;d++) {
				int ny = n[0] + diry[d];
				int nx = n[1] + dirx[d];
				if(ny >= 0 && ny < N && nx >= 0 && nx < N) {
					if(map[ny][nx] != 0 && visited[ny][nx] == 0) {
						queue.offer(new int[] {ny, nx});
						visited[ny][nx] = 1;
					} 
				}
			}
			
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			queue = new LinkedList<>();
			int maxday = 0;
			int max = 0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(maxday < map[i][j])
						maxday = map[i][j];
				}
			}
			if(maxday == 1)
			{
				max = 1;
			}
			for(int day=1;day<=maxday;day++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(map[i][j] == day) {
							map[i][j] = 0;
						}
					}
				}
				visited = new int[N][N];
				count = 0;
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(visited[i][j] == 0 && map[i][j] != 0) {
							bfs(i, j);
							count++;
						}
					}
				}
				if(max < count)
					max = count;
			}
			System.out.println("#" + tc + " "  + max);
			
			
		}
	}

}
