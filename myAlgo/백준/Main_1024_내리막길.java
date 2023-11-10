
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//4 5
//50 45 37 32 30
//35 50 40 20 25
//30 30 25 17 28
//27 24 22 15 10
public class Main_1024_내리막길 {


		static Queue<int[]> queue;
		static int[] diry = {-1,1,0,0};
		static int[] dirx = {0,0,-1,1};
		static int N;
		static int M;
		static int[][] arr;
		static int[][] memo;
		static int result = 0;
		
//		private static void bfs() {
//			queue.offer(new int[] {0, 0});
//			while(!queue.isEmpty()) {
//				int[] cur = queue.poll();
//				//System.out.println(cur[0] + " " + cur[1]);
//				//if(memo[cur[0]][cur[1]] != 0) return memo[cur[0]][cur[1]];
//				if(cur[0] == N-1 && cur[1] == M-1)
//					result++;
//				for(int d=0;d<diry.length;d++) {
//					int ny = cur[0] + diry[d];
//					int nx = cur[1] + dirx[d];
//					if(ny < N && ny >= 0 && nx < M && nx >= 0 &&  arr[ny][nx] < arr[cur[0]][cur[1]]) {
//						queue.offer(new int[] {ny, nx});
//					}
//					
//				}
//			}
//	
//		}
		
		public static int dfs(int i, int j) {
            if(i==N-1&&j== M-1)return 1;
            if(memo[i][j]!=0) return memo[i][j];
            for(int d=0;d<diry.length;d++) {
                int ni=i+diry[d];
                int nj=j+dirx[d];
                if(ni>=0&&ni<N&&nj>=0&&nj<M&&arr[ni][nj]<arr[i][j]) {
                    memo[i][j]+=dfs(ni,nj);
                }
            }
            return memo[i][j];
        }

		public static void main(String[] args) throws FileNotFoundException {
			Scanner sc = new Scanner(System.in);

			//  구현하세요.
			N = sc.nextInt(); //sero
			M = sc.nextInt(); //garo
			queue = new LinkedList<>();
			
			arr = new int[N][M];
			memo = new int[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			dfs(0,0);
			System.out.println(dfs(0,0));
		}

}
