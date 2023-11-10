package stack2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuePriority {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//들어간 순서대로 찍힌다
		Queue<String> queue = new LinkedList<String>();
		queue.offer("윤");
		queue.offer("규");
		queue.offer("희");
		System.out.println(queue);
		for(int i=0;i<3;i++)
			System.out.println(queue.poll()+" ");
		
		
		//가나다 순서대로 찍힌다. 
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		//역순으로
		//comparator을 통해 역순으로 가능
//		pq.offer("윤");
//		pq.offer("규");
//		pq.offer("희");
		pq.offer("3");
		pq.offer("1");
		pq.offer("2");
		System.out.println(pq);
		for(int i=0;i<3;i++)
			System.out.println(pq.poll()+" ");

		
		
	}

}
