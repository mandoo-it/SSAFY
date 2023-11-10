package array1;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D1_2063_중간값찾기_서울8반_윤규희
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] arr = new int[tc];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		int middle = arr[0];
		Arrays.sort(arr);
		middle = arr[tc/2];
		System.out.println(middle);
		sc.close();
	}
}