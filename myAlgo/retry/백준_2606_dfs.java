package retry;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_2606_dfs {
	static int[] visited;
	static int V;
	static int E;
	static int[][] map;
	
	static void dfs(int node) {
		visited[node] = 1;
		for(int i=1;i<=V;i++) {
			if(visited[i] !=1 && map[node][i] == 1)
				dfs(i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		visited = new int[V+1];
		map = new int[V+1][V+1];
		
		for(int i=0;i<E;i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			map[n1][n2] = map[n2][n1] = 1;
		}
		
		dfs(1);
		int count = 0;
		for(int i=1;i<=V;i++) if(visited[i] == 1) count++;
		System.out.println(count-1);
	}

}
