package stack2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_1225_암호생성기_서울8반_윤규희 {	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_1225.txt"));
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc <= 10;tc++) {
			int T = sc.nextInt();
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int i=0;i<8;i++) {
				int n = sc.nextInt();
				queue.offer(n);
			}
			
			int five = 1;
			int c = 0;
			while(true) {
				c = queue.poll()- five;
				if(five++ == 5)
					five = 1;
				if(c <= 0) {
					queue.offer(0);
					break;
				}
				queue.offer(c);
				
			}
			System.out.print("#" + T + " ");
			for(int i=0;i<8;i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();

		}	
	}

}
