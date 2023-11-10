import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Soultion_조만들기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int rs = 1;
			
			int[] sum = new int[k];
			int num = 1;
			for (int i = 0; i < n; i++) {
				for(int j=0;j<k;j++) {
					if(i % 2 == 0) {
						sum[j] += num;
					} else {
						sum[k-j-1] += num;
						
					}
					num++;
				}
			}
			System.out.println(Arrays.toString(sum));
			
		}
	}
}


