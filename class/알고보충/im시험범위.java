import java.util.Arrays;
/**
 * IM 소검 시험 범위
 *	for문 i 변수 관리
 *	배열의 index 관리
 *	API 사용
 *	문자열(아직 나오진 않음)
 */
public class im시험범위 {
	public static void main(String[] args) {
// 1. arr 배열에  key 값이 존재하는가? 있음/없음 출력
		int[] arr = {4,6,2,1,5,3};
		int key = 1; // 있음
//		int key = 10; // 없음
		// 코드작성 해주세요
		// 방법 1. 
		//int i = 0;
//		for(i=0;i<arr.length;i++) {
//			if(arr[i] == key) {
//				break;
//			}	
//		}
		//System.out.println(i == arr.length?"없":"있");
		
		//방법2.
		boolean check = false;
		for(int j=0;j<arr.length;j++) {
			if(arr[j] == key) {
				check = true;
				break;
			}	
		}
		System.out.println(check?"있":"없");
// 2. brr 배열에 최대값을 출력하시오 6
// 3. brr 배열에 최소값을 출력하시오 1
		int[] brr = {4,1,6,2,1,5,6,3};
		// 코드작성 해주세요
		Arrays.sort(brr);
		System.out.println(brr[brr.length-1] +" " +  brr[0]);
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<brr.length;i++) {
			if(brr[i] > max)
				max = brr[i];
			if(brr[i] < min)
				min = brr[i];
		}
		System.out.println(min +" " + max);
// 4. crr 배열의 모든 원소 합을 출력하시오
		int[] crr = {4,6,2,1,5,3}; // 21
		// 코드작성 해주세요
		int sum = 0;
		for(int i=0;i<crr.length;i++) {
			sum += crr[i];
		}
		System.out.println(sum);
// 5. drr 배열에서 ki 값이 몇회 나오는가?
		int[] drr = {2,4,1,2,3,2,3,2,5,2};
		int ki = 2;
		// 코드작성 해주세요
		int count = 0;
		for(int i=0;i<drr.length;i++) {
			if(drr[i] == ki)
				count++;
		}
		System.out.println(count);
// 6. 정렬 
		int[] err = {4,6,2,1,5,3};
		// 코드작성 해주세요
		Arrays.sort(err);
		System.out.println(Arrays.toString(err));
//		 카운팅 정렬, 퀵, 머지, 선택, 삽입, 버블 
		//카운팅정렬 해오는 것이 숙제
		
		
		 
// 7. frr 배열에서 사용된 숫자들을 오름차순으로 출력하시오
		int[] frr = {9,4,1,4,5,9,1,5,1,3,9};
		// 코드작성 해주세요
		Arrays.sort(frr);
		int value = frr[0]-1;//첫번재도 출력하기위해서 1을 빼줌
		for(int i=0;i<frr.length;i++) {
			if(value != frr[i]) {
				System.out.print(frr[i] + " ");
				value = frr[i];//새로운 값을 update
			}
		}
		System.out.println();
		
// 8. API 활용
		int[] grr = {4,6,2,1,5,3};
		int ke = 9;
		Arrays.sort(grr); //정렬
		System.out.println(Arrays.toString(grr));
		System.out.println(Arrays.binarySearch(grr, ke)); //정렬된 상태에서만 사용 가능하다 / 찾고자하는 원소의 index를 리턴 못 찾으면 있어야할 자리를 -index-1를 리턴
	
		
	}
}