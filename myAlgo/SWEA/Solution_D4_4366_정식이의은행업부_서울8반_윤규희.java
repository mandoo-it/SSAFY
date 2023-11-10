import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_4366_정식이의은행업부_서울8반_윤규희 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       int T = Integer.parseInt(br.readLine());
	       for (int t = 1; t <= T; t++) {
	           long ans = -1;
	           String num1 = br.readLine();
	           String num2 = br.readLine();
	           char arr1[] = num1.toCharArray();
	           char arr2[] = num2.toCharArray();
	           for (int i = 0; i < arr1.length; i++) {
	               char arr1Save = arr1[i];
	               if (arr1[i] == '0') {
	                   arr1[i] = '1';
	               }
	               else {
	                   arr1[i] = '0';
	               }
	               for (int j = 0; j < arr2.length; j++) {
	                   char arr2Save = arr2[j];
	                   if (arr2[j] == '0') {
	                       arr2[j] = '1';
	                       ans = chk(arr1, arr2);
	                       if (ans != -1)
	                           break;
	                       arr2[j] = '2';
	                       ans = chk(arr1, arr2);
	                       if (ans != -1)
	                           break;
	                   } else if (arr2[j] == '1') {
	                       arr2[j] = '0';
	                       ans = chk(arr1, arr2);
	                       if (ans != -1)
	                           break;
	                       arr2[j] = '2';
	                       ans = chk(arr1, arr2);
	                       if (ans != -1)
	                           break;
	                   } else {
	                       arr2[j] = '0';
	                       ans = chk(arr1, arr2);
	                       if (ans != -1)
	                           break;
	                       arr2[j] = '1';
	                       ans = chk(arr1, arr2);
	                       if (ans != -1)
	                           break;
	                   }
	                   arr2[j] = arr2Save;
	               }
	               if (ans != -1)
	                   break;
	               arr1[i] = arr1Save;
	           }
	           System.out.printf("#%d %d\n", t, ans);
	       }
	   }
	   public static long chk(char arr1[], char arr2[]) {
	       long num1, num2;
	       num1 = num2 = 0;
	       for (int i = 0; i < arr1.length; i++) {
	           num1 = num1 * 2 + arr1[i] - '0';
	       }
	       for (int i = 0; i < arr2.length; i++) {
	           num2 = num2 * 3 + arr2[i] - '0';
	       }
	       if(num1 == num2) {
	           return num1;
	       }
	       else
	           return -1;
	   }

}
