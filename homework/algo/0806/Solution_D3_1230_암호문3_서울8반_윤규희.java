package list;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_D3_1230_암호문3_서울8반_윤규희 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_d3_1230.txt"));
		Scanner sc = new Scanner(System.in);
	
		for(int tc=1;tc<=10;tc++) {
			List<Integer> list = new ArrayList<Integer>(); 
			int num = sc.nextInt();
			
			for(int i=0;i<num;i++) {
				list.add(sc.nextInt());
			}
			
			int com = sc.nextInt();
			for(int i=0;i<com;i++) {
				String s = sc.next();
				switch(s) {
				case "I" :
					int xi = sc.nextInt();
					int ni = sc.nextInt();
					for(int j=0;j<ni;j++) {
						int in = sc.nextInt();
						list.add(xi + j, in);
					}
					break;
				case "D" :
					int xd = sc.nextInt();
					int yd = sc.nextInt();
					for(int j=0;j<yd;j++) {
						list.remove(xd + j);
					}
					break;
				case "A" :
					int ya = sc.nextInt();
					for(int j=1;j<=ya;j++) {
						int sa = sc.nextInt();
						list.add(sa);
					}
					break;
				
				}
				
				
				
			}
			
			System.out.print("#" + tc + " ");
			for(int i=0;i<10;i++) {
				System.out.print(list.get(i) +" ");
			}
			System.out.println();
			
		}
		

	}

}
