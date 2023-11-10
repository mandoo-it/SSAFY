import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_4963_섬의개수_서울8반_윤규희dfs {
	static int[] diry = {-1, 1, 0, 0, -1,-1, 1, 1};
	static int[] dirx = { 0, 0, -1, 1, -1, 1,- 1, 1};
	static int[][] map;
	static int[][] visited;
	static int w;
	static int h;
	static Queue<int[]> queue;
	static int count;
	
	static void dfs(int i, int j) {
		for(int d=0;d<diry.length;d++)	{	
			int ny = i + diry[d];
			int nx = j + dirx[d];
			
			if(ny >= 0 && ny <h && nx >= 0 && nx < w && visited[ny][nx] == 0) {
				if(map[ny][nx] == 1) {
					visited[ny][nx] = 1;
					dfs(ny, nx);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Boolean check = true;
		
		
		while(check) {
			st= new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			visited = new int[h][w];
			queue = new LinkedList<>();
			count = 0;
			
			if(w == 0 && h == 0) {
				check = false;
				return;
			}
			
			for(int i=0;i<h;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j] == 1 && visited[i][j] == 0) {
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}

	}
	

}
