package 푸는중;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// (0,0)에서 시작하는 거말고 
public class Main_16234_인구이동 {
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static Queue<int[]> queue2;
	static int[] diry = { 1,-1, 0, 0};
	static int[] dirx = { 0, 0,-1, 1};
	static int total;
	static int count = 0;
	static int result = 0;

	static void bfs(int i, int j) {
		queue.add(new int[] {i, j});
		queue2.add(new int[] {i , j});
		
		while(!queue.isEmpty()) {
			int polly = queue.peek()[0];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
			int pollx = queue.poll()[1];
			total += map[polly][pollx];
			visited[polly][pollx] = true;
			
			for(int d=0;d<diry.length;d++) {
				int ny = polly + diry[d];
				int nx = pollx + dirx[d];
				
				if(ny >= 0 && nx >= 0 && nx < N && ny < N && !visited[ny][nx]) {
					int gap = Math.abs(map[ny][nx] - map[polly][pollx]);
					if(gap >= L && gap <= R) {
						queue.add(new int[] {ny , nx});
						queue2.add(new int[] {ny , nx});
						visited[ny][nx] = true;
						count++;
					}
				}
			}	
		}
		
		
		int size = queue2.size();
		int value = total / size;
		while(!queue2.isEmpty()) {
			int polly = queue2.peek()[0];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
			int pollx = queue2.poll()[1];
			
			map[polly][pollx] = value;
		}
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		queue = new LinkedList<>();
		queue2 = new LinkedList<>();

		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		while(true) {
			visited = new boolean[N][N];
			count = 0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j]) {
						total = 0;
						visited[i][j] = true;
						bfs(i, j);
					}
				}
			}
			
			if(count == 0) break;
			result++;
		}
	
		System.out.println(result);
	
		
	}

}
