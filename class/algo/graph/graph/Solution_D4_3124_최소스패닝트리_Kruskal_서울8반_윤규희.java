package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리_Kruskal_서울8반_윤규희 {
	 public static int N;
	    public static List<int[]> v;
	    public static int[] p;
	    public static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
	        @Override
	        public int compare(int[] o1, int[] o2) {
	            return Integer.compare(o1[2], o2[2]);
	        }
	         
	    });
	 
	    static int findSet(int x) {
	        if (p[x] == x) {
	            return x;
	        }
	        return p[x] = findSet( p[x]);
	    }
	 
	    static void union(int a, int b) {
	        a = findSet(a);
	        b = findSet(b);
	        if (a < b) {
	            p[b] = a;
	        } else {
	            p[a] = b;
	        }
	    }
	 
	    public static long kruskal() {
	        p = new int[N + 1];
	        for (int i = 0; i < N +1; i++) {
	            p[i] = i;
	        }
	        long sum = 0;
	        while(!pq.isEmpty()) {
	            int[] curr = pq.poll();
	            if(findSet(curr[0]) != findSet(curr[1])) { 
	                sum += curr[2];
	                union(curr[0],curr[1]);
	            }
	        }
	        return sum;
	   }

	public static void main(String[] args) throws Exception, IOException {	
		System.setIn(new FileInputStream("res/input_3124.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int v_ct = Integer.parseInt(st.nextToken());
			for(int i=0;i<v_ct;i++) {
				st = new StringTokenizer(br.readLine());
				pq.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
			}
			System.out.println("#" + tc + " " + kruskal());
		}
	}
}
