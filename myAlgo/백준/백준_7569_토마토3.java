package 푸는중;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_7569_토마토3 {
	static int[] diry = {-1, 1, 0, 0, 0, 0};
	static int[] dirx = { 0, 0,-1, 1, 0, 0};
	static int[] dirh = { 0, 0, 0, 0,-1, 1};
	static Queue<int[]> queue;
	static int[][][] map;
	static int N;
	static int M;
	static int H;
	static int count;
	static void bfs() {
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0;s<size;s++) {
				int[] poll = queue.poll();
				for(int d=0;d<diry.length;d++) {
					int nh = dirh[d] + poll[0];
					int ny = diry[d] + poll[1];
					int nx = dirx[d] + poll[2];
					
					if(nh>=0 && nh < H && ny >= 0 && nx >= 0 && ny < N && nx < M) {
						if(map[nh][ny][nx] == 0) {
							map[nh][ny][nx] = 1;
							queue.add(new int[] {nh, ny, nx});
						}
					}
				}
			}
			count++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		queue = new LinkedList<>();
		int already = 0;
		for(int h=0;h<H;h++) {
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
					if(map[h][i][j] == 1)
						queue.add(new int[] {h, i, j});
					if(map[h][i][j] == 0)
						already++;
				}
			}
		}
		
		
		bfs();
		
		Boolean checkv = false;
		for(int h=0;h<H;h++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[h][i][j] == 0) {
						checkv = true;
					}
				}
			}
		}
		
		if(already == 0)
			System.out.println("0");
		else if(checkv)
			System.out.println("-1");
		else
			System.out.println(count-1);

	}

}
