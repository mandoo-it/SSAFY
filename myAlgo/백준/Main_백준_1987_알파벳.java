package 푸는중;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1987_알파벳 {
	static int R;
	static int C;
	static char[][] map;
	static boolean[] visited;
	static String s;
	static int[] diry = {-1, 1, 0, 0};
	static int[] dirx = { 0, 0,-1, 1};
	static int count,answer = 1;
	static int max = Integer.MIN_VALUE;
	
	static void dfs(int i, int j) {
		//System.out.println(i + " " + j);
		 if(answer < count) answer = count;
		//System.out.println(map[i][j] - 65);
		
		//System.out.println(i + " " + j);
		for(int d=0;d<diry.length;d++) {
			int ny = i + diry[d];
			int nx = j + dirx[d];
			
			
			if(ny >= 0 && nx >= 0 && ny < R && nx < C) {
				char value = map[ny][nx];
				if(!visited[value-65]) {
					count++;
					visited[value-65] = true;
					dfs(ny , nx);
					count--;
					visited[value-65] = false;
				}
			}
			
		}
		
		//count++;
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[26];
		
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		visited[map[0][0] - 65] = true;
		count++;
		dfs(0 ,0);
		System.out.println(answer);
	}

}
