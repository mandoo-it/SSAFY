package 파이팅;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 백만장자 {
	/*
	 *`
	 * 최대값 이후 끝 영역에서 두번째 최대값을 찾는다. 두번째 최대값 앞쪽 숫자에 사서 두번째 최대값에 판다.
	 * 2. 뒤에서부터 역순으로 접근
	 * 		최대기준값 초기화 = 끝값
	 * 		최대기준값보다 작으면 삿다 팔기 반복
	 * 		최대기준값보다 크면 최대기준값을 업데이트
	 * 
	 * */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt(); //0 <= 매매가 <= 10000
			}
			long sum = 0; //타입 정할 때 기준 : 저장할 때 최대 숫자의 범위
			int maxIndex = 0;//최대값이 들어가있는 방번호
			int start = 0;//판매할 시작위치
			while(maxIndex < n-1) {
				//최대값 위치 찾을 범위 : start ~ N-1
				maxIndex = start;
				for(int i=start;i<n;i++) {
					if(arr[maxIndex] < arr[i]) {
						maxIndex = i;
					}		
				}
				//start ~ maxIndex 판매
				for(int i=start;i<maxIndex;i++) {
					sum += arr[maxIndex] - arr[i];
				}
				
				start = maxIndex + 1;
				//start = maxIndex+1 수정
			}
			System.out.println(sum);
			
			
		}
	}

}
