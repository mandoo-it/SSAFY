import java.util.Scanner;

public class Main_정올_11721_열개씩끊어출력_서울08_윤규희 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
		
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			count++;
			if(count % 10 == 0 && i > 0)
				System.out.println();
			
			
		}
	}
}
