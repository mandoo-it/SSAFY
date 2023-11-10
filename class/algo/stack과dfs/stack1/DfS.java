package stack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DfS {

	public static int V;
	public static int E;
	public static int[][] graph;
	public static boolean[] visit;
	public static Stack<Integer> stack;
    
	//반복으로 dfs(넒이 우선 탐색은 큐를 쓰기 때문에 재귀가 안된다. ) - 나중에 넒이우선탐색할 때 쓰임
	public static void dfs(int node) {
		// TODO Auto-generated method stub
		visit = new boolean[V];
		stack.push(node);
		
		while(!stack.empty()) {
			int curr = stack.pop();
			if(visit[curr] == false) {
				visit[curr] = true;
				System.out.println(curr + " ");
				//for(int next=0;next<V;next++){ // 0 2 4 5 6 3 1 
				for(int next=V-1;next>=0;next--) { //0 1 3 5 4 2 6
					if(visit[next] == false && graph[curr][next] ==1)
						stack.push(next);
				}
			}
				
		}
	}
	
	//dfs를 재귀로 (대부분의 DFS)
	public static void dfsr(int node) {
		visit[node] = true;
		System.out.println(node+ " ");
		
		for(int next=0;next<V;next++) { //0 1 3 5 4 2 6
			if(visit[next] == false && graph[node][next] ==1)
				dfsr(next);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();//간선의 개수
		
		graph = new int[V][V];
		visit = new boolean[V];
		stack = new Stack<Integer>();
		
		for(int i=0;i<E;i++) 
		{
			int v1 = sc.nextInt();
			int v2 =   .nextInt();
			graph[v1][v2] = graph[v2][v1] = 1;//양방향이니까
		}
		for(int[] a:graph) System.out.println(Arrays.toString(a));
		//dfs(0);
		dfsr(0);
	}
}
