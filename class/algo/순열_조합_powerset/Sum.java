package array2;

public class Sum {
	public static int sum(int n) {
		if(n > 0)
			return n+sum(n-1);
		else
			return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(100));
		
	}

}
