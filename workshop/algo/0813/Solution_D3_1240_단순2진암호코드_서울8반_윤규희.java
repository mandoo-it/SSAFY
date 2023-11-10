import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1240_단순2진암호코드_서울8반_윤규희 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=1;tc++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int indexy = 0;
			int indexx = 0;
			char[][] arr = new char[y][x];
			
			for(int i=0;i<y;i++) {
				String s= sc.next();
				arr[i] = s.toCharArray();
				System.out.println(Arrays.toString(arr[i]));
			}   
			int f = -1;
			for(int i=y-1;i>=0;i--) {
				if(f == 1)
					break;
				for(int j=x-1;j>=0;j--) {
					if(arr[i][j] == '1') {
						indexy = i;
						indexx = j;
						f = 1;
						break;
					} 
				}
			}
			System.out.println(indexy+ " " + indexx);
			for(int i=indexx;i>=0;i-=7) {
				String s = "";
				if(i - 7 > 0) {
					for(int j=0;j<7;j++)
						s += Character.toString(arr[indexy][i-j]);
				}
				
				s = new StringBuffer(s).reverse().toString();
				System.out.println(s);
			}
			
		
		}
	}
}
