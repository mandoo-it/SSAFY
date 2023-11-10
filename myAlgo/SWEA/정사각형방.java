package 파이팅;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정사각형방 {
	static int N;
	static int[][] map;
	static Queue<int[]> queue;
	static int[] diry = {0 ,0, -1, 1};
	static int[] dirx = {-1, 1 ,0 ,0};
	static int[][] visited;
	static int count;
	static void bfs(int i, int j) {
		queue.add(new int[] {i, j});
		visited[i][j] = 1;
		
		while(!queue.isEmpty()) {
			int[] n = queue.poll();
			int value = map[n[0]][n[1]];
			count++;
			for(int d=0;d<diry.length;d++) {
				int ny = n[0] + diry[d];
				int nx = n[1] + dirx[d];
				if(ny >=0 && ny < N && nx < N && nx >= 0) {
					if(map[ny][nx] == value +1) {
						queue.offer(new int[] {ny, nx});
						break;
					}
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N  = Integer.parseInt(br.readLine());
			map = new int[N][N];
			queue = new LinkedList<>();
			visited = new int[N][N];
			
			int max = 0;
			int min_value = 0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					count = 0;
					if(visited[i][j] == 0)
						bfs(i, j);
					if (max < count) {
						max = count;
						min_value = map[i][j];
                    }
					if(max == count) {
						if(min_value > map[i][j])
							min_value = map[i][j];
					}
				}
			}
			System.out.println("#"+ tc +" " + min_value + " " + max);
		}

	}

}
