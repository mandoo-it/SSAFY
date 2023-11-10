package 다시해봅시다아자화이팅;

import java.util.Scanner;

public class Main_정올_1658_최대공약수와최소공배수_서울8반_윤규희 {
	static int gcd(int n1, int n2) {
		if(n2 == 0) 
			return n1;
		return gcd(n2, n1%n2);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int result = 0;
		if(n1 > n2) result = gcd(n1, n2);
		else  result = gcd(n2, n1);
		
		System.out.println(result);
		System.out.println(n1 * n2 /result);
		
	}

}
