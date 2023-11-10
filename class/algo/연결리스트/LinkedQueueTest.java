package list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedQueueTest {
	public static Node front=null;
	public static Node rear=null;

	public static boolean isEmpty() {
		if(front == null) return true;
		else return false;
	}
	public static void enQueue(int item) {
		Node n = new Node();
		n.data = item;
//		n.link = null;
		
		if(front == null) {
			rear = n;
			front = n;
		} else {
			rear.link = n;
			rear = n;
		}
	}
	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return -1;
		}
		int item = front.data;
		front = front.link;
		if(isEmpty()) rear = null;
		return item;
	}
	
	public static int qPeek() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return -1;
		}
		int item = front.data;
		return item;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		enQueue(1);
		enQueue(2);
		enQueue(3);
		System.out.println(qPeek());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		
		
	}

}
