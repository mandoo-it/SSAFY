import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_7728_다양성측정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1;tc<=T;tc++) {
			String s = br.readLine();
			char[] arr = s.toCharArray();
			char[] arr2 = new char[arr.length];
			String news = "";
			for(int i=0;i<s.length();i++) {
				if(!news.contains(s.substring(i, i+1))) {
					news += s.substring(i,i+1);
				}
						
			}
			System.out.println("#" + tc + " " + news.length());
		}
	}
}
