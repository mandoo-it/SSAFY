package stack2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maiijyu_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Queue<int[]> queue = new LinkedList<int[]>();
		 Scanner sc = new Scanner(System.in);
		 int N = sc.nextInt();
		 int cnt = N;
		 int num = 1;
		 int total = 0;
		 int[] recv = null;
		 
		 queue.offer(new int[] {num,1}); // 사람 , 갯수
		 while(cnt > 0) {
			 recv = queue.poll();
			 int su = (recv[1] > cnt) ? cnt : recv[1];
			 total = total + su;
			 cnt = cnt - su;
			 System.out.println(recv[0] + "번이" + su + "갯수만큼 가져갑니다. 남은 수: " + cnt);
			 recv[1]++;//마이쮸 갯수 추가
			 queue.offer(recv);//다시 줄섬
			 queue.offer(new int[] {++num,1});//새로운 사람 줄선다.
		 
		 }
		 System.out.println("마지막 사람 = " + recv[0]);
		 System.out.println("총 개수 = " + total);
	}

}
