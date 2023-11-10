import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution_1244_최대상금 {
	static char[] arr;
    static int change;
    static int max;
  
    static int answer;
    
	
    static void dfs(int count) {
		int num = Integer.parseInt(new String(arr));
		
		if(count == change) {
			if(num > max)
				max = num;
			return;
		}
		
		for (int i = 0; i < arr.length; i++)
	    {
	        for (int j = i+1; j < arr.length; j++)
	        {
	        	if(arr[i] - '0' <= arr[j] - '0') {
	        		swap(i, j);
	        		dfs(count+1);
                    swap(i, j);
                }
	            
	        }
	    }
		
	}
	
    public static void swap(int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
 
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_1244.txt"));
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for(int tc=1; tc<=T; tc++) {
        	max = 0;
        	String s = sc.next();
            change = sc.nextInt();
            arr = s.toCharArray();
            dfs(0);
            System.out.println("#" + tc + " " + max);
        }
    }
}