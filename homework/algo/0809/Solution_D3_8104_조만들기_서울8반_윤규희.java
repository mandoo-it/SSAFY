import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_8104_조만들기_서울8반_윤규희 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int rs = 1;
			
			for(int i=1;i<n;i++) {
				if(i % 2 != 0)
					rs += (i+1) * k;
				else 
					rs += i * k + 1;
			}
			System.out.print("#" + tc + " ");
			for(int i=1;i<=k;i++) {
				if(n % 2 == 0)
					System.out.print(rs + " ");
				else 
					System.out.print((rs + i - 1 ) + " ");
			}
			System.out.println();
			
			
		}
	}

}
