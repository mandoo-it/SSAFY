package stack2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static int[] queue = new int[100];
	public static int front=-1;
	public static int rear=-1;
	public static boolean isEmpty() {
		if(front == rear) return true;
		else return false;
	}
	public static boolean isFull() {
		if(rear == queue.length -1) return true;
		else return false;
	}
	public static void enQueue(int item) {
		if(isFull()) {
			System.out.println("Queue Full");
			return;
		}
		queue[++rear] = item;
	}
	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return -1;
		}
		return queue[++front];
	}
	
	public static int qPeek() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return -1;
		}
		return queue[front+1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Queue<String> queue = new LinkedList<String>();
//		queue.offer("ㅁ");
//		queue.offer("ㅛ");
//		System.out.println(queue);
//		System.out.println(queue.peek());
//		System.out.println(queue.size());
//		System.out.println(queue.size());
//		queue.offer("사오정");
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());
//		System.out.println(queue);
		
		enQueue(1);
		enQueue(2);
		enQueue(3);
		
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		
		
	}

}
