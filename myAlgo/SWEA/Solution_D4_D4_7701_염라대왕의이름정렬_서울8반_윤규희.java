import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution_D4_D4_7701_염라대왕의이름정렬_서울8반_윤규희 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			TreeSet<String> name = new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if(Integer.compare(o1.length(), o2.length()) == 0) {
						return o1.compareTo(o2);
					}
					return Integer.compare(o1.length(), o2.length());
				}
			
			});
			
			for(int i=0;i<N;i++) {
				String word = br.readLine();
				name.add(word);
			}
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + "\n");
			for(String s : name) {
				sb.append(s).append("\n");
			}
			System.out.println(sb);
			
		}
		

	}

}
