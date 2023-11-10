																																																																			package 푸는중;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
class Point {
	int y;
	int x;
	int dis;
}
public class Main_백준_1753_최단경로 {
	static int V;
	static int E;
	static PriorityQueue<Point> pq; 
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		int start = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<Point>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.dis, o2.dis);
			}
			
		});
		
		
		
		
		
	}

}
