package list;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_3499_퍼펙트셔플queue_서울8반_윤규희2 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_d3_3499.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0;tc < T;tc++) {
			Queue<String> que1 = new LinkedList<>(); 
			Queue<String> que2 = new LinkedList<>(); 
			int ct = sc.nextInt();
			for(int i=0;i<ct;i++) {
				if(ct % 2 == 0) {
					if(i < ct/2) {
						que1.add(sc.next());
					} else que2.add(sc.next());
				} else {
					if(i <= ct/2) {
						que1.add(sc.next());
					} else que2.add(sc.next());
				}
			}
			System.out.print("#" + (tc+1) + " ");
			for(int i=0;i<ct/2;i++) {
				System.out.print(que1.poll() + " ");
				System.out.print(que2.poll() + " ");
			}
			if(ct % 2 == 1)
				System.out.print(que1.poll() + " ");
			System.out.println();
		}
	}

}
