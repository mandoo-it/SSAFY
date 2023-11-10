import java.util.Scanner;

public class Solution_1266_소수완제품확률_서울8반_윤규희 {
	static double sum1;
	static double sum2;
	
	private static double nCr(int n, int r) {
       if(r==0) return 1.0;
       return 1.0*n/r*nCr(n-1,r-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			double n1 = sc.nextInt();
			double n2 = sc.nextInt();
			sum1 = 0.0;
			sum2 = 0.0;
			sum1 += nCr(18,0)*Math.pow(n1/100,0)*Math.pow(1-(n1/100), 18-0);
			sum1 += nCr(18,1)*Math.pow(n1/100,1)*Math.pow(1-(n1/100), 18-1);
			sum1 += nCr(18,4)*Math.pow(n1/100,4)*Math.pow(1-(n1/100), 18-4);
			sum1 += nCr(18,6)*Math.pow(n1/100,6)*Math.pow(1-(n1/100), 18-6);
			sum1 += nCr(18,8)*Math.pow(n1/100,8)*Math.pow(1-(n1/100), 18-8);
			sum1 += nCr(18,9)*Math.pow(n1/100,9)*Math.pow(1-(n1/100), 18-9);
			sum1 += nCr(18,10)*Math.pow(n1/100,10)*Math.pow(1-(n1/100), 18-10);
			sum1 += nCr(18,12)*Math.pow(n1/100,12)*Math.pow(1-(n1/100), 18-12);
			sum1 += nCr(18,14)*Math.pow(n1/100,14)*Math.pow(1-(n1/100), 18-14);
			sum1 += nCr(18,15)*Math.pow(n1/100,15)*Math.pow(1-(n1/100), 18-15);
			sum1 += nCr(18,16)*Math.pow(n1/100,16)*Math.pow(1-(n1/100), 18-16);
			sum1 += nCr(18,18)*Math.pow(n1/100,18)*Math.pow(1-(n1/100), 18-18);
			
			sum2 += nCr(18,0)*Math.pow(n2/100,0)*Math.pow(1-(n2/100), 18-0);
			sum2 += nCr(18,1)*Math.pow(n2/100,1)*Math.pow(1-(n2/100), 18-1);
			sum2 += nCr(18,4)*Math.pow(n2/100,4)*Math.pow(1-(n2/100), 18-4);
			sum2 += nCr(18,6)*Math.pow(n2/100,6)*Math.pow(1-(n2/100), 18-6);
			sum2 += nCr(18,8)*Math.pow(n2/100,8)*Math.pow(1-(n2/100), 18-8);
			sum2 += nCr(18,9)*Math.pow(n2/100,9)*Math.pow(1-(n2/100), 18-9);
			sum2 += nCr(18,10)*Math.pow(n2/100,10)*Math.pow(1-(n2/100), 18-10);
			sum2 += nCr(18,12)*Math.pow(n2/100,12)*Math.pow(1-(n2/100), 18-12);
			sum2 += nCr(18,14)*Math.pow(n2/100,14)*Math.pow(1-(n2/100), 18-14);
			sum2 += nCr(18,15)*Math.pow(n2/100,15)*Math.pow(1-(n2/100), 18-15);
			sum2 += nCr(18,16)*Math.pow(n2/100,16)*Math.pow(1-(n2/100), 18-16);
			sum2 += nCr(18,18)*Math.pow(n2/100,18)*Math.pow(1-(n2/100), 18-18);
			
			double total = 1 - (sum1 * sum2);
			System.out.printf("#%d %.6f\n",tc , total);
			
		}
	}

}
//2 3 5 7 11 13 17  (1,4,6,8,9,10,12,14,15,16,18)