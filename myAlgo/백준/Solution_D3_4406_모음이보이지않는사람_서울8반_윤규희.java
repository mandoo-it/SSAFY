import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_4406_모음이보이지않는사람_서울8반_윤규희 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			String word = br.readLine().replaceAll("([ieoua])", "");
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(word);
			System.out.println(sb);
		}
	}

}
