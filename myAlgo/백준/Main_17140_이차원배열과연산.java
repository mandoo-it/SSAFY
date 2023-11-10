package 푸는중;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_17140_이차원배열과연산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] arr = new int[101][101];
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int r = Integer.compare(o1[1], o2[1]);
				if(r == 0) return Integer.compare(o1[0], o2[0]);
				return r;
			}
			
		});
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());//행
		int c = Integer.parseInt(st.nextToken());//열
		int k = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		int row = 3;//행
		int col = 3;//열
		int max_rsize = 3;
		int max_csize = 3;

		HashMap<Integer, Integer> map;
		int count = 0;
		
		while(true) {
			if(arr[r][c] == k) {
				System.out.println(count);
				break;
			} 
			
			if(count > 100) {
				System.out.println("-1");
				break;
			}
			
			if(row >= col) {//행에 대한 정렬
				row = max_rsize;
				col = max_csize;
				
				for(int i=1;i<=row;i++) {
					map = new HashMap<>();
					
					label : for(int j=1;j<=col;j++) {
						if(arr[i][j] == 0) continue label;
						if(map.containsKey(arr[i][j])) {
							int value = map.get(arr[i][j]);
							map.replace(arr[i][j], value +1);
						} else map.put(arr[i][j], 1);
					}
					for(Integer s : map.keySet()) {
						pq.add(new int[] {s, map.get(s)});
					}
					
					Arrays.fill(arr[i], 0);
					if(max_csize < pq.size() * 2) max_csize = pq.size() * 2;
					int index = 1;
					while(!pq.isEmpty()) {
						int[] poll = pq.poll();
						arr[i][index++] = poll[0];
						arr[i][index++] = poll[1];
					}
				}
				
				row = max_rsize;
				col = max_csize;
			} 
			
			else {	 // 열에 대한 정렬
				row = max_rsize;
				col = max_csize;
				
				for(int i=1;i<=col;i++) {
					map = new HashMap<>();
					
					label : for(int j=1;j<=row;j++) {
	
						if(arr[j][i] == 0) continue label;
						if(map.containsKey(arr[j][i])) {
							int value = map.get(arr[j][i]);
							map.replace(arr[j][i], value +1);
						} else map.put(arr[j][i], 1);
					}
					for(Integer s : map.keySet()) {
						pq.add(new int[] {s, map.get(s)});
					}
					
					for(int dd=1;dd<=row;dd++) {
						arr[dd][i] = 0;
					}
					
					
					if(max_rsize < pq.size() * 2) max_rsize = pq.size() * 2;
					int index = 1;
					while(!pq.isEmpty()) {
						int[] poll = pq.poll();
					
						arr[index++][i] = poll[0];
						arr[index++][i] = poll[1];
					}
				
				}
				row = max_rsize;
				col = max_csize;
			}
			count++;
//			for(int i=1;i<=10;i++) {
//				for(int j=1;j<=10;j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
		}
		
//		for(int i=1;i<=10;i++) {
//			for(int j=1;j<=10;j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
	}
}
