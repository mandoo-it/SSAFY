import java.util.Scanner;

public class Solution_백준_1110_더하기사이클_서울8반_윤규희 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         
        int number = n;
        int count = 0;
         
        do {
            number = number % 10 * 10 + (number / 10 + number % 10) % 10;
            count++;
        } while (n != number);
         
        System.out.println(count);
    }
}
