import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_화염에서탈출_1082 {
	static int[] diry = {-1, 1, 0, 0};
	static int[] dirx = {0, 0 , -1 , 1};
	static Queue<int[]> queue;
	static Queue<int[]> sq;
	static int[][] visited;
	static int N;
	static int M;
	static Boolean check;
	static char[][] map;
	static int minute = 0;
	
	static void spread() {
		int size = sq.size();
		for(int i=0; i<size; i++) {
			int[] n = sq.poll();
			for(int d=0;d<diry.length;d++) {
				int ny = n[0] + diry[d];
				int nx = n[1] + dirx[d];
				if(ny < N && nx < M && ny >= 0 && nx >= 0) {
					if(map[ny][nx] == '.') {
						map[ny][nx] = '*';
						sq.offer(new int[] {ny, nx});
					}
				}
			}
		}
	}
	static void bfs(int i, int j) {
		queue.add(new int[] {i, j});

		while(!queue.isEmpty()) {
			spread();
			int size = queue.size();
			//for(int s=0;s<size;s++) {
				int[] n = queue.poll();
				visited[n[0]][n[1]] = -1;
				if(check) return;
				if(map[n[0]][n[1]] == 'D') {
					check = true;
					break;
				}
				for(int d=0;d<diry.length;d++) {
					int ny = n[0] + diry[d];
					int nx = n[1] + dirx[d];
					
					if(ny < N && nx < M && ny >= 0 && nx >= 0 && visited[ny][nx] == 0) {
						if(map[ny][nx] == '.') {
							queue.offer(new int[] {ny, nx});
							visited[ny][nx] = -1;
						}
						if(map[ny][nx] == 'D') {
							queue.offer(new int[] {ny, nx});
						}
					}
				}
			//}
			
			
			minute++;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new int[N][M];
		queue = new LinkedList<int[]> (); 
		sq = new LinkedList<int[]> (); 
		check = false;
		int[] start = new int[]{0, 0};
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'S') {
					start[0] = i;
					start[1] = j;
				}
				if(map[i][j] == '*') {
					sq.add(new int[] {i, j});
				}
			}
		}
		
		bfs(start[0], start[1]);
		if(check)
			System.out.println(minute-1);
		else 
			System.out.println("impossible");

	}

	

}
