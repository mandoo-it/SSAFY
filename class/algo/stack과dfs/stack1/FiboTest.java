package stack;

public class FiboTest {
	//재귀 
	public static int fibo1(int n) {
		if(n < 2) return n;
		else return fibo1(n-1) + fibo1(n-2);
	}
	public static int[] memo;
	
	//memoization한 재귀;
	public static int fibo2(int n) {
		if(n >= 2 && memo[n] == 0) {
			memo[n] =  fibo2(n-1) + fibo2(n-2);
		}
		return memo[n];
	}
	
	//dp + memo
	public static int fibo3(int n) {
		for(int i=2;i<=n;i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		return memo[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		long start = System.currentTimeMillis();
//		System.out.println(fibo1(40));
//		long end = System.currentTimeMillis();
//		System.out.println((end  - start) + "ms"); // 중복호출로 인해 시간이 오래 걸린다.  -> memoization
		
//		long start = System.nanoTime();
//		memo = new int[100];
//		memo[0] = 0;
//		memo[1] = 1;
//		System.out.println(fibo2(40));//한번 호출한 값은 메모리에 저장하기 때문에 호출시간이 훨씬 줄어든다. - memoization
//		long end = System.nanoTime();
//		System.out.println((end  - start) + "ms");
		
		long start = System.nanoTime();
		memo = new int[100];
		memo[0] = 0;
		memo[1] = 1;
		System.out.println(fibo3(40));//dp사용
		long end = System.nanoTime();
		System.out.println((end  - start) + "ms");
		
	} 

}
