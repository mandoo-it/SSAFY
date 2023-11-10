import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main_백준_1931_회의실배정 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] arr = new int[N][3];
		ArrayList<int[]> time = new ArrayList<int[]>(); 
		
		for(int i=0;i<N;i++) {
			arr[i][2] = sc.nextInt();
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]> () {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[1], o2[1]);
			}
			
		});
		
		
		time.add(new int[] {arr[0][0], arr[0][1],arr[0][2]});
		
		for(int i=0;i<N;i++) {
			if(time.get(time.size()-1)[1] <= arr[i][0]) {
				time.add(new int[] {arr[i][0], arr[i][1],arr[i][2]});
			}
		}
		System.out.println(time.size());
		for(int[] a : time) {
			System.out.print(a[2] + " ");
		}
		
		
		
	}

}
