package array2;

import java.util.Arrays;

public class Array2Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.선언
		int[][] a;//int a[];
		//2.생성
		a = new int[3][3];
		//1 + 2
		int[][] b = new int[3][];
		//초기화
		int[][] c = {{10, 11, 12},{0 ,11, 0}, {0 , 0, 12}};
		int[] d = new int[] {10, 11, 12};
		int[][] e;
		//e = {10,11,12};//err
		e = new int[][]{{10, 11, 12},{0 ,11, 0}, {0 , 0, 12}};//ok
		//4.출력
//		for(int i=0;i<e.length;i++) {
//			System.out.println(e[i]);
//		}
//		//for-each는 조회 전용
//		for(int v:e) {
//			System.out.println(v + " ");
//		}
		//5. 복제
//		int[] f = new int[e.length];
		int[][] f = new int[e.length][];
//		for(int i=0; i<e.length;i++) {
//			f[i] = new int[e[i].length];
//		}	
		f = e.clone();
		e[0][0] = 0;
		//2차원배열 출력
		for(int[] w:e) System.out.println(Arrays.toString(w));
		for(int[] w:f) System.out.println(Arrays.toString(w));

	}

}
