package 파이팅;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 회의실 {
	public static class Meeting implements Comparable<Meeting>{
		int num;
		int start;
		int end;
		
		public Meeting(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			// TODO Auto-generated method stub
			return Integer.compare(end, o.end);
		}
		@Override
		public String toString() {
			return num +"(" +start+","+end+")";
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_회의실.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Meeting[] m = new Meeting[N];
		for(int i=0;i<N;i++) {
			m[i] = new Meeting(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(m);
		List<Meeting> list = new ArrayList<Meeting>();
		list.add(m[0]);
		for(int i=1;i<m.length;i++) {
			if(list.get(list.size() - 1).end <= m[i].start) {
				list.add(m[i]);
			}
		}
		System.out.println(list.size());
		for(Meeting meet : list) System.out.print(meet.num + " ");
}
	
}