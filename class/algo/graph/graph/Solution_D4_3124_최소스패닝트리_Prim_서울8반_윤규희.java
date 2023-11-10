package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리_Prim_서울8반_윤규희 {
	public static int N;
	public static int INF=Integer.MAX_VALUE/2;

	public static int[][] a;
	public static int[] w;
	public static long prim() {
		Arrays.fill(w, -1); //값채우는거
		w[1] = 0;
		for(int k=2;k<=N;k++) { //정점 방문
			int minWeight = INF;
			int minVertax = 0;
			for(int i=1;i<=N;i++) {
				if(w[i] < 0) continue;
				for(int j=1;j<=N;j++){//각각의 정점안에서 돈다
					if(w[j] >= 0) continue;
					if(a[i][j] < minWeight) {
						minWeight = a[i][j];
						minVertax = j;
					}
				}
			}
			w[minVertax] = minWeight;
		}
		long sum = 0;
		for(int i=0;i<=N;i++) sum += w[i];
		return sum+1;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_3124.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int v_ct = Integer.parseInt(st.nextToken());
			a = new int[N+1][N+1];
			w = new int[N+1];
			for(int[] aa:a) {
				Arrays.fill(aa, INF);
			}
			for(int i=0;i<v_ct;i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				a[n1][n2] = a[n2][n1] = Integer.parseInt(st.nextToken());
			}
			System.out.println("#" + tc + " " + prim());
		}
		
	}

}
