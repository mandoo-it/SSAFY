package stack2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueCircular {
	public static int N = 3;
	public static int[] queue = new int[N];
	public static int front=1;
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
		queue[(++rear) % N] = item;
	}
	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return -1;
		}
		return queue[(++front) % N];
	}
	
	public static int qPeek() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return -1;
		}
		return queue[(front+1) % N];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		enQueue(1);
		enQueue(2);
		enQueue(3);
		System.out.println(deQueue());
		System.out.println(Arrays.toString(queue));
		//System.out.println(deQueue());
//		System.out.println(deQueue());

		
		
	}

}
