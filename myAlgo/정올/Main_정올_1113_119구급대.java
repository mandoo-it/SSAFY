package 푸는중;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point {
	int y;
	int x;
	int d;
	int cor;
	
	public Point(int y, int x, int d, int cor) {
		super();
		this.y = y;
		this.x = x;
		this.d = d;
		this.cor = cor;
	}
}
public class Main_정올_1113_119구급대 {
    static int N,M,endy,endx;
    static int[][] map;
    static int[][] memo;
    static Queue<Point> queue;
    static int min = Integer.MAX_VALUE;
    static int[] diry = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dirx = { 0, 0,-1, 1};
   
    static void bfs(int i, int j) {
    	queue.add(new Point (i, j , 1, 0));
    	queue.add(new Point (i, j , 3, 0));
    	
    	while(!queue.isEmpty()) {
    		Point p = queue.poll();
    		
    		if(p.y == endy && p.x == endx) {
    			if(p.cor < min) min = p.cor;
    		}
    		
    		for(int d=0;d<diry.length;d++) {
    			int ny = diry[d] + p.y;
    			int nx = dirx[d] + p.x;
    			
    			if(ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] == 1) {
    				if(p.d == d && p.cor < memo[ny][nx] ) {
    					memo[ny][nx] = p.cor;
    					queue.add(new Point(ny, nx, p.d, p.cor));
    				} else if(p.d != d && p.cor +  1 < memo[ny][nx] ) {
    					memo[ny][nx] = p.cor + 1;
    					queue.add(new Point(ny, nx, d, p.cor + 1));
    				}
    			}
    		}
    	}
    	
    	
    }
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M =  Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		endy = Integer.parseInt(st.nextToken());
		endx =  Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();
		map = new int[N][M];
		memo = new int[N][M];
	
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs(0, 0);
		System.out.println(min);

	}

}
