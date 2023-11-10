package stack2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Bfs2 {

	public static int V;
	public static int E;
	public static int[][] graph;
	public static boolean[] visit;
	public static Queue<Integer> queue;
	public static void bfs2(int node) {
        int cnt = 0;
        visit = new boolean[V];
        queue.offer(node);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int cur = queue.poll(); //0
            if(visit[cur] == false) {// 방문 안했다면 
            	visit[cur] = true; 
                System.out.print(cur + " ");
                
            for(int next = 0; next<V; next++) { // 0 1 2 3 4 5 6 큐는 순서대로 하니까 
            //  for(int next = V-1; next>=0; next--) { //스택이라 순서가 뒤집혀서 나오기 때문에 인덱스 조절해줌 멀리있는것을 집어넣으면 나중에 나오니까 
                    if(visit[next] == false && graph[cur][next] == 1) {
                        queue.offer(next);
                    }
                }
            }
            }
            System.out.println("cnt=" + cnt++); //간격이 총 4칸 떨어져있음 
        }
    }


	//반복으로 dfs(넒이 우선 탐색은 큐를 쓰기 때문에 재귀가 안된다. ) - 나중에 넒이우선탐색할 때 쓰임
//	public static void bfs2(int node) {
//		// TODO Auto-generated method stub
//		int cnt = 0;
//		visit = new boolean[V];
//		//visit[node] = true;
//		queue.offer(node);
//		
//		while(!queue.isEmpty()) {
//			int size = queue.size();
//			for(int i=0;i<size;i++) {
//				int curr = queue.poll();
//				System.out.println(curr + " ");
//				
//				for(int next=0;next<V;next++){ //0 1 2 3 4 5 6
//					if(visit[next] == false && graph[curr][next] ==1)
//						visit[next] = true;
//						queue.offer(next);
//				}
//			}	
//		}
//		System.out.println("cnt="+cnt++);
//	}
	
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
		bfs2(0);
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