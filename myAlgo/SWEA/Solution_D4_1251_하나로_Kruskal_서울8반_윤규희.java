package 파이팅;

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
  
public class Solution_D4_1251_하나로_Kruskal_서울8반_윤규희 {
    public static int N;
    public static List<int[]> v;
    public static int[] p;
    public static PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
        @Override
        public int compare(double[] o1, double[] o2) {
            return Double.compare(o1[2], o2[2]);
        }
          
    });
  
    static double findSet(double x) {
        if (p[(int) x] == x) {
            return x;
        }
        return p[(int) x] = (int) findSet( p[(int) x]);
    }
  
    static void union(double a, double b) {
        a = findSet(a);
        b = findSet(b);
        if (a < b) {
            p[(int) b] = (int) a;
        } else {
            p[(int) a] = (int) b;
        }
    }
  
    public static long kruskal() {
        p = new int[N + 1];
        for (int i = 0; i < N +1; i++) {
            p[i] = i;
        }
        long sum = 0;
        while(!pq.isEmpty()) {
            double[] curr = pq.poll();
            if(findSet(curr[0]) != findSet(curr[1])) { 
                sum += curr[2];
                union(curr[0],curr[1]);
            }
        }
        return sum;
    }
  
    public static void main(String[] args) throws Exception, IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());//섬의 갯
            int[] y = new int[N];
            int[] x = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }
             
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    pq.add(new double[] {i, j, Math.pow(Math.abs(x[i] - x[j]), 2) + Math.pow(Math.abs(y[i] - y[j]), 2)});
                }
            }
             
            double E = Double.parseDouble(br.readLine());
             
            System.out.println("#" + tc + " " + Math.round(kruskal() * E));
        }
    }
}
