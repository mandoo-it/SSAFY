package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D4_1210_Ladder1_서울8반_윤규희 {
	public static int[][] array;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			array = new int[102][102];
			int n = sc.nextInt();
			int endi = 0, endj = 0;
			for (int i = 1; i <= 100; i++)
				for (int j = 1; j <= 100; j++) {
					array[i][j] = sc.nextInt();
					if (array[i][j] == 2) {
						endi = i;
						endj = j;
					}
				}
			int i = endi;
			int j = endj;
			int dir = 0;

			while (i >= 0) {
				if (array[i][j + 1] == 1) {
					while (array[i][j + 1] == 1) {
						j++;
					}
				} else if (array[i][j - 1] == 1) {
					while (array[i][j - 1] == 1) {
						j--;
					}
				}
				i--;
			}
			System.out.println("#" + (tc+1) + " " + (j -1));
		}
	}
}
