package stack2;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Stack;
public class maze {
    public static int[][] maze = { { 0, 0, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 0, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 0 } }; // 좌, 우, 상, 하
    public static int[] di = { +0, +0, -1, +1 };
    public static int[] dj = { -1, +1, +0, +0 };
    public static int[][] visit;
    public static int N = maze.length;
    public static int cnt = 0;
    public static Stack<Integer> stack;
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input.txt"));
//      cnt =0;
        stack = new Stack<Integer>();
        visit = new int[N][N];
        dfsr(0, 0, 0);
        for (int[] a : maze)
            System.out.println(Arrays.toString(a));
    }
    private static void dfsr(int i, int j, int cnt) {
        visit[i][j] = 1;
        if (i == N - 1 && j == N - 1) {
            System.out.println("i = " + i + ", j = " + j + ", cnt = " + cnt);
            return;
        }
        for (int d = 0; d < di.length; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && visit[ni][nj] == 0 && maze[ni][nj] == 0) {
                dfsr(ni, nj, cnt + 1);
            }
        }
    }
    public static void dfs(int i, int j) {
        maze[i][j] = -1;
        stack.push(i * N + j);
        while (!stack.empty()) {
            int curr = stack.pop();
            i = curr / N;
            j = curr % N;
            if (maze[i][j] <= 0) {
                // maze[i][j]=--cnt;
                // System.out.println();
                // for(int[] a:maze) System.out.println(Arrays.toString(a));
                if (i == N - 1 && j == N - 1) {
                    System.out.println(maze[i][j] * -1);
                    return;
                }
            }
            for (int d = 0; d < di.length; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < N && maze[ni][nj] == 0) {
                    maze[ni][nj] = maze[i][j] - 1;
                    stack.push(ni * N + nj);
                }
            }
        }
    }
}