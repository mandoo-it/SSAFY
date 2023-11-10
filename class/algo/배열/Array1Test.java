package array2;

import java.util.Arrays;

public class Array1Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.선언
		int[] a;//int a[];
		//2.생성
		a = new int[3];
		//1 + 2
		int[] b = new int[3];
		//초기화
		b[0] = 1;
		b[1] = 2;
		b[2] = 3;
		
		int[] c = {10, 11, 12};
		int[] d = new int[] {10, 11, 12};
		int[] e;
		//e = {10,11,12};//err
		e = new int[] {10,112,12};//ok
		//4.출력
//		for(int i=0;i<e.length;i++) {
//			System.out.println(e[i]);
//		}
//		//for-each는 조회 전용
//		for(int v:e) {
//			System.out.println(v + " ");
//		}
		//5. 복제
		int[] f = new int[e.length];
		System.arraycopy(e, 0, f, 0, e.length);
		e[0] = 0;
		System.out.println(Arrays.toString(e));
		System.out.println(Arrays.toString(f));

	}
}
