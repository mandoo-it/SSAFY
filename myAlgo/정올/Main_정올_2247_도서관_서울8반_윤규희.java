import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main_정올_2247_도서관_서울8반_윤규희 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_2247.txt"));
		Scanner sc = new Scanner(System.in);
		ArrayList<int[]> arr = new ArrayList<int[]>();
	    
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			arr.add(new int[] {sc.nextInt(), sc.nextInt()});
		}
		
		Collections.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[0], o2[0]);
			}
		});
		 
		int start = arr.get(0)[0];
		int end = arr.get(0)[1];
		int nobody = 0;
		int yesbody = 0;
		
		//시작점이 범위 안에 있냐
		//범위 밖이면 초기화
		for(int i=1;i<arr.size();i++) {
			if(arr.get(i)[0] <= end) { //시작점이 범위 안에 있냐를 보는 거
				if(arr.get(i)[1] >= end) {
					end = arr.get(i)[1];
				}
				if(end - start > yesbody) {
					yesbody = (end - start);
				}
			} else { //시작점이 범위 밖일 때
				if(arr.get(i)[0] - end> nobody) //아무도 없는 시간을 계산하는 부분
					nobody = (arr.get(i)[0] - end);
				start = arr.get(i)[0];
				end = arr.get(i)[1]; //새로운 범위를 갱신해준다. 
			}
		}
		System.out.println(yesbody + " " + nobody);
		
		
		
		
	}
}