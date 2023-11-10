package stack2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BfS {

	public static int V;
	public static int E;
	public static int[][] graph;
	public static boolean[] visit;
	public static Queue<Integer> queue;
    
	//bfs 스택으로 구현한 것 중 스택을 큐로 바꾸면 된다.
	public static void bfs(int node) {
		// TODO Auto-generated method stub
		visit = new boolean[V];
		queue.offer(node);
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			if(visit[curr] == false) {
				visit[curr] = true;
				System.out.println(curr + " ");
				for(int next=0;next<V;next++){ //0 1 2 3 4 5 6
					if(visit[next] == false && graph[curr][next] ==1)
						queue.offer(next);
				}
			}
				
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();//간선의 개수
		
		graph = new int[V][V];
		visit = new boolean[V];
		queue = new LinkedList<Integer>();
		
		for(int i=0;i<E;i++) 
		{
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1][v2] = graph[v2][v1] = 1;//양방향이니까
		}
		for(int[] a:graph) System.out.println(Arrays.toString(a));
		//dfs(0);
		//dfsr(0);
		bfs(0);
	}
}
//0123456
/*7
8
0 1 
0 2
1 3
1 4
2 4
3 5
4 5
5 6 */
//0123465
/*7
8
0 1 
0 2 
1 3
1 4
3 5
4 5
5 6
2 6*/