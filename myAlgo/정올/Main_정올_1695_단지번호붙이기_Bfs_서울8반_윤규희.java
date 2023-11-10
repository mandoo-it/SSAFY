import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_정올_1695_단지번호붙이기_Bfs_서울8반_윤규희 {
	static int N;
	static int[] diri = {-1,1,0,0};
	static int[] dirj = {0,0,-1,1};
	static char[][] arr;
	static int[][] visited;
	static int count;
	static List<Integer> ct_arr = new ArrayList<Integer>();
	static Queue<int[]> queue;
	static void bfs(int i, int j) {
		queue.add(new int[] {i, j});
		arr[i][j] = '0';
		 while(!queue.isEmpty()) {
			 i = queue.peek()[0];
			 j = queue.poll()[1];
			 for(int d = 0;d<diri.length;d++) {
					int ni = i + diri[d];
					int nj = j + dirj[d];
					if(ni >= 0 && ni < N && nj >= 0&& nj < N) {
						 if(arr[ni][nj] == '1') {
							 count++;
							 arr[ni][nj] = '0';
							 queue.offer(new int[] {ni, nj});
						 }
							
					}
				}
		 }
		
	}
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N][N];
        visited = new int[N][N];
        queue = new LinkedList<int[]>();
        int total = 0;
        for(int i=0;i<N;i++) {
        	String s = sc.next();
        	arr[i] = s.toCharArray();
        }
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		if(arr[i][j] == '1') {
        			count = 1;
        			bfs(i, j);
        			ct_arr.add(count);
            		
        		}
        		
        	}
        }
        System.out.println(ct_arr.size());
        Collections.sort(ct_arr);
        for(int i=0;i<ct_arr.size();i++)
        	System.out.println(ct_arr.get(i));
       
           
        
    }
}
