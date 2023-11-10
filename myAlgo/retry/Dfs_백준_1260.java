package retry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Dfs_백준_1260 {
	static int[] visited;
	static int[] visited2;
	static int[][] map;
	static int V;
	static Queue<Integer> queue;
	static void dfs(int node) {
		System.out.print(node + " ");
		visited[node] = 1;
		for(int i=1;i<=V;i++) {
			if(visited[i] != 1 && map[node][i] == 1) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int node) {
		queue.offer(node);
		visited2[node] = 1;
		
		while(!queue.isEmpty()) {
		
			int n = queue.poll();
			System.out.print(n + " ");
			for(int i=1;i<=V;i++) {
				if(visited2[i] != 1 && map[n][i] == 1) {
					visited2[i] = 1;
					queue.offer(i);
				}
					
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		visited = new int[V+1];
		visited2 = new int[V+1];
		map = new int[V+1][V+1];
		queue = new LinkedList<Integer>();
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			map[n1][n2] = map[n2][n1] = 1;
		}
		dfs(start);
		System.out.println();
		bfs(start);
	}
}
