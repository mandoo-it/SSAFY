import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1249_보급로_서울8반_윤규희 {
	static int[][] map;
	static int[][] memo;
	static PriorityQueue<int[]> queue;
	static int N;
	static int[] diry = {-1, 1, 0, 0};
	static int[] dirx = {0, 0, -1, 1};
	static int min;
	static int result;
	public static void bfs() {
		queue.offer(new int[] {0 ,0});
		
		while(!queue.isEmpty()) {
			int[] n = queue.poll();
		//	memo[n[0]][n[1]] = 1;
			//result += map[n[0]][n[1]];
			
			if(n[0] == N - 1 && n[1] == N - 1) {
//				if(result < min) {
//					min = result;
//				}
				//result = 0;
//				System.out.println(result);
//				for(int i=0;i<N;i++)
//					Arrays.fill(memo[i], 0);
//				break;
				break;
			}
			
			for(int d=0;d<diry.length;d++) {
				int ny = n[0] + diry[d];
				int nx = n[1] + dirx[d];
				
				if(ny >= 0 && nx >= 0 && ny < N && nx < N) {
					if(memo[ny][nx] > memo[n[0]][n[1]] + map[ny][nx]) {
						//result += map[ny][nx];
						//memo[ny][nx] = 1;
						memo[ny][nx] = memo[n[0]][n[1]] + map[ny][nx];
						queue.offer(new int[] {ny, nx});
					}
				}
				
			}
			System.out.println(min);
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=1;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(memo[o1[0]][o1[1]], memo[o2[0]][o2[1]]);
				}
			}) ;
			memo = new int[N][N];
			//min = Integer.MAX_VALUE;
			//result = 0;
			
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = s.charAt(j) - '0';
					memo[i][j] = Integer.MAX_VALUE;
				}
			}
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					System.out.print(map[i][j]);
//				}
//			}
			bfs();
			System.out.println(memo[N-1][N-1]);
			System.out.println(memo);
		}
		

	}

	

}
