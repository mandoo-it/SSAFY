package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 단지번호_bfs {
	static int[][] map;
	static int V;
	static int E;
	static int[] diry = {-1,1,0,0};
	static int[] dirx = {0,0,-1,1};
 	static Queue<int[]> queue = new LinkedList<>();
	static int count;
	static ArrayList<Integer> count_arr = new ArrayList<Integer>();
	static void bfs(int y, int x) {
		queue.offer(new int[] {y, x});
		
		while(!queue.isEmpty()) {
			int[] n = queue.poll();
			int ny = n[0];
			int nx = n[1];
			map[ny][nx] = 0;
			count++;
			for(int d=0;d<diry.length;d++) {
				int nny = ny + diry[d];
				int nnx = nx + dirx[d];
				if(nny >= 0 && nny < V && nnx >= 0 && nnx < V) {
					if(map[nny][nnx] == 1) {
						map[nny][nnx] = '0';
						queue.offer(new int[] {nny, nnx});
					}	
				}	
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		map = new int[V][V];
	
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
					bfs(i,j);
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
