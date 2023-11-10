package 푸는중;

import java.util.Scanner;

public class 적록색약 {
	static int N;
	static char[][] map;
	static int normal;
	static int no_normal;
	static boolean[][] visited;
	static int[] diry = {-1, 1, 0, 0};
	static int[] dirx = { 0, 0,-1, 1};
	
	static void normal_dfs(int i, int j) {
		int value = map[i][j];
		for(int d=0;d<diry.length;d++) {
			int ny = i + diry[d];
			int nx = j + dirx[d];
			
			if(ny >= 0 && nx >= 0 && nx < N &&  ny < N && !visited[ny][nx]) {
				if(map[ny][nx] == value) {
					visited[ny][nx] = true;
					normal_dfs(ny, nx);
				}
			}
		}
	}
	
	static void no_normal_dfs(int i, int j) {
		int value = map[i][j];
		
		for(int d=0;d<diry.length;d++) {
			int ny = i + diry[d];
			int nx = j + dirx[d];
			
			if(ny >= 0 && nx >= 0 && nx < N &&  ny < N && !visited[ny][nx]) {
				if(value == 'R' || value == 'G') {
					if(map[ny][nx] != 'B') {
						visited[ny][nx] = true;
						no_normal_dfs(ny, nx);
					}
				} else {
					if(map[ny][nx] == value) {
						visited[ny][nx] = true;
						normal_dfs(ny, nx);
					}
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			map[i] = sc.next().toCharArray();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					normal++;
					normal_dfs(i,j);
				}
			}
		}
		
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					no_normal++;
					no_normal_dfs(i,j);
				}
			}
		}
		System.out.print(normal + " " + no_normal);
		
		
		

	}

}
