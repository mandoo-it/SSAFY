package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnionFindTest {
	public static class Edge implements Comparable<Edge> {
		int a, b, distance;

		public Edge(int a, int b, int distance) {
			this.a = a;
			this.b = b;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(distance, o.distance);
		}
	}

	static int getParent(int[] p, int x) {
		if (p[x] == x) {
			return x;
		}
		return p[x] = getParent(p, p[x]);
	}

	static void unionParent(int[] p, int a, int b) {
		a = getParent(p, a);
		b = getParent(p, b);
		System.out.println(a +"unionParent" +b);
		if (a < b) {
			p[b] = a;
		} else {
			p[a] = b;
		}
	}

	static boolean findParent(int[] p, int a, int b) {
		a = getParent(p, a);
		b = getParent(p, b);
		System.out.println(a +"getParent" +b);
		if (a == b) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int n = 7;
		int m = 11;
		List<Edge> v = new ArrayList<>();
		v.add(new Edge(1, 7, 12));
		v.add(new Edge(1, 4, 28));
		v.add(new Edge(1, 2, 67));
		v.add(new Edge(1, 5, 17));
		v.add(new Edge(2, 4, 24));
		v.add(new Edge(2, 5, 62));
		v.add(new Edge(3, 5, 20));
		v.add(new Edge(3, 6, 37));
		v.add(new Edge(4, 7, 13));
		v.add(new Edge(5, 6, 45));
		v.add(new Edge(5, 7, 73));
		Collections.sort(v);

		int[] p = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}

		int sum = 0;
		for (int i = 0; i < v.size(); i++) {
			if (!findParent(p, v.get(i).a, v.get(i).b)) {
				sum += v.get(i).distance;
				System.out.println(sum);
				unionParent(p, v.get(i).a, v.get(i).b);
			}
		}
		System.out.println(sum);

	}

}
