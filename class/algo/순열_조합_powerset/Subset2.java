package array2;

//powerset 부분집합을 비트연산으로
public class Subset2 {
	public static int[] data = {1,2,3,4};
	public static int[] bit = new int[4];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2^4
		/*
		 0 0000
		 1 0001
		 2 0010
		 3 0011
		 4 0100
		 5 0101
		 6 0110
		 7 0111
		 8 1000
		 9 1001
		10 1010
		11 1011
		12 1100
		13 1101
		14 1110
		15 1111
		 * */
		for(int i=0; i<(1<<data.length);i++) {
			int sum = 0;
			for(int j=0;j<data.length;j++) 
			{
				if((i & (1<<j))>0) {
					System.out.print(data[j] + " ");
					sum = sum + data[j];
				}
			}
			System.out.println("sum=" + sum);
		}

	}

}
