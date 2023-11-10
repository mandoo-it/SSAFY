import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D5_1247_서울8반_윤규희 {
	static int customer;
	static int[][] visited;
	static int total;
	static int min;
	public static void dfs(int code, int cnt, int total) {
		if(cnt == customer) {
			total += (Math.abs(visited[code][0]-visited[customer+1][0])+Math.abs(visited[code][1]-visited[customer+1][1]));
			if(total < min)
				min = total;
			return;
		}
		
		for (int i = 1; i <= customer; i++) {
            if (visited[i][2] == 0) {
                visited[i][2] = 1;
                dfs(i, cnt + 1, total + (Math.abs(visited[code][0] - visited[i][0]) + Math.abs(visited[code][1] - visited[i][1])));
                visited[i][2] = 0;
            }
        }	
		

	}
	
//	public static void dfs(int code) {
//		if(code == customer) {
//			System.out.println(total);
//			return;
//		}
//		for(int i=1;i<visited.length-1;i++) {
//			//total = 0;
//			if(visited[i][2] == 0) {
//				visited[i][2] = 1;
//				total += (Math.abs(visited[i][0]-visited[i+1][0]) +
//						 Math.abs(visited[i][1]-visited[i+1][1]));
//				dfs(i+1);
//			}
//		}
//	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_최적경로.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1;tc<=T;tc++) {
			customer = sc.nextInt();
			min = Integer.MAX_VALUE;
			visited = new int[customer+2][3];
			visited[0][0] = sc.nextInt();
			visited[0][1] = sc.nextInt();
			visited[customer+1][0] = sc.nextInt();
			visited[customer+1][1] = sc.nextInt();
			total = 0;
			for(int i=1;i<=customer;i++) {
				visited[i][0] = sc.nextInt();
				visited[i][1] = sc.nextInt();
			}
			dfs(0, 0, 0);
			System.out.println(min);
		}
	}

}

//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Solution_2606_바이러스_백준_서울8반_윤규희{
//	static int N;
//	static int L;
//	static int[][] arr;
//	static boolean[] visited;
//	static int count = 0;
//	
//	public static void dfs(int com) {
//		visited[com] = true;
//		for(int i=1;i<=N;i++) {
//			if(visited[i] == false && arr[com][i] == 1)
//			{
//				dfs(i);
//				count++;
//			}
//		}
//	}
//	
//	public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        arr = new int[N+1][N+1];
//        visited = new boolean[N+1];
//        L = sc.nextInt();
//        for(int i=0;i<L;i++) {
//        	int c1 = sc.nextInt();
//        	int c2 = sc.nextInt();
//        	arr[c1][c2] = arr[c2][c1] = 1;
//        }
//        dfs(1);
//        System.out.println(count);        
//        
//    }
//}
