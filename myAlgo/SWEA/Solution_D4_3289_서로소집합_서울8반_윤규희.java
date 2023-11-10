import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution_D4_3289_서로소집합_서울8반_윤규희 {
	public static class Edge {
		int a, b;

		public Edge(int a, int b) {
			this.a = a;
			this.b = b;
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
		if(a == b)
	    {
	        return;
	    }
		if (a < b) {
			p[b] = a;
		} else {
			p[a] = b;
		}
	}

	static int findParent(int[] p, int a, int b) {
		a = getParent(p, a);
		b = getParent(p, b);
		if (a == b) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			List<Edge> v = new ArrayList<>();
			int[] p = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}
			int count = 0;
			System.out.print("#" + tc + " ");
			for(int i=0;i<m;i++) {
				int input = sc.nextInt();
				if(input == 0) {
					int n1 = sc.nextInt();
					int n2 = sc.nextInt();
					v.add(new Edge(n1, n2));
					unionParent(p, v.get(count).a, v.get(count).b);
					count++;
				}
				if(input == 1){
					System.out.print(findParent(p, sc.nextInt(), sc.nextInt()));
				}
					
			}
			System.out.println();

		}
		sc.close();
	}
}
