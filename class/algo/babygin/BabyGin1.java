package array2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//첫째 완전 탐색 / 중복 순열 / 탐욕 알고리즘을 사용하면 최적해를 구할 수 있다
public class BabyGin1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_babygin.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			//String card = sc.next();
			int[] card = new int[6];
			for(int i=0;i<6;i++)
				card[i] = sc.nextInt();
			int[] count = {0,0,0,0,0,0,0,0,0,0};
			for(int i=0;i<6;i++) {
				count[card[i]]++;
				//char형 배열의 값이라 아스키코드 숫자 배열의 범위를 넘는거 이해하데 오래걸
				//count[Integer.parseInt(card.substring(i,i+1))]++;
			}
			int isBabygin = 0;
			
			for(int i=0;i<count.length;i++) {
				if(count[i] >= 3) {
					isBabygin++;
					if(count[i] >= 6)
						isBabygin++;
					count[i] = 0;
				}
					
				if(count[i] >= 1 && i < 8) {
					if(count[i+1] >0) {
						if(count[i+2] >0) {
							isBabygin++;
							count[i] -= 1;
							count[i+1] -= 1;
							count[i+2] -= 1;
							if(count[i] >= 1 && count[i+1] >= 1 && count[i+2] >= 1)
								isBabygin++;
						}
					}
				}
			}
			if(isBabygin >= 2)
				System.out.println("#" + tc + "  your cards are babygin!!");
			else 
				System.out.println("#" + tc + "  your cards are not babygin!!");
			
		}
		
	}

}
