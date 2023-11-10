import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D3_7964_부먹왕국_서울8반_윤규희 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int city = sc.nextInt();
			int limit = sc.nextInt();
			int[] arr = new int[city];
			int count = 0;
			int rs = 0;
			for(int i=0;i<city;i++)
				arr[i] = sc.nextInt();
			
		//	for(int i=0;i<city;i++) {
				for(int j=0;j<city;j++) {
					if(arr[j] != 1) {
						count++;
					}
					else count = 0;
					if(count == limit) {
						rs++;
						count = 0;
					}
						
					
					
				}
		//	}
			System.out.println("#" + tc + " " + rs);
		}
	}

}
