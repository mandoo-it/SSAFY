package stack2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MazeDfs {
	public static int V;
	public static int E;
	public static int[][] graph;
	public static boolean[] visit;
	public static Stack<Integer> stack;
	public static int cnt = 0;
	public static int[][] dir = {{0,-1},{0, 1},{-1,0},{1,0}};
	public static int[] di = {0, 0, -1, 1};
	public static int[] dj = {-1, 1, 0, 0};
	
	public static int[][] maze = 
		{{0,0,1,1,1,1,1,1},
		{1,0,0,0,0,0,0,1},
		{1,1,1,0,1,1,1,1},
		{1,1,1,0,1,1,1,1},
		{1,0,0,0,0,0,0,1},
		{1,0,1,1,1,1,1,1},
		{1,0,0,0,0,0,0,1},
		{1,1,1,1,1,1,1,0}};
	public static int N = maze.length;
	public static void dfsr(int i, int j) {
		maze[i][j] = --cnt;
		System.out.println();
		
		for(int[] a:maze) System.out.println(Arrays.toString(a));
		if(i==N-1 && j == N-1) return;
		
		for(int d=0;d<di.length;d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(0<=ni&&ni<N&&nj<=N&&0<=nj&&maze[ni][nj]==0)
				dfsr(ni,nj);
		}
		
	}
	
	public static void dfs(int i,int j) throws Exception {
		// TODO Auto-generated method stub
//		visit = new boolean[V];
		System.setIn(new FileInputStream("res/input.txt"));
		stack.push(i*N+j);
	
		
		while(!stack.empty()) {
			int curr = stack.pop();
			i = curr / N;
			j = curr % N;
			if(maze[i][j] == 0) {
				maze[i][j] = --cnt;
				System.out.println();
			}
			
			for(int[] a:maze) System.out.println(Arrays.toString(a));
			if(i==N-1 && j == N-1) {
				System.out.println(maze[i][j]*-1);
				return;
			}
			
			for(int d=0;d<di.length;d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(0<=ni&&ni<N&&nj<=N&&0<=nj&&maze[ni][nj]==0)
					stack.push(ni*N+nj);
			}
				
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		stack = new Stack<Integer>();
		cnt = 0;

		for(int[] a:maze) System.out.println(Arrays.toString(a));
		//dfsr(0,0);
		dfs(0,0);

	}

}
