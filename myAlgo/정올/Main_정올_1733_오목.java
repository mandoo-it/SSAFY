package 푸는중;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1733_오목 {
	static int[] diry = { 1, 0, 1,-1};
	static int[] dirx = { 0, 1, 1, 1};
	static int[][] map;
	static int winner = 0;
	static int count = 0;
	
	static void dfs(int i, int j, int d) {
		int value = map[i][j];
		int by = i - diry[d];
		int bx = j - dirx[d];
		
		if(count == 0 && by >= 0 && bx >= 0 && by < 19 && bx < 19 ) {
			if(map[by][bx] == map[i][j]) return;
		}
		
		int ny = i + diry[d];
		int nx = j + dirx[d];
		
		if(ny >= 0 && nx >= 0 && ny < 19 && nx < 19 && map[ny][nx] == value) {
			count++;
			dfs(ny, nx , d);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[19][19];
		
		for(int i=0;i<19;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<19;j++) { 
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		label : for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) { 
				if(map[i][j] != 0) {
					for(int d=0;d<diry.length;d++) {
						count = 0;
						dfs(i, j, d);
						if(count == 4) {
							System.out.println(map[i][j]);
							System.out.println((i + 1) + " "  + (j + 1));
							break label;
						}
						else if(count >= 5) {
							continue;
						}
					}
					
					
				}
			}
		}
		if(count != 4)
			System.out.println(0);
		}
	}

