package 파이팅;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 빙산을 1년씩 지운다
// 덩어리가 두덩어리가 되는 최초의 시간을 출력
public class 빙산 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] copy;
	static int[][] visited;
	static int[] diry = {0, 0, -1, 1};
	static int[] dirx = {-1, 1, 0, 0};
	static Queue<int[]> queue;
	static void bfs(int i, int j) {
		queue.add(new int[] {i, j});
		while(!queue.isEmpty()) {
			int[] n = queue.poll();
			visited[n[0]][n[1]] = 1;
			for(int d=0;d<diry.length;d++) {
				int ny = n[0] + diry[d];
				int nx = n[1] + dirx[d];
				if(ny >= 0 && ny < N && nx >= 0 & nx< M) { 
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
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy = new int[N][M];
		queue = new LinkedList<>();
		boolean check = false;
		int first = 0;
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = map[i][j];
			}
		}
		
		while(!check) {
			Boolean value = false;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++)
				{
					
					if(copy[i][j] != 0) {
						int count = 0;
						for(int d=0;d<diry.length;d++) {
							int ny = i + diry[d];
							int nx = j + dirx[d];
							if(ny >= 0 && ny < N && nx >= 0 & nx< M) {
								if(copy[ny][nx] == 0)
									count++;
							}
						}
						map[i][j] -= count;
						if(map[i][j] < 0)
							map[i][j] = 0;
					}
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					copy[i][j] = map[i][j];
				}
			}
			visited = new int[N][M];
			int cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j] != 0 && visited[i][j] == 0) {
						visited[i][j] = 1;
						bfs(i, j);
						cnt++;
					}
					if(map[i][j] != 0)
						value = true;
				}
			}
			
			if(cnt >= 2) {
				check = true;
			}
			if(!value)
			{
				first = 0;
				break;
			}
			first++;
		}
	
		System.out.println(first);
	}

}
