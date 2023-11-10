package stack2;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1219_길찾기_서울8반_윤규희 {
	public static int V = 100;
	public static int E;
	public static int[][] graph;
	public static boolean[] visit;
	public static Stack<Integer> stack;
	
	//dfs를 재귀로 (대부분의 DFS)
	public static int dfsr(int node) {
		visit[node] = true;
		if(node == 99) return 1;
		for(int next=0;next<V;next++) { //0 1 3 5 4 2 6
			if(visit[next] == false && graph[node][next] ==1)
				if(dfsr(next) == 1) return 1;
		}
		return 0;
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_d4_1219.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1;tc <= 10; tc++) {
			tc = sc.nextInt();
			E = sc.nextInt();//간선의 개수
			System.out.println();
			graph = new int[V][V];
			
			stack = new Stack<Integer>();
			
			for(int i=0;i<E;i++) 
			{
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				graph[v1][v2] = 1;//양방향이니까
			}
			visit = new boolean[V];
			System.out.println("#" + tc + " " + dfsr(0));
			
		}

	}
}
