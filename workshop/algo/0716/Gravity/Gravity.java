package array1;

import java.util.*;

public class Gravity {
	//9
	//	7,4,2,0,0,6,0,7,0
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int[] box = new int[N];
		 
		for(int i=0;i<N;i++) {
			box[i] = sc.nextInt();
		}
		
		int max = 0;
		for(int i=0;i<N;i++) {//i는 현재 내위치
			int cnt = N - (i+1);//크기가 9 - 인덱스 (i +1) 크기로 비교하려구(최대 낙차 맥시멈)
			for(int j=i+1;j<N;j++) {//j는 내 뒷번
				if(box[j] >= box[i]) cnt--;
			}
			if(max<cnt) max=cnt;
		}
		System.out.println(max);
		sc.close();
		
		

	}

}
