import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int y;
	int x;

	Node(int y, int x) {
		this.y = y;
		this.x = x;

	}
}

public class Solution_D4_1249_보급로_서울8반_윤규희2{
	public static int N;
	public static int[][] map;
	public static int[][] d;
	public static boolean[][] visited;
	public static boolean check;
	public static int cnt;
	public static int min;

	public static int[] dy = { 0, 1, 0, -1 };
	public static int[] dx = { 1, 0, -1, 0 };

	public static Queue<Node> q = new LinkedList<>();

	public static void solve(Node node) {
		visited = new boolean[N][N];

		q.offer(node);
		visited[node.y][node.x] = true;
		cnt = 0;
		while (!q.isEmpty()) {

			cnt++;
			int size = q.size();
			for (int i = 0; i < size; i++) {

				Node n = q.poll();
				int y = n.y;
				int x = n.x;
				/*
				 * if (check) return;
				 * 
				 * if (y == N - 1 && x == N - 1) { check = true; return; }
				 */

				for (int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];

					if (0 > ny || ny >= N || 0 > nx || nx >= N)
						continue;

					if (!visited[ny][nx] || d[ny][nx] > d[y][x]+map[ny][nx]) {
						visited[ny][nx] = true;
						d[ny][nx] = d[y][x]+map[ny][nx];
						q.offer(new Node(ny, nx));
				}

				}

			}
		}

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			map = new int[N][N];
			d = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
					d[i][j] = s.charAt(j) - '0';
				}
			}

			solve(new Node(0, 0));
/*
			for (int[] ii : map) {
				System.out.println(Arrays.toString(ii));
			}
*/
			System.out.println("#"+tc+" "+d[N - 1][N - 1]);

		}

	}
}
