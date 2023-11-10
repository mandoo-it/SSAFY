package array2;

import java.util.Arrays;

public class Array2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
		int N = a.length;
		int M = a.length;
	
//		for(int[] w:a) System.out.println(Arrays.toString(w));
//		
//		//열 우선 순회
//		for(int i=0;i<a.length;i++) {
//			for(int j=0;j<a[i].length;j++) {
//				System.out.println(a[j][i]);
//			}
//		}
//		
//		//지그재그 순회
//				for(int i=0;i<a.length;i++) {
//					for(int j=0;j<a[i].length;j++) {
//						//홀수 일 때 짝수일 때 나눠서
//						System.out.print(a[i][j +(a[i].length-1-2*j) * (i%2)]);
//					}
//					System.out.println();
//				}
				
		//전치행렬(역행렬
		int[][] b = new int[a.length][];
		for(int i=0;i<a.length;i++) {
			b[i] = Arrays.copyOf(a[i], a[i].length);
		}
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[i].length;j++) {
				if(i<j) {
					int T = b[i][j];b[i][j] = b[j][i]; b[j][i] = T;
				}
					
			}
		}
		for(int[] w:a) System.out.println(Arrays.toString(w));
		for(int[] w:b) System.out.println(Arrays.toString(w));
//		
//		//4방(5를 기준)2-6-8-4
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				//어딜 기준으로 할지
//				//if(a[i][j] == 1) {
//					/*
//					System.out.println(a[i-1][j+0]);//2
//					System.out.println(a[i+0][j+1]);//6
//					System.out.println(a[i+1][j+0]);//8
//					System.out.println(a[i+0][j-1]);//4
//					*/
//					
//						int[] di = {-1,0,1,0};
//						int[] dj = {0,1,0,-1};
//					for(int d=0;d<di.length;d++) {
//						int ni = i+di[d];
//						int nj = j+dj[d];
//						if(0 <= ni && ni<N &&0<=nj  && nj<M) {
//							System.out.print(a[ni][nj]+" ");
//						}
//						
//					}
//					System.out.println();
//				}
//			
//			}
		
		
		//x4방(5를 기준)3-9-7-1
		
//		int[] di = {-1,1,1,-1};
//		int[] dj = {1,1,-1,-1};
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				//어딜 기준으로 할지
//				//if(a[i][j] == 1) {
//					/*
//					System.out.println(a[i-1][j+0]);//2
//					System.out.println(a[i+0][j+1]);//6
//					System.out.println(a[i+1][j+0]);//8
//					System.out.println(a[i+0][j-1]);//4
//					*/
//				
//					for(int d=0;d<di.length;d++) {
//						int ni = i+di[d];
//						int nj = j+dj[d];
//						if(0 <= ni && ni<N &&0<=nj  && nj<M) {
//							System.out.print(a[ni][nj]+" ");
//						}
//						
//					}
//					System.out.println();
//				}
//			
//			}
		
		//8방(5를 기준)3-9-7-1
		
				int[] di = {-1, -1, 0, 1 ,1 ,1, 0, -1};
				int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						//어딜 기준으로 할지
						//if(a[i][j] == 1) {
							/*
							System.out.println(a[i-1][j+0]);//2
							System.out.println(a[i+0][j+1]);//6
							System.out.println(a[i+1][j+0]);//8
							System.out.println(a[i+0][j-1]);//4
							*/
						
							for(int d=0;d<di.length;d++) {
								int ni = i+di[d];
								int nj = j+dj[d];
								if(0 <= ni && ni<N &&0<=nj  && nj<M) {
									System.out.print(a[ni][nj]+" ");
								}
								
							}
							System.out.println();
						}
					
					}
	}
	
		
	}
				



