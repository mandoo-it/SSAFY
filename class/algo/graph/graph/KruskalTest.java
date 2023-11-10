package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalTest {
	public static int N = 7;
	public static List<int[]> v;
	public static int[] p;
	
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

	public static int kruskal() {
		Collections.sort(v, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[2], o2[2]);
		}});

		p = new int[N + 1];
		for (int i = 0; i < N +1; i++) {
			p[i] = i;
		}

		int sum = 0;
		for (int i = 0; i < v.size(); i++) {
			if(findSet(v.get(i)[0]) != findSet(v.get(i)[1])) { 
				System.out.println("->" + Arrays.toString(v.get(i)));
				sum += v.get(i)[2];
				union(v.get(i)[0], v.get(i)[1]);
			}
		}
		return sum;
	}

	public static void main(String[] args) {	
		v = new ArrayList<int[]>();
		v.add(new int[]{1,7,12});
		v.add(new int[]{1,4,28});
		v.add(new int[]{1,2,67});
		v.add(new int[]{1,5,17});
		v.add(new int[]{2,4,24});
		v.add(new int[]{2,5,62});
		v.add(new int[]{3,5,20});
		v.add(new int[]{3,6,37});
		v.add(new int[]{4,7,13});
		v.add(new int[]{5,6,45});
		v.add(new int[]{5,7,73});
		
		System.out.println(kruskal());
	}
}
