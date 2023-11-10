package 푸는중;

import java.io.*;
import java.util.*;

class Node {
	int y;
	int x;
	String name;
	
	Node(int y, int x, String name) {
		this.y = y;
		this.x = x;
		this.name = name;
	}
}

public class Solution_D5_7369_종구의딸이름짓기_서울8반_윤규희 {
	static int N;
	static int M;
	static char[][] map = new char[2000][2000];
	static PriorityQueue<Node> pq;
	static boolean[][] visited;
	static int[] diry = {1,0};
	static int[] dirx = {0,1};
	static String result;
	
	static void bfs() {
		pq.add(new Node(0,0,""  + map[0][0]));
		
		while(!pq.isEmpty()) {
			Node poll = pq.poll();
			
			if(poll.y == N-1 && poll.x == M-1) {
				result = poll.name;
				break;
			}
			for(int d=0;d<diry.length;d++) {
				int ny = poll.y + diry[d];
				int nx = poll.x + dirx[d];
				
				if(ny >= 0 && nx >= 0 && ny < N && nx < M && !visited[ny][nx]) {
					visited[ny][nx] = true;
					pq.add(new Node(ny, nx, poll.name + map[ny][nx]));
				}
			}
			
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			pq = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated method stub
					return o1.name.compareTo(o2.name);
				}
				
			});
			visited = new boolean[N][M];
			
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<M;j++) {
					map[i][j] = s.charAt(j);
				}
			} 
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<M;j++) {
//					System.out.println(map[i][j]);
//				}
//			} 
			bfs();
			System.out.println("#" + tc + " " + result);
		}
		

	}
}
