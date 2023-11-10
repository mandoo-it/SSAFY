package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 단지번호_dfs {
	static int[][] map;
	static int V;
	static int E;
	static int[] visited;
	static int[] diry = {-1,1,0,0};
	static int[] dirx = {0,0,-1,1};
 	
	static int count;
	static ArrayList<Integer> count_arr = new ArrayList<Integer>();
	static void dfs(int y, int x) {
		map[y][x] = 0;
		count++;
		for(int d=0;d<diry.length;d++) {
			int ny = y + diry[d];
			int nx = x + dirx[d];
			if(ny >= 0 & ny < V && nx >= 0 && nx < V) {
				if(map[ny][nx] == 1)
					dfs(ny,nx);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		map = new int[V][V];
		visited = new int[V];
		for(int i=0;i<V;i++) {
			String s = br.readLine();
			for(int j=0;j<V;j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if(map[i][j] == 1) {
					count = 0;
					dfs(i,j);
					count_arr.add(count);
				}
			}
		}
		Collections.sort(count_arr);
		System.out.println(count_arr.size());
		for(int i=0;i<count_arr.size();i++)
			System.out.println(count_arr.get(i));
	
	}

}
