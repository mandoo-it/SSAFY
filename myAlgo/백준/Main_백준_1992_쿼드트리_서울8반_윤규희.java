import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1992_쿼드트리_서울8반_윤규희 {
	static char[][] arr;
	static String result = "";
	
	static void divide(int sy, int sx, int len) {
		char start = arr[sy][sx];
		Boolean check = false;
		
		
		for(int i=sy;i<sy+len;i++) {
			for(int j=sx;j<sx+len;j++) {
				if(arr[i][j] != start) {
					check = true;
				}
			}
		}
		
		if(check) {
			result += "(";
			divide(sy, sx , len /2);
			divide(sy, sx + len/2 , len /2);
			divide(sy+len/2, sx , len /2);
			divide(sy+len/2, sx+len/2 , len /2);
			result += ")";
		} else {
			if(start == '1') result += "1";
			else result += "0";
		}
	
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j] =  s.charAt(j);
			}
		}
		
		divide(0, 0, N);
		System.out.println(result);
		
		
	}
	
	
	

}
